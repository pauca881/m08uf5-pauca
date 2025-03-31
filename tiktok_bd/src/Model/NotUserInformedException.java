package Model;

public class NotUserInformedException extends Exception {

	
    public NotUserInformedException() {
        super("Debes informar usuario");
    }

    public NotUserInformedException(String user) {
        super("El usuario tiene que tener 4 caracteres , tu user es " + user);
    }
	
	
}
