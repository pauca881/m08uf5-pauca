package Model;

public class DAOImatges {

	
		private String[] rutesImatges = {"001.png", "002.png"};
	    private int indexActual;
	    
	    public DAOImatges() {
	        indexActual = 0;
	    }
	    
	    public String carregarNovaImatge()
	    {
	    	//El operador % (módulo) asegura que el índice se reinicie a 0 cuando llegue al final del array
	    	// después de 002 volverá a 001
	        indexActual = (indexActual + 1) % rutesImatges.length;
	        return rutesImatges[indexActual];
	    }
	    
	    public String getImatgeActual()
	    {
	        return rutesImatges[indexActual];
	    }

	
}
