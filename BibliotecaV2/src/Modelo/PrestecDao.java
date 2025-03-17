/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author mabardaji
 */
public class PrestecDao {
    //colecccin de datos
    //mantenerlos (Alta/Baja/....)
    Map<Persona, Set<String>> Prestec;

    public PrestecDao() {
        Prestec = new HashMap<>();
    }

    public boolean afegirPrestec(Persona add, String titulo) {
        //comprovar si la persona existeix
        //ho comprovo perque si existeix 
        if (!Prestec.containsKey(add)) //no existe
        {
           Prestec.put(add, new HashSet<>());
        }
        
        //a�ado el libro 
        //si existe a�ado libro
        return Prestec.get(add).add(titulo);  
    }

    public Set<String> ListaLibrosPrestados(Persona found) {
        if (!Prestec.containsKey(found))
        {
            return new HashSet<>(); //conjunt buit
        }
        else
            return Prestec.get(found);
        
       // return Prestec.getOrDefault(found, new HashSet<String>());
    }

    public Set<String> encontrarLibrosUnicos(Persona p) {
        Set<String> misLibros = Prestec.get(p); //Obtenemos el valor de la clave.
        Set<String> misLibrosCopia = new HashSet<>(misLibros);
        for (Map.Entry<Persona, Set<String>> entry : Prestec.entrySet()) {
            Persona key = entry.getKey();
            
                Set<String> val = entry.getValue();

             if (key.getDNI()!=p.getDNI()){
                misLibrosCopia.removeAll(val);
             }

            
            /*if (key.getDNI() != p.getDNI()) {
                for (String titulo : val) {
                misLibrosCopia.remove(titulo);
            }
            }*/
            
        }
        return misLibrosCopia;
    }
    

    
    public void pruebaLibrosUnicos()
    {
        // Adding elements in the first set
        Set<String> s1 = new HashSet<>();
        s1.add("Geek1");
        s1.add("Geek2");
        s1.add("Geek3");
        s1.add("Geek4");
             System.out.println(s1);
        // Adding elements in the second set
        Set<String> s2 = new HashSet<>();
        s2.add("Geek3");
        s2.add("Geek4");
             System.out.println(s2);
        System.out.println("Set1 before removeAll(): " 
        + s1);

        // Remove all elements of s2 from s1
        s1.removeAll(s2);

        System.out.println("Set1 after removeAll(): " 
        + s1);
    
    }
}
