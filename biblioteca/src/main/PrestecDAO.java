package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.Llibre;
import model.Persona;
import model.Préstec;


public class PrestecDAO {

	//map per associar cada persona amb els llibres prestats con los libros prestados
	//el set string es guardaràn els llibres
    private Map<Persona, Set<String>> prestamos = new HashMap<>();
    
	private List<Llibre> llibres = new ArrayList<>();
    private List<Persona> persones = new ArrayList<>();
    private List<Préstec> prestecs = new ArrayList<>();

	
    //aquest metode afegeix la persona sino existeix (putIfAsbsent)
    public void afegirPersona(Persona persona) {
        prestamos.putIfAbsent(persona, new HashSet<>());
    }
    
    public void mostrar_prestecs() {
    	
    	
    	
    	
    }
    
    public void afegirPrestec(Persona persona, Llibre llibre) {
    	
    	//primer, si persona no existeix al hashmap, l'afegim
        if (!prestamos.containsKey(persona)) {
            afegirPersona(persona);  
        }
        
        //associem el llibre a la persona	
        prestamos.get(persona).add(llibre.getNomLlibre());
        System.out.println("Préstec afegit: " + persona.getNomPersona() + " - " + llibre.getNomLlibre());

    	
    	
    }
    
    public void delete(Persona persona) {
    	
    	
    	
    	
    }

    
}
