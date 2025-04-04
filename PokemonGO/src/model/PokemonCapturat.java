package model;

public class PokemonCapturat {

	 private int identificador;

	    private Entrenador entrenador;

	    private Pokemon pokemon;

	    private Integer forca_combat;

	    public PokemonCapturat() {}

	    public PokemonCapturat(Entrenador entrenador, Pokemon pokemon, Integer forçaDeCombats) {
	        this.entrenador = entrenador;
	        this.pokemon = pokemon;
	        this.forca_combat = forca_combat;
	    }

	    public int getIdentificador() {
	        return identificador;
	    }

	    public void setIdentificador(int identificador) {
	        this.identificador = identificador;
	    }

	    public Entrenador getEntrenador() {
	        return entrenador;
	    }

	    public void setEntrenador(Entrenador entrenador) {
	        this.entrenador = entrenador;
	    }

	    public Pokemon getPokemon() {
	        return pokemon;
	    }

	    public void setPokemon(Pokemon pokemon) {
	        this.pokemon = pokemon;
	    }

	    public Integer getForçaDeCombats() {
	        return forca_combat;
	    }

	    public void setForçaDeCombats(Integer forçaDeCombats) {
	        this.forca_combat = forca_combat;
	    }
	
}
