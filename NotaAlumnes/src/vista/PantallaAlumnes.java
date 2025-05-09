package vista;

import javax.swing.JFrame;

import model.GestorAlumnesDAO;

public class PantallaAlumnes extends JFrame{
	
	
	public PantallaAlumnes(GestorAlumnesDAO model) {
		
		
		setTitle("Gestió d'alumnes");
		setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //centra la pantalla quan s'obre
        setLocationRelativeTo(null);

		
		carregarPanell(model);
		setVisible(true);
		
		
	}

	private void carregarPanell(GestorAlumnesDAO model) {

			this.setContentPane(new PanellAlumnes(model));
		
	}

}
