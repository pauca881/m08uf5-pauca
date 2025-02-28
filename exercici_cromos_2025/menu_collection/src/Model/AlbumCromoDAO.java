package Model;

import java.util.ArrayList;
import java.util.List;

public class AlbumCromoDAO {

    private List<Cromo> album;
    private List<Cromo> caixa_repes;
    private final int NUM_MAX_COLECCION;

    public AlbumCromoDAO(int num) {
    	
        album = new ArrayList<>();
        caixa_repes = new ArrayList<>();
        this.NUM_MAX_COLECCION = num;
        
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
	
}
