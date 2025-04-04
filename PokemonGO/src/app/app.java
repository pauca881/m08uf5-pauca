package app;

import java.util.ArrayList;
import java.util.Scanner;

public class app {
	
	static Scanner scanner = new Scanner(System.in);
	static ArrayList array = new ArrayList<>();


	public static void main(String[] args) {
        
		run();
		
		
	}

	private static void run() {


		show_menu();
		
	}

	private static void show_menu() {


	        int opcio;

	        do {

	            System.out.println("----- Menú PGO -----");
	        	 System.out.println("0. Salir");
	             System.out.println("1. Dar de alta entrenador");
	             System.out.println("2. Dar de baja entrenador");
	             System.out.println("3. Consultar Datos Entrenador");
	             System.out.println("4. Listar Entrenadores");
	             System.out.println("5. Dar de alta Pokemon");
	             System.out.println("6. Cazar pokemon");
	             System.out.println("7. Listar Pokemons cazados");
	             System.out.println("8. Listar tipos Pokemon existentes en juego");
	            
	            opcio = scanner.nextInt();
	            
	            switch (opcio) {
	            case 0:
	                System.out.println("Saliendo del programa...");
	                break;
	            case 1:
	                System.out.println("Dar de alta entrenador");
	                break;
	            case 2:
	                System.out.println("Dar de baja entrenador");
	                break;
	            case 3:
	                System.out.println("Consultar Datos Entrenador");
	                break;
	            case 4:
	                System.out.println("Listar Entrenadores");
	                break;
	            case 5:
	                System.out.println("Dar de alta Pokemon");
	                break;
	            case 6:
	                System.out.println("Cazar pokemon");
	                break;
	            case 7:
	                System.out.println("Listar Pokemons cazados");
	                break;
	            case 8:
	                System.out.println("Listar tipos Pokemon existentes en juego");
	                break;
	            default:
	                System.out.println("Opción no válida. Intente de nuevo.");
	            }
	            System.out.println();  
	        } while (opcio != 4);  
	        
	        scanner.close();  
	    }
		
	

	
}
