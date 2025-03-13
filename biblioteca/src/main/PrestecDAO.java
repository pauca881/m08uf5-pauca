package main;

import java.util.ArrayList;
import java.util.List;

import model.Llibre;
import model.Persona;
import model.Préstec;


public class PrestecDAO {

	
	private List<Llibre> llibres = new ArrayList<>();
    private List<Persona> persones = new ArrayList<>();
    private List<Préstec> prestecs = new ArrayList<>();

	
    public void afegirLlibre(Llibre llibre) {
        llibres.add(llibre);
    }
    
    public void afegirPersona(Persona persona) {
    	persones.add(persona);
    }
    
    public void afegirPrestec(Persona persona, Llibre llibre) {
    	
    	if(persones.contains(persona) && llibres.contains(llibre)) {
    		
    		Préstec prestec = new Préstec(persona, llibre);
    		prestecs.add(prestec);
            System.out.println("Nou prèstec afegit");

    		
    	}
    	
    	else if(persones.contains(persona) && !llibres.contains(llibre)) {
    		
    		
    		llibres.add(llibre);
    		Préstec prestec = new Préstec(persona, llibre);
    		prestecs.add(prestec);
            System.out.println("Nou prèstec afegit");

    		
    		
    	}
    	
    		else if(!persones.contains(persona) && llibres.contains(llibre)) {
    		
    		persones.add(persona);
    		Préstec prestec = new Préstec(persona, llibre);
    		prestecs.add(prestec);
            System.out.println("Nou prèstec afegit");

    		
    	}
    		else {
    			
    			persones.add(persona);
        		llibres.add(llibre);

        		Préstec prestec = new Préstec(persona, llibre);
        		prestecs.add(prestec);
                System.out.println("Nou prèstec afegit");

        		
    			
    		}
    	
    	
    	
    }
    
    public void delete(Persona persona) {
    	
    	
    	
    	
    }

    
}
