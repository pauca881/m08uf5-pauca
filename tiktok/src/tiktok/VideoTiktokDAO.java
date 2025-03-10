package tiktok;
import java.util.*;

import Model.VideoTiktok;

public class VideoTiktokDAO {

private List<VideoTiktok> videos;
    
    public VideoTiktokDAO() {
        this.videos = new ArrayList<>();
    }
    
    // Mètode privat que retorna l'ID màxim
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
    }
    
    public boolean eliminarVideo() {
        if (!videos.isEmpty()) {
            videos.remove(0);
            return true;
        }
        return false;
    }
    
    public List<VideoTiktok> llistarVideosUsuariPopulars(String usuari) {
        List<VideoTiktok> videosUsuari = new ArrayList<>();
        
        for (VideoTiktok video : videos) {
            if (video.getUsuari().equals(usuari)) {
                videosUsuari.add(video);
            }
        }
        
        // Ordenem per popularitat (likes) de més a menys
        Collections.sort(videosUsuari, Collections.reverseOrder());
        
        // Mostrem els vídeos utilitzant un for-each
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
        
        // Ordenem per títol
        Collections.sort(videosUsuari, new TitolComparator());
        
        // Mostrem els vídeos utilitzant un for clàssic amb get()
        System.out.println("Vídeos de l'usuari " + usuari + " ordenats per títol (for clàssic):");
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
        
        // Ordenem per durada
        Collections.sort(videosUsuari, new DuradaComparator());
        
        // Mostrem els vídeos utilitzant un Iterator
        System.out.println("Vídeos de l'usuari " + usuari + " ordenats per durada (Iterator):");
        Iterator<VideoTiktok> iterator = videosUsuari.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
        return videosUsuari;
    }
    
    /*
     * Resposta: No té sentit programar un mètode que substitueixi un vídeo sencer per un altre,
     * ja que a TikTok un cop pujat un vídeo, aquest té una identitat pròpia amb el seu ID,
     * comptador de likes, comentaris, etc. Si es vol canviar un vídeo, normalment s'elimina
     * l'anterior i se'n puja un de nou. El que sí que té sentit és modificar certs atributs
     * com el títol o descripció.
     */
    
    public boolean modificarVideo(VideoTiktok videoAModificar, String nouTitol) {
        // A TikTok només es pot modificar el títol/descripció d'un vídeo un cop pujat
        for (VideoTiktok video : videos) {
            if (video.equals(videoAModificar)) {
                video.setTitol(nouTitol);
                return true;
            }
        }
        return false;
    }
}
	

