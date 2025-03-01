package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlbumCromoDAO {

    private List<Cromo> album;
    private List<Cromo> caixa_repes;
    private List<Cromo> album_random;

    private final int NUM_MAX_COLECCION;

    public AlbumCromoDAO(int num) {
    	
        album = new ArrayList<>();
        caixa_repes = new ArrayList<>();
        album_random = new ArrayList<>();
        this.NUM_MAX_COLECCION = num;
        
        album_random.add(new Cromo(5, "Cromo5", TipoBrawler.EPICO));
        album_random.add(new Cromo(6, "Cromo6", TipoBrawler.EPICO));
        album_random.add(new Cromo(7, "Cromo7", TipoBrawler.EPICO));
      
    }
    
    
    public void listarCromos() {
    	
    	if (album.isEmpty()) {
    		
            System.out.println("No hi ha cromos en la colecció.");

    	}
    	else {
    		
            System.out.println("Cromos normals:");
    		for(Cromo cromo : album) {
    			System.out.println(cromo);
    			
    		}
    		
    		 if(caixa_repes.isEmpty()) {
    			 
    	            System.out.println("No tens cromos repetis.");
    			 
    		 }
    		 else {
    			 
    			 
 	            System.out.println("Cromos repetits:");
    			 for(Cromo cromo_repe : caixa_repes) {
    	     			System.out.println(cromo_repe);
    	     			
    	     		}
    			 
    		 }
     		
    		
    	}
    	
    }
    
    
    
    /**
     * Afegeix el cromo a la nostra col·lecció 
     * @param afegir Cromo que vull afegir al  album
     * @return true si s'afegeix /false si es fica a repes
     * @throws NumberOutofAlbum quant el cromo a afegir no es de la col·lecció
     */
    public boolean afegirCromo(Cromo afegir) throws NumberOutofAlbum
            {
    	
                    if (afegir.getNum()> NUM_MAX_COLECCION)
                    {
                        throw new NumberOutofAlbum(NUM_MAX_COLECCION);
                    }
                    else
                    {
                        if (album.contains(afegir)) 
                        {
                            caixa_repes.add(afegir);
                            return false;
                        }
                        else
                        {
                            album.add(afegir);
                            return true;
                        }  
                    }
            }
    
    public boolean afegirCromo(int num_cromo, String nom_cromo, TipoBrawler tipus) throws NumberOutofAlbum
    {
        Cromo afegir = new Cromo(num_cromo, nom_cromo, tipus);
        return this.afegirCromo(afegir);
        
    }
    
    public boolean eliminarCromo(int numero_cromo) throws CromoNoExisteix {
    	
    	  Iterator<Cromo> iterator = album.iterator();
    	  
    	    while (iterator.hasNext()) {
    	        Cromo cromo = iterator.next();
    	        if (cromo.getNum() == numero_cromo) {
    	            iterator.remove(); 
    	            return true;
    	        }
    	    }
    	    
    	    throw new CromoNoExisteix();
    	
    	
    }
    
    //TODO
    public void SustituirCromo(Cromo sustituir) {
    	
    	
    }
    
    //TODO
    //Només cambio si em fa falta 
    public void CambiarPatio(Cromo earn, Cromo give) {}
	
}
