package servicio;

import java.util.Scanner;
import modelo.Dado;


public class JuegoDadosConsola {
    private JuegoDeDados juego;
    private Scanner scanner;

    public JuegoDadosConsola() {
        this.juego = new JuegoDeDados();
        this.scanner = new Scanner(System.in);
    }

    public void iniciarJuego(){
        boolean salir = false;
        while(!salir) {
            mostrarMenu();
            int opcion = leerOpcion();

            switch(opcion) {
                case 1:
                    System.out.println("---¡HORA DE JUGAR!---");
                    String resultado = juego.jugar();
                    System.out.println("El resultado es: " + resultado);
                    break;

                    case 2:
                        if(confirmarSalida()){
                            salir = true;
                            System.out.println("GRACIAS POR JUGAR! - SALIENDO DE LA APLICACIÓN");
                        }
                        break;
                        default:
                            System.out.println("Opción inválida. Intente nuevamente.");
            }
            System.out.println();

        }

        scanner.close();
    }
    private void mostrarMenu() {
        System.out.println("======= Menú Principal: ======");
        System.out.println("1. Jugar");
        System.out.println("2. Salir");
        System.out.println("Ingrese su opcion: ");
    }


    private int leerOpcion() {
        while(!scanner.hasNextInt()) {
            System.out.println("Opcion invalida. Intente nuevamente.");
            scanner.next();
            System.out.println("Ingrese su opcion: ");
        }
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;


    }
    private boolean confirmarSalida() {
        System.out.println("Está segurx que desea salir?(S/N)");
        String respuesta = scanner.nextLine().trim().toUpperCase();
        return respuesta.equals("S");
    }
}

