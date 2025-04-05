package model;

public class Pokemon {

	private int numero_pokedex;
	private String name;
	private String type;

	public Pokemon() {}

	public Pokemon(int numero_pokedex, String name, String type) {
	    this.numero_pokedex = numero_pokedex;
	    this.name = name;
	    this.type = type;
	}

	public int getNumero_pokedex() {
	    return numero_pokedex;
	}

	public void setNumero_pokedex(int numero_pokedex) {
	    this.numero_pokedex = numero_pokedex;
	}

	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public String getType() {
	    return type;
	}

	public void setType(String type) {
	    this.type = type;
	}

	
	@Override
    public String toString() {
        return "Pokemon{" +
                "numero_pokedex=" + numero_pokedex +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
	
	
}
