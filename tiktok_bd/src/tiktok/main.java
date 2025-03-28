package tiktok;

import java.util.List;

import Model.VideoTiktok;

public class main {
    public static void main(String[] args) {
    	
    	   /*
         * Respon a la pregunta dins el codi, si estem treballant per l’aplicació TikTok, 
         * te sentit, programar un mètode que substitueixi un vídeo sencer per un altre.
         * 
         * no no té sentit, cada video teu el seu propi id, tindria sentit esborrar-lo i crear un nou
         * si que podriem cambiar camps com titol o altres, pero no tindria sentit substituir
         * 
         */
    	
    	VideoTiktokDAO dao = new VideoTiktokDAO();
        
    	
    	dao.afegirVideo("user1", "Ballant a la platja", 1500, 15.5);
        dao.afegirVideo("user1", "Tutorial de maquillatge", 3000, 45.2);
        dao.afegirVideo("user1", "Challenge viral", 10000, 20.0);
        dao.afegirVideo("user2", "Recepta fàcil", 500, 60.0);
        dao.afegirVideo("user2", "Dia a dia", 2000, 30.0);
        
        System.out.println("\n=== LLISTAT DE VÍDEOS PER POPULARITAT ===");
        dao.llistarVideosUsuariPopulars("user1");
        
        System.out.println("\n=== LLISTAT DE VÍDEOS PER TÍTOL ===");
        dao.llistarVideosUsuariTitol("user1");
        
        System.out.println("\n=== LLISTAT DE VÍDEOS PER DURADA ===");
        dao.llistarVideosDurada("user1");
        
        System.out.println("\n=== MODIFICACIÓ DE VÍDEO ===");
        List<VideoTiktok> videosUser1 = dao.llistarVideosUsuariTitol("user1");
        if (!videosUser1.isEmpty()) {
        	VideoTiktok videoAModificar = videosUser1.get(0);
            System.out.println("Vídeo abans de modificar: " + videoAModificar);
            
            dao.modificarVideo(videoAModificar, "Nou títol actualitzat");
            
            System.out.println("Vídeos després de modificar:");
            dao.llistarVideosUsuariTitol("user1");
        }
        
        // prova eliminació vídeo
        System.out.println("\n=== ELIMINACIÓ DE VÍDEO ===");
        boolean eliminat = dao.eliminarVideo();
        System.out.println("Vídeo eliminat: " + eliminat);
        System.out.println("Vídeos restants:");
        dao.llistarVideosUsuariPopulars("user1");
    }
}

