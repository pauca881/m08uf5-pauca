package app;

import java.util.ArrayList;
import java.util.Scanner;

import model.PokemonDAO;

public class app {
	
	static Scanner scanner = new Scanner(System.in);
	static ArrayList array = new ArrayList<>();


	public static void main(String[] args) {
        
		
		//Carregar dades de prova
        PokemonDAO pokemonDAO = new PokemonDAO();
        pokemonDAO.carregar_dades_prova();

		
		
		run();
		
		
	}


	private static void run() {
		
		
		


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

//DADES SQL
//
//CREATE DATABASE entrenadors_pokemon;
//USE entrenadors_pokemon;
//

// NOTA: el unique key es fa perque no es puguin posar entrenadors amb el mateix name
// unique_name es el nom de la restricció

//CREATE TABLE entrenadors (
//	    id INT AUTO_INCREMENT PRIMARY KEY,
//	    name VARCHAR(255) NOT NULL,
//	    password VARCHAR(255) NOT NULL,
//	    UNIQUE KEY unique_name (name)
//	);

//CREATE TABLE pokemon (
//	    num_pokedex INT PRIMARY KEY,
//	    name VARCHAR(255) NOT NULL,
//	    type VARCHAR(255) NOT NULL,
//	    UNIQUE KEY unique_pokedex (num_pokedex)
//	);

//TAULA pokemons capturats
//CREATE TABLE pokemons_capturats (
//	    id INT AUTO_INCREMENT PRIMARY KEY,
//	    entrenador_id INT,
//	    pokedex_number INT,
//	    forca_combat INT DEFAULT NULL,
//	    FOREIGN KEY (entrenador_id) REFERENCES entrenadors(id) ON DELETE CASCADE,
//	    FOREIGN KEY (pokedex_number) REFERENCES pokemon(pokedex_number) ON DELETE CASCADE
//	);




