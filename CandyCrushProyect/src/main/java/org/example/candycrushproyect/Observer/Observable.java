package org.example.candycrushproyect.Observer;

import java.util.ArrayList;
import java.util.List;

public class Observable {//Se aplicara a Jugador
    private List<Observador> ObservadoresList = new ArrayList<>();

    public void anadirObservador(Observador observador){
        ObservadoresList.add(observador);
    }
    public void removerObservador(){
        for(Observador observador: ObservadoresList){
            ObservadoresList.remove(observador);
        }

    }
    public void notificarObservadores(){
        for(Observador observador: ObservadoresList){
           observador.ActualizarEstado();
        }
    }
}
