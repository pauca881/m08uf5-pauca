
package albumcromosmvc;

import java.util.Scanner;
import Model.AlbumCromoDAO;
import Model.Cromo;
import Model.TipoBrawler;
import Model.NumberOutofAlbum;

/**
 *
 * @author Pauk
 */
public class AlbumCromosMVC {

    /** VISTA /CONTROLADOR (Interaccion amb el usuari/informar/
     * @param args the command line arguments
     */
	
    public static void main(String[] args) {
        AlbumCromosMVC app = new AlbumCromosMVC();
        app.run();
    }

    
    private void run() {
    	
    	AlbumCromoDAO album = new AlbumCromoDAO(100); //Màxim 100 cromos
    	Scanner scanner = new Scanner (System.in);
    	int opcio;
    	
    	do {
            System.out.println("===== MENÚ PRINCIPAL =====");
            System.out.println("0. Listar cromos");
            System.out.println("1. Agregar cromo");
            System.out.println("2. Borrar Cromo");
            System.out.println("3. Cambiar cromoss");
            System.out.println("4. Salir");
            System.out.print("Elige una opción (1-4): ");
            
            opcio = scanner.nextInt();
            
            switch (opcio) {
            case 0:
            	album.listarCromos();
            	break;
                case 1:
                	System.out.print("Ingresa el número del cromo: ");
                	
                    int numCromo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingresa el nombre del cromo: ");
                    String nombreCromo = scanner.nextLine();

                    System.out.print("Ingresa el tipo de Brawler: ");
                    String tipo = scanner.nextLine();
                    TipoBrawler brawlerTipo = TipoBrawler.valueOf(tipo.toUpperCase());
                    
                    try {
                        Cromo cromoNuevo = new Cromo(numCromo, nombreCromo, brawlerTipo);
                        boolean agregado = album.afegirCromo(cromoNuevo);
                        if (agregado) {
                            System.out.println("Cromo agregado exitosamente.");
                        } else {
                            System.out.println("Este cromo ya existe, se ha añadido a la caja de repes.");
                        }
                    } catch (NumberOutofAlbum e) {
                        System.out.println("El número del cromo excede el límite de la colección.");
                    }
                    break;

                case 2:
                    System.out.println("Has elegido la Opción 2.");
                    break;
                case 3:
                    System.out.println("Has elegido la Opción 3.");
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción entre 1 y 4.");
            }
            
            //Linea en blanc
            System.out.println(); 
            
        } while (opcio != 4); 
        
        scanner.close();
        
    }
        
    }
    
    
    
    
    
