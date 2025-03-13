package model;

public class Préstec {

	
	private Persona persona;
	private Llibre llibre;
	
	//constructor
	public Préstec(Persona persona, Llibre llibre) {
		
		this.persona = persona;
		this.llibre = llibre;
		
	}
	
		
	public Persona getPersona() {
	    return persona;
	}

	public void setPersona(Persona persona) {
	    this.persona = persona;
	}

	public Llibre getLlibre() {
	    return llibre;
	}

	public void setLlibre(Llibre llibre) {
	    this.llibre = llibre;
	}

	@Override
	public String toString() {
	    return "Nou Préstec. L'usuari : " + persona + " ha pres el llibre: " + llibre;
	}

	
	
}
