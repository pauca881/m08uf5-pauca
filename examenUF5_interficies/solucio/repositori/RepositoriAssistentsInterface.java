package repositori;

/**
 *
 * @author usuari
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import model.Assistent;

public interface RepositoriAssistentsInterface {

    /* Carrega els assistents des d�un fitxer de text donat i els retorna com una llista d'objectes Assistent.
       El fitxer ha de contenir les dades separades per comes. 
       Pot llan�ar excepcions si el fitxer no existeix o si hi ha errors de lectura. */
    List<Assistent> carregarAssistents(String nom_fitxer) throws FileNotFoundException, IOException;

    /* Desa un objecte Assistent al fitxer especificat.
       Afegeix la informaci� en format CSV al final del fitxer. */
    void guardarAssistent(Assistent a);

    /* Genera un informe en un fitxer de text amb el total d'assistents, l�edat mitjana 
       i un resum de la quantitat d�assistents per tipus d�entrada. */
    void generarInforme(String informe, List<Assistent> assistents, double edatMitjana,
                        Map<String, Integer> perTipus);
}

