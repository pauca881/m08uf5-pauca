package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
    
	//private List<Llibre> llibres = new ArrayList<>();
    //private List<Persona> persones = new ArrayList<>();
    //private List<Préstec> prestecs = new ArrayList<>();

	
    //aquest metode afegeix la persona sino existeix (putIfAsbsent)
    public void afegirPersona(Persona persona) {
        prestamos.putIfAbsent(persona, new HashSet<>());
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
    
    public void delete(Persona persona, Llibre llibre) {
    	
    	//amb això guardo un set dels llibres de prestamos
        Set<String> llibresPrestats = prestamos.get(persona);
        
        //si no esta buit i conté el llibre exacte
        if (llibresPrestats != null && llibresPrestats.contains(llibre.getNomLlibre())) {
        	
        	//docncs borro el llibre exacte
        	llibresPrestats.remove(llibre.getNomLlibre());
        }
        	
        	System.out.println( persona.getNomPersona() + " no té el llibre " + llibre.getNomLlibre() + " en préstec");
        }
    
   
    public void llistar() {
    	
    	//Entry es una interfaç de java amb dos Valors entry<X, y> ( clau valor )
    	
    	//IMPORTANT
		//bàsicament en el for diem -> Persona, Set<String> = prestamos(clave, valor)
    	
    	for (Map.Entry<Persona, Set<String>> entry : prestamos.entrySet()) {
    		
    		
            Persona persona = entry.getKey();
            Set<String> llibres = entry.getValue();
            
            //getKey es la clau del Map
            //getValue es el valor de la clau del MAP
            
            System.out.println(persona.getNomPersona() + " té els següents llibres en préstec: " + llibres);
            
        }
    	
    }

    	
    	
       
}
