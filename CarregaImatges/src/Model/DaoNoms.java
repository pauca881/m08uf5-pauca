package Model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DaoNoms {

	
	List<String> noms;

	//Array as List es inmutable ( no modificable )
	// ArrayList si es mutable
    public DaoNoms() {
        noms = Arrays.asList("Ash", "Misty", "Brock", "Iris", "Gary", "Serena", "Tracey");
    }

    public List<String> getNoms() {
        return noms;
    }
    
    public String getEntrenadorAleatori()
    {
        Random rd = new Random();
        return noms.get(rd.nextInt(noms.size()));
    }
    
    public String getEntrenadorPosicio(int i)
    {
        Random rd = new Random();
        return noms.get(i);
    }
    
    public int getNumEntrenadors()
    {
        return noms.size();
    }
	
}
