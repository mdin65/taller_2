package servicio;

import modelo.Dado;

public class JuegoDeDados {
    private Dado dado1;
    private Dado dado2;
    private Calculadora calc;


    public JuegoDeDados() {
        dado1 = new Dado();
        dado2 = new Dado();
        calc = new Calculadora();
    }


    public String jugar() {
        dado1.lanzar();
        dado2.lanzar();
        int suma = calc.sumar(dado1.getValor(), dado2.getValor());


        System.out.println("Dado 1: " + dado1.getValor());
        System.out.println("Dado 2: " + dado2.getValor());
        System.out.println("Suma: " + suma);


        if (suma == 7) {
            return "¡Ganaste!";
        } else {
            return "Perdiste.";
        }
    }
}
