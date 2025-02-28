package Model;

public class NumberOutofAlbum extends Exception{

	
	public NumberOutofAlbum(int num) {
		
        super("Cromo excedeix el numero maxim de la col·lecció " + num);
		
	}
	
}
