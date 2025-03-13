package model;

public class Llibre {
	
	private String nom_llibre;
	
	//constructor
	public Llibre(String nom_llibre) {
		this.nom_llibre = nom_llibre;
	}
	
	//getters y setters
	public String getNomLlibre() {
		
		return nom_llibre;
		
	}
	
	public void setNomLlibre(String nom_llibre) {
		
		this.nom_llibre = nom_llibre;
		
	}
	
	//tostring
	@Override
	public String toString() {
		return "Llibre: " + nom_llibre;
	}

}
