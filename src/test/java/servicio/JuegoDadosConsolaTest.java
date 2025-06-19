package servicio;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class JuegoDadosConsolaTest {

    @Test
    void testFlujoCompletoMostrarDados() {
        // Configurar entrada simulada (1 = Jugar, 2 = Salir, S = Confirmar)
        String input = "1\n2\nS\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Redirigir System.out para capturar la salida
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Ejecutar el juego
        JuegoDadosConsola consola = new JuegoDadosConsola();
        consola.iniciarJuego();

        // Restaurar System.in y System.out
        System.setIn(System.in);
        System.setOut(System.out);

        // Verificar que se muestran los valores de los dados
        String output = outContent.toString();
        assertTrue(output.contains("Dado 1:"));
        assertTrue(output.contains("Dado 2:"));
        assertTrue(output.contains("Suma:"));

        // Verificar formato
        assertTrue(output.matches("(?s).*Dado 1: \\d+.*Dado 2: \\d+.*Suma: \\d+.*"));
    }
}