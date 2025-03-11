package practicaset;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import Model.Persona;

import java.util.ArrayList;
import java.util.Collections;

public class main {

	
    public static void main(String[] args) {
    	
    	
    	//Hashset es com un array que permet no afegir elements repetits
    	 Set<String> nomsConjuntH = new HashSet<>();
         nomsConjuntH.add("Justin");
         nomsConjuntH.add("Jose Miguel");
         nomsConjuntH.add("Solaymane");
         nomsConjuntH.add("Joan");
         
         System.out.println("HasShet: es un conjunt que no l'importa el ordre");
         System.out.println(nomsConjuntH);
         
         //LinkedHashset es com el Hash, pero desa l'ordre d'inscripció
         Set<String> nomsConjuntLH = new LinkedHashSet<>();
         nomsConjuntLH.add("Harpreet");
         nomsConjuntLH.add("Jeremy");
         nomsConjuntLH.add("Elena");
         nomsConjuntLH.add("David");
         nomsConjuntLH.add("Juan");
         
         
         System.out.println("LinkedHashSet: es un conjunt que si l'importa el ordre");
         System.out.println(nomsConjuntLH);
         
         //TreeSet ordena per ordre natural ( ordre alfabètic, no permet duplicats )
         //Amb el comparator l'ordenarem com voldrem, en aquest cas, al revés amb Collections.reverseOrder
         Set<String> nomsConjuntT = new TreeSet<>(Collections.reverseOrder());
         nomsConjuntT.add("Juan");
         nomsConjuntT.add("Wenfu");
         nomsConjuntT.add("Jordi Joan");
         nomsConjuntT.add("Miquel Angel");
         
         System.out.println("Treemap: Ordenat per comparable ");
         System.out.println(nomsConjuntT);
         
         nomsConjuntT.remove("Miquel Angel");
         System.out.println("Treemap: Borrat element ");
         System.out.println(nomsConjuntT + " size " + nomsConjuntT.size());
         
         if(nomsConjuntT.contains("Wenfu"))
         {
             System.out.println("Existeix wenfu al conjunt");
         }
         
         
         
         Set<String> nomsConjuntT1 = new TreeSet<>();
         //Set<String> nomsConjuntT = new TreeSet<>(clase que implementi comparator);
         nomsConjuntT1.add("Juan1");
         nomsConjuntT1.add("Wenfu1");
         nomsConjuntT1.add("Jordi Joan");
         nomsConjuntT1.add("Miquel Angel");
         
         
         //interseccion es una copia de nomsConjuntT
         //retainAll fa que només quedin els elements iguals de nomsConjuntT i nomsConjuntLH
         Set<String> interseccion = new TreeSet<>(nomsConjuntT);
         
         
         interseccion.retainAll(nomsConjuntLH);
         System.out.println("elementos interseccion " + interseccion);

         
         //trueure elements repetis A-B
         System.out.println("Conjunt T");
         System.out.println(nomsConjuntT);
         System.out.println("Conjunt T1");
         System.out.println(nomsConjuntT1);
         Set<String> diferencia = new TreeSet<>(nomsConjuntT);
         diferencia.removeAll(nomsConjuntT1);
         System.out.println("A-B" + diferencia);
         
         System.out.println(nomsConjuntT);
         System.out.println(nomsConjuntH);
         Set<String> union = new TreeSet<>(nomsConjuntT);
         union.addAll(nomsConjuntLH);
         System.out.println("A union B" + union);
         
         //EXERCICI SET
         ArrayList<Persona> personas = new ArrayList<>();
         Random random = new Random();
         
         for (int i = 0; i < 10; i++) {
             int notaFinal = random.nextInt(10) + 1;  //nota aleatoria entre 1 y 10
             int edad = random.nextInt(10) + 16;  //edad rnadom entre 16 y 25
             personas.add(new Persona(notaFinal, edad));
         }
         
         
         //SET PERSONES APROVADES
         Set<Persona> persones_aprovades = new HashSet<>();
         
         for (Persona persona : personas) {
             if (persona.getNotaFinal() >= 5) {
            	 persones_aprovades.add(persona);
             }
         }
         
         //SET PERSONES SUSPESES
         Set<Persona> persones_suspeses = new HashSet<>();

         for (Persona persona : personas) {
             if (persona.getNotaFinal() < 5) {
            	 persones_suspeses.add(persona);
             }
         }
         
         //SET PERSONES MENORS D'EDAT
         Set<Persona> majors_edat = new HashSet<>();

         for (Persona persona : personas) {
             if (persona.getEdad() >= 18) {
            	 majors_edat.add(persona);
             }
         }
         
         //SET PERSONES MAJORS D'EDAT
         Set<Persona> menors_edat = new HashSet<>();

         for (Persona persona : personas) {
             if (persona.getEdad() < 18) {
            	 menors_edat.add(persona);
             }
         }
         
         //Interseccio per trobar valors iguals
         //Amb el retainAll, guardo els items que son iguals tant a menors_edat com a persones_aprovades
         Set<Persona> menors_edat_aprovats = new HashSet<>(menors_edat);
         menors_edat_aprovats.retainAll(persones_aprovades);
         
         Set<Persona> menors_edat_no_aprovats = new HashSet<>(menors_edat);
         menors_edat_no_aprovats.retainAll(persones_suspeses);
         
         Set<Persona> majors_edat_no_aprovats = new HashSet<>(majors_edat);
         majors_edat_no_aprovats.retainAll(persones_suspeses);
         
         //Cambiar aquest for depenen del array que vulguis veure
         for(Persona persona : menors_edat_aprovats) {
        	 
             System.out.println("Menor edat aprovat: ");
             System.out.println(persona);

        	 
         }

         

         
    	
    	
    }
    
    
	
}
