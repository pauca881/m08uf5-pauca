package dades;

import java.util.List;
import java.util.Map;
import model.Assistent;

public interface GestorAssistentsInterface {

  
    /* Afegeix un nou assistent a la llista interna */
    void afegirAssistent(Assistent a);

    /* Retorna la llista completa d�assistents */
    List<Assistent> getTots();

    /* Calcula i retorna l�edat mitjana dels assistents */
    double calcularEdatMitjana();

}
