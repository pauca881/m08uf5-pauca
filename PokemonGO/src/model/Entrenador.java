package model;

import java.util.Set;

public class Entrenador {

	 	private int id;
	 	    
	    private String nombre;
	    
	    private String contrasena;
	    
	    private Set<PokemonCapturat> pokemons_capturats;

	    public Entrenador() {}

	    public Entrenador(String nombre, String contrasena) {
	        this.nombre = nombre;
	        this.contrasena = contrasena;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int identificador) {
	        this.id = identificador;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getContrasena() {
	        return contrasena;
	    }

	    public void setContrasena(String contrasena) {
	        this.contrasena = contrasena;
	    }

	    
	    //Ho faig amb sets perque així ja no em ficarà elements duplicats
	    public Set<PokemonCapturat> getPokemonCapturados() {
	        return pokemons_capturats;
	    }

	    public void setPokemonCapturados(Set<PokemonCapturat> pokemonCapturados) {
	        this.pokemons_capturats = pokemonCapturados;
	    }
	
}
