package imc;

import javax.swing.SwingUtilities;

import vista.VentanaPrincipal;

public class IMC {
	

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override	
			public void run() {
					VentanaPrincipal window = new VentanaPrincipal();
				}
			
			
			
		});
		
	}

}
