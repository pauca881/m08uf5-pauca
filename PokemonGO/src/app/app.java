package app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Entrenador;
import model.EntrenadorDAO;
import model.PokemonDAO;

public class app {
	
	static Scanner scanner = new Scanner(System.in);
	static ArrayList array = new ArrayList<>();

    static EntrenadorDAO entrenadorDAO;


	public static void main(String[] args) throws SQLException {
        
		
		//Carregar dades de prova
        PokemonDAO pokemonDAO = new PokemonDAO();
        pokemonDAO.carregar_dades_prova();

        EntrenadorDAO entrenadorDAO = new EntrenadorDAO();

		
		
		run();
		
		
	}


	private static void run() throws SQLException {
		
		
		


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
	                alta_entrenador();
	                break;
	            case 2:
	                System.out.println("Dar de baja entrenador");
	                borrar_entrenador();
	                break;
	            case 3:
	                System.out.println("Consultar Datos Entrenador");
	                break;
	            case 4:
	                System.out.println("Listar Entrenadores");
	                llistar_entrenadors();
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


	private static void borrar_entrenador() {

		
        System.out.print("Introdueix el nom de l'entrenador que vols donar de baixa: ");
        String nombre = scanner.nextLine();
        
        
        boolean entrenador_esborrat = entrenadorDAO.EsborrarEntrenador(nombre);
        
        if(entrenador_esborrat) {
            System.out.print("L'entrenador " + nombre + " s'ha esborrat perfecte") ;

        	
        }else {
            System.out.print("L'entrenador " + nombre + " no s'ha esborrat. Comprova que existeixi. ") ;
        	
        }
       
		
		
	}


	private static void alta_entrenador() {

        System.out.print("Introdueix el nom de l'entrenador: ");
        String nombre = scanner.nextLine();

        System.out.print("Introdueix la contrasenya de l'entrenador: ");
        String contrasena = scanner.nextLine();

        Entrenador entrenador = new Entrenador(nombre, contrasena);

        boolean entrenador_creat = entrenadorDAO.AltaEntrenador(entrenador);
		
        if(entrenador_creat) {
        	
            System.out.print("El entrenador s'ha creat correctament: ");

        	
        }else {
        	
            System.out.print("No s'ha pogut donar d'alta l'entrenador: ");

        	
        	
        }

		
		
	}


	private static void llistar_entrenadors() throws SQLException {

		
		List<Entrenador> entrenadors_actuals = entrenadorDAO.LlistarEntrenadors();
		
	    if (entrenadors_actuals != null && !entrenadors_actuals.isEmpty()) {
	    	
	        for (Entrenador entrenador : entrenadors_actuals) {
	            System.out.println("ID: " + entrenador.getId() + ", Nom: " + entrenador.getNombre() + ", Password: " + entrenador.getContrasena());
	        }
	    } else {

	        System.out.println("No hi ha entrenadors a la bbdd");
	    }
		
		
		
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




