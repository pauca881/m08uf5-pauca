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
	
}
