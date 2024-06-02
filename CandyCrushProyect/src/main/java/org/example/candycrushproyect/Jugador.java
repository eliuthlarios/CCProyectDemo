package org.example.candycrushproyect;

public class Jugador {

    private static Jugador jugador;
    //Atributos
    private String nombre;
    private int vidasRestantes;
    private int turnosRestantes;
    private int puntaje;

    /**
     * Establece valores iniciales del jugador
     * @param nombre nombre del jugador
     */
    private Jugador(String nombre){
        this.nombre = nombre;
        this.vidasRestantes = 5;// 5
        this.turnosRestantes = 50;//50
        this.puntaje = 0;
    }

    /**
     * retorna el numero de vidas restantes del jugador
     * @return int vidas restantes
     */
    public int getVidasRestantes(){
        return this.vidasRestantes;
    }

    /**
     * Resta la vida del jugador en 1
     */
    public void bajarVida(){
        this.vidasRestantes --;
    }

    /**
     * Retorna nombre del jugador
     * @return String nombre del jugador
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Retorna numero de turnos restantes del jugador
     * @return int numero de movimientos restantes
     */
    public int getTurnosRestantes(){
        return this.turnosRestantes;
    }

    /**
     * Este metodo resta un  movimiento al jugador o vida según corresponda
     */
    public void restarTurno(){
        if(turnosRestantes > 0){
            turnosRestantes --;
        }else if(vidasRestantes > 0){
            vidasRestantes --;
            turnosRestantes += 49;// cambiar a 49 o otro dato, para probar le dejare en 1
        }
    }

    /**
     * Retorna puntaje del jugador
     */
    public int getPuntaje(){
        return this.puntaje;
    }

    /**
     * Suma el puntaje dado al jugador
     * @param puntuacion puntaje obtenido por el jugador
     */
    public void sumarPuntaje(int puntuacion){
        restarTurno();
        this.puntaje += puntuacion;
    }

    public static Jugador getReference(String nombre){
        if(jugador == null)
            jugador = new Jugador(nombre);
        return jugador;
    }

}