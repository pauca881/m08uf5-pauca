package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class GestorAlumnesDAO {

	private List<Persona> alumnes;
	private int indexActual = 0;
	
	public GestorAlumnesDAO(){
		
		
		alumnes = new ArrayList<>();
		Random rd = new Random();
		
		for(int i = 1; i <=10; i++) {
			
            alumnes.add(new Persona("Alumne " + i, "DNI" + i, rd.nextDouble()*10));
		}
		
	
		
	}
	
	public Persona getActual() {
		
		return alumnes.get(indexActual);
		
	}
	
	public void guardarNotaActual(double nota) throws NumberFormatException {
		
		if (nota < 0 || nota > 10) {
			
			throw new NumberFormatException("Introdueix una nota vàlida entre 0 i 10");
			
		}
		else {
			
            alumnes.get(indexActual).setNota(nota);
			
		}
	}
	
	
	public boolean hiha_seguent() {
		
		return indexActual < alumnes.size() - 1;

		
	}
	
	public boolean hiha_anterior() {
		
		
		return indexActual > 0;
		
	}
	
	public void seguent() {
		
		if(hiha_seguent()) indexActual++;
		
	}
	
	public void anterior() {
		
		if(hiha_anterior()) indexActual--;
		
	}
	
}
