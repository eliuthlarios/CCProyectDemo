
package org.example.candycrushproyect;


import org.example.candycrushproyect.Factory.DulceGenerico;

public class Dulce implements DulceGenerico {

    private int forma;

    public Dulce(){}
    public Dulce(int forma){
        this.forma = forma;
    }


    public int getForma(){
        return this.forma;
    }

    public void setForma(int forma){
        this.forma = forma;
    }
    @Override
    public String type() {
        if(forma==1){
        return "#";
        }
        if(forma==2){
            return "%";
        }
        if(forma==3){
            return"&";
        }
        if(forma==4){
            return "$";
        }
        if(forma==5){
            return "@";
        }
        if(forma==6){
            return "?";
        }

        return null;
    }
}