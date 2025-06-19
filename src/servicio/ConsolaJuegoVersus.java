package src.servicio;

import src.modelo.Jugador;
import java.util.Scanner;

public class ConsolaJuegoVersus {
    private Scanner scanner;

    public ConsolaJuegoVersus() {
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("Juego de Dados Versus!");

        while (true) {
            System.out.print("Ingrese el nombre del Jugador 1: ");
            String nombreJ1 = scanner.nextLine();
            Jugador j1 = new Jugador(nombreJ1.isEmpty() ? "Jugador 1" : nombreJ1);

            System.out.print("Ingrese el nombre del Jugador 2: ");
            String nombreJ2 = scanner.nextLine();
            Jugador j2 = new Jugador(nombreJ2.isEmpty() ? "Jugador 2" : nombreJ2);

            int rondas = elegirModoDeJuego();

            JuegoVersus juego = new JuegoVersus(j1, j2, rondas);
            Jugador ganador = juego.JugarPartida();

            System.out.println("\n¡¡¡ LA PARTIDA HA TERMINADO !!!");
            System.out.println("🎉 El ganador es: " + ganador.getNombre().toUpperCase() + " 🎉");

            if (!confirmarJugarDeNuevo()) {
                break;
            }
        }

        System.out.println("GRACIAS POR JUGAR! HASTA LA PRÓXIMA!");
        scanner.close();
    }

    private int elegirModoDeJuego() {
        System.out.println("\nSeleccione el modo de juego:");
        System.out.println("1. Al primer intento (1 ronda)");
        System.out.println("2. Al mejor de 3 rondas");
        System.out.println("3. Al mejor de 5 rondas");

        int opcion;
        while (true) {
            System.out.print("Ingrese su opción (1-3): ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1: return 1;
                    case 2: return 3;
                    case 3: return 5;
                    default:
                        System.out.println("Opción inválida. Por favor, ingrese 1, 2 o 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
            }
        }
    }

    private boolean confirmarJugarDeNuevo() {
        System.out.print("\n¿Desean jugar otra partida? (S/N): ");
        String respuesta = scanner.nextLine().trim().toUpperCase();
        return respuesta.equals("S");
    }
}