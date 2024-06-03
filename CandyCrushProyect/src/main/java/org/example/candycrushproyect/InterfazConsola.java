
package org.example.candycrushproyect;
import java.util.Scanner;

import org.example.candycrushproyect.Jugador;

public class InterfazConsola {
    private Tablero tablero;
    private Jugador jugador;
    private Scanner scanner;

    public InterfazConsola(String nombreJugador) {
        this.tablero = new Tablero();
        this.jugador = Jugador.getReference(nombreJugador);
        this.scanner = new Scanner(System.in);
    }

    public void iniciarJuego() {
        System.out.println("¡Bienvenido a Candy Crush, " + jugador.getNombre() + "!");
        while (jugador.getVidasRestantes() > 0) {
            imprimirTablero();
            System.out.println("Turnos restantes: " + jugador.getTurnosRestantes() + ", Vidas restantes: " + jugador.getVidasRestantes() + ", Puntaje: " + jugador.getPuntaje());
            System.out.println("Ingresa el movimiento (fila1 col1 fila2 col2) o 'salir' para terminar:");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("salir")) {
                break;
            }

            String[] datos = entrada.split(" ");
            if (datos.length == 4) {
                try {
                    int fila1 = Integer.parseInt(datos[0]);
                    int col1 = Integer.parseInt(datos[1]);
                    int fila2 = Integer.parseInt(datos[2]);
                    int col2 = Integer.parseInt(datos[3]);

                    int[] movimiento = {fila1, col1, fila2, col2};
                    if(comprobarPos(movimiento)){
                    tablero.moverDulce(movimiento);
                    }
                    if (tablero.actualizarTablero(true)) {
                        System.out.println("Movimiento valido.");
                    } else {
                        jugador.restarTurno();//probando si ahora resta un turno cuando se equivoca
                        System.out.println("Movimiento invalido, intenta de nuevo.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada invalida. Por favor, ingresa numeros validos.");
                }
            } else {
                System.out.println("Entrada invalida. Por favor, ingresa 4 numeros.");
            }
        }
        System.out.println("Juego terminado. Tu puntaje final es: " + jugador.getPuntaje());
    }

    public boolean comprobarPos(int[] posicion ){
        if(posicion[0]==posicion[2]){
            return (posicion[1]==posicion[3]+1) || (posicion[1]==posicion[3]-1);
        }
        if(posicion[1]==posicion[3]){
            return (posicion[0]==posicion[2]+1) || (posicion[0]==posicion[2]-1);
        }
        return false;
    }
    private void imprimirTablero() {
        Dulce[][] matriz = tablero.getMatriz();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j].getForma() + " ");
            }
            System.out.println();
        }
    }


}
