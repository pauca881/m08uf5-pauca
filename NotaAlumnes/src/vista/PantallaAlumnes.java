package vista;

import javax.swing.JFrame;

import model.GestorAlumnesDAO;

public class PantallaAlumnes extends JFrame{
	
	
	public PantallaAlumnes(GestorAlumnesDAO model) {
		
		
		carregarPanell(model);
		
		
	}

	private void carregarPanell(GestorAlumnesDAO model) {

			this.setContentPane(new PanellAlumnes(model));
		
	}

}
