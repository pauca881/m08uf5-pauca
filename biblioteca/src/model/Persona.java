package model;

public class Persona {

		private String nom_persona;
		
		//constructor
		public Persona(String nom_persona) {
			
			this.nom_persona = nom_persona;	 
			
		}
		
		//getters i setters
		public String getNomPersona() {
			
			return nom_persona;
			
		}
		
		public void setNomPersona(String nom_persona) {
			
			this.nom_persona = nom_persona;	 

			
		}
		
		//tostring
		@Override 
	    public String toString() {
	        return "Persona: " + nom_persona;
	    }
}
		
