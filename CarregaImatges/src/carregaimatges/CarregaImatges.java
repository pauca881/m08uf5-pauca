package carregaimatges;

import javax.swing.SwingUtilities;

import Vista.PantallaImatges;

public class CarregaImatges {
	
	public static void main(String[] args) {
		
		
        SwingUtilities.invokeLater(() -> {
            PantallaImatges finestra = new PantallaImatges();
            finestra.setVisible(true);
        });
		
		
	}

}
