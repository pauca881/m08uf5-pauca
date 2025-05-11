package model;

import javax.swing.SwingUtilities;
import vista.VentanaPrincipal;

public class calculIMC {
	
	
public double IMCCalc(double height, double weight) {
		
		double IMC = weight / (height*height);
		return IMC;
		
	}

}
