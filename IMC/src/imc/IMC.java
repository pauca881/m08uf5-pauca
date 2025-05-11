package imc;

public class IMC {
	
	public double IMCCalc(double height, double weight) {
		
		double IMC = weight / (height*height);
		return IMC;
		
	}

}
