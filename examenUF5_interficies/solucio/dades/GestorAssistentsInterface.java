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

        /* Compta quants assistents hi ha per cada tipus d�entrada i retorna un mapa */
    Map<String, Integer> comptarPerTipusEntrada();

    /* Retorna el nombre total d�assistents registrats */
    int totalAssistents();

     /* Carrega una llista inicial d�assistents i retorna quants s�han afegit */
    int carregaLlistaAssistents(List<Assistent> inicial);

}
