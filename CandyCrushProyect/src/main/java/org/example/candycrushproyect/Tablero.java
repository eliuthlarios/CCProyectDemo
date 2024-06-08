
package org.example.candycrushproyect;


import org.example.candycrushproyect.Factory.DulceFactory;
import org.example.candycrushproyect.Factory.Factory;

public class Tablero {
    //Atributos
    private Dulce matriz[][];
    private TableroController tableroController;
    private final Factory factory= new DulceFactory();


    public Tablero(){
        this.matriz = new Dulce[9][9];
        tableroController = new TableroController(this);
        generarTablero();
    }

    public TableroController getController(){
        return tableroController;
    }

    public Dulce[][] getMatriz(){
        return matriz;
    }


    public void setDulce(int fila,int columna, Dulce dulce){
        this.matriz[fila][columna] = dulce;
    }


    public Dulce getDulce(int fila,int columna){
        return this.matriz[fila][columna];
    }


    public void generarTablero(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                this.setDulce(i, j, factory.GenerarDulce((int)(Math.random()*6+1)));/*new Dulce(Dulce.formaRamdon())*/
            }
        }
        actualizarTablero(false);
    }

    private void caerDulces() {
        for(int i = 0; i < 10; i++){
            for(int fila = 0; fila < 8; fila++){
                for(int columna = 0; columna < 9; columna++){
                    if(matriz[fila][columna].getForma() != 0 && matriz[fila + 1][columna].getForma() == 0){
                        this.matriz[fila+1][columna].setForma(matriz[fila][columna].getForma());
                        this.matriz[fila][columna].setForma(0);
                    }
                }
            }
        }
    }


    private void llenarDulces() {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(this.matriz[i][j].getForma() == 0){
                    this.matriz[i][j].setForma((int)(Math.random()*6+1));
                }
            }
        }
    }


    public void moverDulce( int[] dato ) {
        int formaA = this.getDulce(dato[0], dato[1]).getForma();
        int formaB = this.getDulce(dato[2], dato[3]).getForma();

        this.matriz[dato[0]][dato[1]].setForma(formaB);
        this.matriz[dato[2]][dato[3]].setForma(formaA);
    }


    public boolean actualizarTablero(boolean sumaPuntuacion) {
        tableroController.eliminarDulces();
        if(tableroController.validarPuntuacion(sumaPuntuacion)){
            this.caerDulces();
            this.llenarDulces();
            this.actualizarTablero(sumaPuntuacion);
            return true;
        }else{
            if(!tableroController.hayPosibleMovimiento())
                generarTablero();
            return false;
        }
    }

}