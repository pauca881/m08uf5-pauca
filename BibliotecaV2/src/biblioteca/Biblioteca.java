/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package biblioteca;

import Modelo.Persona;
import Modelo.PrestecDao;
import Vista.BibliotecaView;
import Vista.Menu;
import Vista.OptionDuplicateException;
import java.util.List;
import java.util.Set;

/**
 *
 * @author mabardaji
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Biblioteca app = new Biblioteca();
        app.run();
    }

    private void run() {
            int opcion_menu;
            //Clase Modelo
            PrestecDao coleccion = new PrestecDao();
            //clase vista

            BibliotecaView vista = new BibliotecaView();
            Menu men = new Menu("Men� Tiktok", true);
            
            anyadirOpciones(men);
            Persona uno = new Persona("1", "N1");
            coleccion.afegirPrestec(uno, "titulo1");
            coleccion.afegirPrestec(uno, "titulo2");
            coleccion.afegirPrestec(uno, "titulo3");
            Persona dos = new Persona("2", "N2");
            coleccion.afegirPrestec(dos, "titulo1");
            do{
                men.displayMenu();
                opcion_menu = men.chooseOption();
                if (opcion_menu==1)
                {//pedir datos y a�adir video
                    Persona add = vista.DatosPersona();
                    String titulo = vista.DatosTitulo();
                    
                    if (coleccion.afegirPrestec(add, titulo))
                    {
                        vista.mostrarMensaje("A�adido nuevo prestamo " + add + " ha cogido " + titulo);
                    }

                }
                else if (opcion_menu == 2)
                {
                    
//                    VideoTikTok delete = vista.newVideo();
//                    if (coleccion.eliminarVideo(delete))
//                    {
//                        vista.mostrarMensaje("Borrado " + delete.getTitol() + "del usuario " 
//                                + delete.getUsuari());
//                    }
//                    else
//                    {
//                        vista.mostrarMensaje("No se ha encontrado " + delete.getTitol() + "del usuario " 
//                                + delete.getUsuari());
//                    }

                }
                else if (opcion_menu == 3)
                {
                    String DNI = vista.pedirDNI();
                    //Persona found = vista.DatosPersona();
                    Persona found = new Persona(DNI, "Inventado");
                    Set<String> Libros = coleccion.ListaLibrosPrestados(found);
                    vista.ListarLibros(Libros);
//                    List<VideoTikTok> listaTotal = coleccion.llistarVideosUsuariPopulars(usuari);
//                    vista.mostrarMensaje("Lista videos mas populares" + usuari);
//                    vista.listado(listaTotal);
                }
                else if (opcion_menu == 4)
                {
                    String DNI = vista.pedirDNI();
                    Persona p = new Persona(DNI, "Si");
                    Set<String> LibrosUnicos = coleccion.encontrarLibrosUnicos3(p);
                    vista.ListarLibros(LibrosUnicos);
//                    String usuari = vista.pedirUsuario();
//                    List<VideoTikTok> listaTotal = coleccion.llistarVideosUsuariTitol(usuari);
//                    vista.mostrarMensaje("Lista videos Titulo" + usuari);
//                    vista.listadoGet(listaTotal); //diferents
                }             
                else if (opcion_menu == 5)
                {//Listar Album
//                    String usuari = vista.pedirUsuario();
//                    List<VideoTikTok> listaTotal = coleccion.llistarVideosDurada(usuari);
//                    vista.mostrarMensaje("Lista videos duracion" + usuari);
//                    vista.listadoIterator(listaTotal); //diferent maneres
                }
            }while (opcion_menu!=0);        
    }
    



    private void anyadirOpciones(Menu men) {
        try {
            men.addOption("Afegir Llibre");
            men.addOption("Tornar Llibre");
            men.addOption("Llistar Llibre Prestat Usuari");
            men.addOption("Llibres exclusius usuari");
            men.addOption("Aficions comuns");
        } catch (OptionDuplicateException ex) {
            System.out.println(ex.getMessage());
        }
    }
       

}
