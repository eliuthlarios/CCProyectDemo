package org.example.candycrushproyect;

import org.example.candycrushproyect.Observer.Observable;

public class Jugador extends Observable {

    private static Jugador Instance;
    private String nombre;
    private int vidasRestantes;
    private int turnosRestantes;
    private int puntaje;


    private Jugador(String nombre){
        this.nombre = nombre;
        this.vidasRestantes = 5;
        this.turnosRestantes = 50;
        this.puntaje = 0;
    }


    public int getVidasRestantes(){
        return this.vidasRestantes;
    }


    public void bajarVida(){
        this.vidasRestantes --;
        notificarObservadores();
    }


    public String getNombre(){
        return this.nombre;
    }


    public int getTurnosRestantes(){
        return this.turnosRestantes;
    }


    public void restarTurno(){
        if(turnosRestantes > 0){
            turnosRestantes --;
        }else if(vidasRestantes > 0){
            vidasRestantes --;
            turnosRestantes += 49;
        }
        notificarObservadores();
    }

    public int getPuntaje(){
        return this.puntaje;
    }


    public void sumarPuntaje(int puntuacion){
        restarTurno();
        this.puntaje += puntuacion;
    }

    public static Jugador getInstance(String nombre){
        if(Instance == null)
            Instance = new Jugador(nombre);
        return Instance;
    }

}