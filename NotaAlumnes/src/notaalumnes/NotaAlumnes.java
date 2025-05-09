package notaalumnes;

import javax.swing.SwingUtilities;
import model.GestorAlumnesDAO;
import vista.PantallaAlumnes;

public class NotaAlumnes {
	
	public static void main(String[] args) {
		
		GestorAlumnesDAO model = new GestorAlumnesDAO();
		
		SwingUtilities.invokeLater(() -> {
			
			PantallaAlumnes finestra = new PantallaAlumnes(model);
			finestra.setVisible(true);
			
		}
		
		);
		
	}

}
