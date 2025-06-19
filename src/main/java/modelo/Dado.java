package modelo;

import java.util.Random;


public class Dado {
    private int valor;


    public void lanzar() {
        Random rand = new Random();
        valor = rand.nextInt(6) + 1; // de 1 a 6
    }


    public int getValor() {
        return valor;
    }
}
