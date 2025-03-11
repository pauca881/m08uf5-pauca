package Model;

import java.util.ArrayList;
import java.util.Random;

public class Persona {
    private int notaFinal;
    private int edad;

    //cconstructor
    public Persona(int notaFinal, int edad) {
        this.notaFinal = notaFinal;
        this.edad = edad;
    }

    public int getNotaFinal() {
        return notaFinal;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Nota Final: " + notaFinal + ", Edad: " + edad;
    }
}


