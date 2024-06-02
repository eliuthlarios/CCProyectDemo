
package org.example.candycrushproyect;


public class Tablero {
    //Atributos
    private Dulce matriz[][];
    private TableroController tableroController;

    /**
     * Al crear un tablero, se establece el tamaño de la matriz de dulces
     */
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

    /**
     * Establece dulce en la posicion dada del tablero
     * @param fila fila del dulce a establecer
     * @param columna columna del dulce a establecer
     * @param dulce dulce que establecerá en la posicion dada
     */
    public void setDulce(int fila,int columna, Dulce dulce){
        this.matriz[fila][columna] = dulce;
    }

    /**
     * Obtiene dulce en la posición dada
     * @param fila fila del dulce requerido
     * @param columna columna del dulce requerido
     * @return dulce requerido
     */
    public Dulce getDulce(int fila,int columna){
        return this.matriz[fila][columna];
    }

    /**
     * Define cada posicion de la matriz de dulces de manera aleatorea
     */
    public void generarTablero(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                this.setDulce(i, j, new Dulce(Dulce.formaRamdon()));
            }
        }
        actualizarTablero(false);
    }

    /**
     * Se encarga de la gravedad característica del candy crush cuando se elimina algún dulces
     */
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

    /**
     * Reemplaza los espacios vacios por nuevos dulces
     */
    private void llenarDulces() {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(this.matriz[i][j].getForma() == 0){
                    this.matriz[i][j].setForma(Dulce.formaRamdon());
                }
            }
        }
    }

    /**
     * Mueve dos dulces segun posiciones dadas por el jugador en lenguaje tablero
     * @param dato arreglo con posiciones dadas por el usuario y traducidas a lenguaje tablero
     */
    public void moverDulce( int[] dato ) {
        int formaA = this.getDulce(dato[0], dato[1]).getForma();
        int formaB = this.getDulce(dato[2], dato[3]).getForma();

        this.matriz[dato[0]][dato[1]].setForma(formaB);
        this.matriz[dato[2]][dato[3]].setForma(formaA);
    }

    /**
     * Actualiza el tablero con la variante que adiciona la puntuacion generada
     */
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