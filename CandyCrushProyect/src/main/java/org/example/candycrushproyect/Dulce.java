
package org.example.candycrushproyect;

public class Dulce {
    //Atributos
    private int forma;

    /**
     * Establece forma inicial del dulce al crearse
     * @param forma es un int representativo de la forma
     */
    public Dulce(int forma){
        this.forma = forma;
    }

    /**
     * Retorna forma del dulce
     * @return int representativo de la forma
     */
    public int getForma(){
        return this.forma;
    }

    /**
     * Setea forma del dluce
     * @param forma entero representativo de la forma
     */
    public void setForma(int forma){
        this.forma = forma;
    }

    /**
     * Devuelve una forma aleatoria a traves de un int representativo
     * @return int representativo de la forma del dulce
     */
    public static int formaRamdon(){
        int numeroAleatorio = (int)(Math.random()*6+1);
        return numeroAleatorio;
    }

}