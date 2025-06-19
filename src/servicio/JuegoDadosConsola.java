import java.util.Scanner;
import src.servicio.JuegoDeDados;
package src.servicio;


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
    }





}
