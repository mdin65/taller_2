package src.servicio;
import src.modelo.Dado;
import src.modelo.Jugador;

public class JuegoVersus {
    private Jugador jugador1;
    private Jugador jugador2;
    private int rondasParaGanar;
    private Dado dado;

    public JuegoVersus(Jugador jugador1, Jugador jugador2, int rondasTotales) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.rondasParaGanar = (rondasTotales / 2) + 1;
        this.dado = new Dado();
    }


    public Jugador JugarPartida() {
        int puntajeJ1 = 0;
        int puntajeJ2 = 0;
        int rondaActual = 1;

        System.out.println("---COMIENZA LA PARTIDA---");
        System.out.println("El primero en ganar" + this.rondasParaGanar + "rondas será el vencedor");
        System.out.println("-----------------------------------------");

        while (puntajeJ1 < this.rondasParaGanar && puntajeJ2 < this.rondasParaGanar) {
            System.out.println("=== Ronda : " + rondaActual);


            System.out.println("Turno de " + jugador1.getNombre() + ": ");
            dado.lanzar();
            int resultadoJ1 = dado.getValor();
            System.out.println("Ha obtenido: " + resultadoJ1);


            System.out.println("Turno de " + jugador2.getNombre() +": ");
            dado.lanzar();
            int resultadoJ2 = dado.getValor();
            System.out.println("Ha obtenido: " + resultadoJ2);

            if (resultadoJ1 > resultadoJ2) {
                puntajeJ1++;
                System.out.println(jugador1.getNombre() + "ha ganado la partida!!");

            } else if (resultadoJ2 > resultadoJ1) {
                puntajeJ2++;
                System.out.println(jugador2.getNombre() + "ha ganado la partida!");

            } else {
                System.out.println("EMPATE!!!");
            }


            System.out.println("Marcador: " + jugador1.getNombre() + " [" + puntajeJ1 + "] - [" + puntajeJ2 + "] " + jugador2.getNombre());
            rondaActual++;
        }

        System.out.println("------------------------------------");
        if (puntajeJ1 == this.rondasParaGanar) {
            return jugador1;
        } else {
            return jugador2;

        }
    }
}
