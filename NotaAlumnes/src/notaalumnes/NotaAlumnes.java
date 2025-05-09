package notaalumnes;

import javax.swing.SwingUtilities;
import model.GestorAlumnesDAO;
import vista.PantallaAlumnes;

public class NotaAlumnes {
	
	public static void main(String[] args) {
		
		GestorAlumnesDAO model = new GestorAlumnesDAO();
		
		//Assegura que el codi que interactua amb la interfaç gràfica
		//s'executi en el fil correcte: Event Dispatch Thread
		
		//Sense anar a fons, fa que tot el codi s'executi en un únic fil,
		//no està dissenyat perque diferents fils modifiquin la interfaç gràfica
		
		SwingUtilities.invokeLater(() -> {
			
			PantallaAlumnes finestra = new PantallaAlumnes(model);
			finestra.setVisible(true);
			
		}
		
		);
		
	}

}
