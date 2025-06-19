package main;

import org.example.servicio.JuegoDeDados;

public class Inicio {
    public static void main(String[] args) {
        JuegoDeDados juego = new JuegoDeDados();
        String resultado = juego.jugar();
        System.out.println("Resultado del juego: " + resultado);
    }
}
