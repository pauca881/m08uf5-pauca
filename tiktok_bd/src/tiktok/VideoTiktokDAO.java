package tiktok;
import java.util.*;

import Model.VideoTiktok;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

            // Crear el PreparedStatement
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
    	        VideoTiktok videoAEliminar = videos.get(0); // Obtener el primer video

    	        // Conexión SQL y PreparedStatement para eliminar el video
    	        try (Connection conn = DbConnect.getConnection()) {
    	            if (conn != null) {
    	                String sql = "DELETE FROM videos WHERE id = ?";  // Consulta para eliminar el video
    	                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
    	                    pstmt.setString(1, videoAEliminar.getTitol()); // Establecer el titol del video a eliminar

    	                    int rowsAffected = pstmt.executeUpdate();  // Ejecutar la eliminación
    	                    System.out.format("%d rows deleted\n", rowsAffected);

    	                    // Eliminar también del listado en memoria
    	                    videos.remove(0);

    	                    return rowsAffected > 0; // Si se eliminó alguna fila, retornamos true
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
    
    public List<VideoTiktok> llistarVideosDurada(String usuari) {
        List<VideoTiktok> videosUsuari = new ArrayList<>();
        
        for (VideoTiktok video : videos) {
            if (video.getUsuari().equals(usuari)) {
                videosUsuari.add(video);
            }
        }
        
        Collections.sort(videosUsuari, new DuradaComparator());
        
        System.out.println("Vídeos de l'usuari " + usuari + " ordenats per durada peero amb itiretator");
        Iterator<VideoTiktok> iterator = videosUsuari.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
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
	

