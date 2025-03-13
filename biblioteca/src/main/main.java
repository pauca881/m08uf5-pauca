package main;

import java.util.Scanner;

import model.Persona;
import model.Llibre;


public class main {
	
	static Scanner scanner = new Scanner(System.in);
	static PrestecDAO prestecDAO = new PrestecDAO();

	
    public static void main(String[] args) {
    	
    	
        Persona pau = new Persona("Pau");
        Persona miquel = new Persona("Miquel");
        
        Llibre llibre1 = new Llibre("llibreAA");
        Llibre llibre2 = new Llibre("llibreBB");
        Llibre llibre3 = new Llibre("llibreCC");
        Llibre llibre4 = new Llibre("llibreDD");

        prestecDAO.afegirPersona(pau);
        prestecDAO.afegirPersona(miquel);

        prestecDAO.afegirPrestec(pau, llibre1);
        prestecDAO.afegirPrestec(pau, llibre2);
        prestecDAO.afegirPrestec(miquel, llibre3);

        
    	mostrar_menu();
    	
    	
        
    }

	
    public static void mostrar_menu() {
    	
    	


        	int opcio;
        
        do {
            System.out.println("***** Menú biblio *****");
            System.out.println("1. Afegir préstec");
            System.out.println("2. Eliminar préstec");
            System.out.println("3. Mostra llibres amb préstec per usuari");
            System.out.println("4. Llibres no prestats a altres usuaris");
            System.out.println("5. Crear grups de lectura");
            System.out.println("6. Sortir");
            System.out.print("Tria una opció (1-5): ");
            
            opcio = scanner.nextInt();
            
            switch (opcio) {
            	case 0:
            		System.out.println("adeuu");
            		break;
                case 1:
                    System.out.println("Escriu el nom de la persona: ");
                    String nom = scanner.nextLine();
                    
                    System.out.println("Escriu el llibre: ");
                    String llibre = scanner.nextLine();
                    
                    add_prestec(nom, llibre);

                    break;
                case 2:
                    System.out.println("Escriu el nom de la persona:");
                    String nom_a_esborrar = scanner.nextLine();
                    
                    System.out.println("Escriu el llibre que vols tornar:");
                    String llibre_a_esborrar = scanner.nextLine();
                    
                    esborrar(nom_a_esborrar, llibre_a_esborrar);

                    break;
                case 3:
                	prestecDAO.llistar();
                	break;
                case 4:
                    System.out.println("Has seleccionat l'Opció 4.");
                    break;
                case 5:
                    System.out.println("Has seleccionat l'Opció 5.");
                    break;
                case 6:
                    System.out.println("Sortint del programa...");

                default:
                    System.out.println("Opció no vàlida. Prova una altra vegada.");
            }
            
            System.out.println();

        } while (opcio != 6);
        
    	
    }


	private static void esborrar(String nom_a_esborrar, String llibre_a_esborrar) {

        Persona persona = new Persona(nom_a_esborrar);
        Llibre llibre = new Llibre(llibre_a_esborrar);
		prestecDAO.delete(persona, llibre);
		
		
		
	}


	private static void add_prestec(String nom, String llibre) {

        Persona persona = new Persona(nom);
        Llibre nou_llibre = new Llibre(llibre);

        prestecDAO.afegirPrestec(persona, nou_llibre);

		
	}
	

}
