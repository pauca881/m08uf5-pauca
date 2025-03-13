package main;

import java.util.Scanner;

public class main {
	
    public static void main(String[] args) {
    	
    	
    	mostrar_menu();
    	
        
    }

	
    public static void mostrar_menu() {
    	
    	
        Scanner scanner = new Scanner(System.in);

        
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
                case 1:
                    System.out.println("Has seleccionat l'Opció 1.");
                    break;
                case 2:
                    System.out.println("Has seleccionat l'Opció 2.");
                    break;
                case 3:
                    System.out.println("Has seleccionat l'Opció 3.");
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
	

}
