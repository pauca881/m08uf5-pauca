package tiktok;
import java.util.*;

import Model.VideoTiktok;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VideoTiktokDAO {

private List<VideoTiktok> videos;
    
    public VideoTiktokDAO() {
        this.videos = new ArrayList<>();
    }
    
    // mètode privat ja que no ha de ser accessible desde fora
    private int retornarIdMaxim() {
        if (videos.isEmpty()) {
            return 1;
        }
        
        int maxId = 0;
        for (VideoTiktok video : videos) {
            // No podem accedir directament a l'ID, però podem obtenir-lo del toString
            String videoStr = video.toString();
            int startIndex = videoStr.indexOf("id=") + 3;
            int endIndex = videoStr.indexOf(",", startIndex);
            int id = Integer.parseInt(videoStr.substring(startIndex, endIndex));
            
            if (id > maxId) {
                maxId = id;
            }
        }
        
        return maxId + 1;
    }
    
    public void afegirVideo(String usuari, String titol, int likes, double durada) {
        int nouId = retornarIdMaxim();
        VideoTiktok nouVideo = new VideoTiktok(nouId, usuari, titol, likes, durada);
        videos.add(nouVideo);
        
        //part sql
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = DbConnect.getConnection();

            String sql = "INSERT INTO videos (id, usuari, titol, likes, durada) VALUES (?, ?, ?, ?, ?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, nouId);
            pstmt.setString(2, usuari);
            pstmt.setString(3, titol);
            pstmt.setInt(4, likes);
            pstmt.setDouble(5, durada);

            int files_afectades = pstmt.executeUpdate();

            if (files_afectades > 0) {
                System.out.println("Els videos s'han afegit correctament");
            } else {
                System.out.println("No s'ha pogut insertar el video");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        
    }
    
    //poso remove 0 ja que borrarà el primer ( posició )
    //todo borrar video
    public boolean eliminarVideo() {
    	
    	//mètode antic
        //if (!videos.isEmpty()) {
          //  videos.remove(0);
          //  return true;
        //}
        //return false;  	
    	
    	 System.out.println("Executing: " + (new Exception()).getStackTrace()[0].getMethodName());

    	    if (!videos.isEmpty()) {
    	        VideoTiktok videoAEliminar = videos.get(0); //aqui agafo el primer video
    	        
    	        try (Connection conn = DbConnect.getConnection()) {
    	            if (conn != null) {
    	                String sql = "DELETE FROM videos WHERE titol = ?"; 
    	                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
    	                    pstmt.setString(1, videoAEliminar.getTitol());

    	                    int files_afectades = pstmt.executeUpdate(); 
    	                    System.out.format("%d files esborrades\n", files_afectades);

    	                    //també elimino el video de la llista normal
    	                    videos.remove(0);

    	                    return files_afectades > 0; // si alguna fila s'ha eliminat, tornem true
    	                }
    	            }
    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
    	    }
    	    return false; // Si no se encontró video o no se eliminó nada
    	
    }
    
    public List<VideoTiktok> llistarVideosUsuariPopulars(String usuari) {
        List<VideoTiktok> videosUsuari = new ArrayList<>();
        
        for (VideoTiktok video : videos) {
            if (video.getUsuari().equals(usuari)) {
                videosUsuari.add(video);
            }
        }
        
        // aqui ordeno per popularitat (likes) de més a menys
        Collections.sort(videosUsuari, Collections.reverseOrder());
        
        System.out.println("Vídeos de l'usuari " + usuari + " ordenats per popularitat (for-each):");
        for (VideoTiktok video : videosUsuari) {
            System.out.println(video);
        }
        
        return videosUsuari;
    }
    
    public List<VideoTiktok> llistarVideosUsuariTitol(String usuari) {
        List<VideoTiktok> videosUsuari = new ArrayList<>();
        
        for (VideoTiktok video : videos) {
            if (video.getUsuari().equals(usuari)) {
                videosUsuari.add(video);
            }
        }
        
        // ordeno utilitzant el comparator creat
        Collections.sort(videosUsuari, new TitolComparator());
        
        System.out.println("Vídeos de l'usuari " + usuari + " ordenats per títol:");
        for (int i = 0; i < videosUsuari.size(); i++) {
            System.out.println(videosUsuari.get(i));
        }
        
        return videosUsuari;
    }
    
    public List<VideoTiktok> llistarVideosDurada(String usuari) throws SQLException {
        List<VideoTiktok> videosUsuari = new ArrayList<>();
        
        
        //mètode antic
//        for (VideoTiktok video : videos) {
//            if (video.getUsuari().equals(usuari)) {
//                videosUsuari.add(video);
//            }
//        }
        
//        Collections.sort(videosUsuari, new DuradaComparator());
//        
//        System.out.println("Vídeos de l'usuari " + usuari + " ordenats per durada peero amb itiretator");
//        Iterator<VideoTiktok> iterator = videosUsuari.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//        
//        return videosUsuari;
        
        
        Connection conn = null;
        String sql = "SELECT * FROM videos WHERE usuari = ? ORDER BY durada";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {


        	preparedStatement.setString(1, usuari);

            ResultSet resultSet = preparedStatement.executeQuery();
            

            while (resultSet.next()) {
            	
                int id = resultSet.getInt("id");
                String user = resultSet.getString("usuari");
                String titol = resultSet.getString("titol");
                int likes = resultSet.getInt("likes");
                double durada = resultSet.getDouble("durada");
                
                VideoTiktok video = new VideoTiktok(id, user, titol, likes, durada);
                videosUsuari.add(video);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }

        System.out.println("Vídeos de l'usuari " + usuari + " ordenats per durada");
        for (VideoTiktok video : videosUsuari) {
            System.out.println(video);
        }

        return videosUsuari;
        
        
        
        
    }
    
    
    public boolean modificarVideo(VideoTiktok videoAModificar, String nouTitol) {
        
    	//només modifico el titol ja que es només el que em permet modificar ( es l'únic que té Set )
    	
        for (VideoTiktok video : videos) {
                video.setTitol(nouTitol);
        }
        return true;
    }
}
	

