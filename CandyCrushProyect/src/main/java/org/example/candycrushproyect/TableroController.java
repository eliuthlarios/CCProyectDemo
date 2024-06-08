
package org.example.candycrushproyect;

public class TableroController {
    //referencias
    private Dulce matriz[][];
    private Jugador jugador;

    public TableroController(Tablero tablero){
        this.matriz = tablero.getMatriz();
        jugador = Jugador.getInstance("");
    }

    public Jugador getJugador(){
        return jugador;
    }

    public void eliminarDulces() {
        boolean eliminar = false;
        for(int pPi=0; pPi<9; pPi++){
            for(int pPj=0; pPj<9; pPj++){
                if(pPj<7){
                    int cH = 1;
                    for(int cHj=pPj+1; cHj<9; cHj++){
                        if(matriz[pPi][cHj].getForma() == matriz[pPi][pPj].getForma())
                            cH ++;
                        else
                            break;
                    }
                    if(cH>2){
                        eliminar=true;
                        for(int cHj=pPj; cHj<pPj+cH; cHj++){
                            int cV = 1;
                            if(pPi>0)
                                for(int cVi=pPi-1; cVi>=0; cVi--){
                                    if(matriz[cVi][cHj].getForma() == matriz[pPi][cHj].getForma())
                                        cV++;
                                    else
                                        break;
                                }
                            if(pPi<8)
                                for(int cVi=pPi+1; cVi<9; cVi++){
                                    if(matriz[cVi][cHj].getForma() == matriz[pPi][cHj].getForma())
                                        cV++;
                                    else
                                        break;
                                }
                            if(cV>2){
                                if(pPi>0)
                                    for(int cVi=pPi-1; cVi>=0; cVi--){
                                        if(matriz[cVi][cHj].getForma() == matriz[pPi][cHj].getForma())
                                            matriz[cVi][cHj].setForma(0);
                                        else
                                            break;
                                    }
                                if(pPi<8)
                                    for(int cVi=pPi+1; cVi<9; cVi++){
                                        if(matriz[cVi][cHj].getForma() == matriz[pPi][cHj].getForma())
                                            matriz[cVi][cHj].setForma(0);
                                        else
                                            break;
                                    }
                            }
                            matriz[pPi][cHj].setForma(0);
                        }
                    }
                }
            }
        }

        if(!eliminar)
            for(int pPi=0; pPi<9; pPi++){
                for(int pPj=0; pPj<9; pPj++){
                    if(pPi<7){
                        int cV = 1;
                        for(int cVi=pPi+1; cVi<9; cVi++){
                            if(matriz[cVi][pPj].getForma() == matriz[pPi][pPj].getForma())
                                cV ++;
                            else
                                break;
                        }
                        if(cV>2)
                            for(int cVi=pPi; cVi<pPi+cV; cVi++){
                                matriz[cVi][pPj].setForma(0);
                            }
                    }
                }
            }
    }

    public boolean hayPosibleMovimiento() {
        int contador = 0;
        String direccion = "";
        for(int i = 0; i <= 8; i++){
            for(int j = 0; j <= 8; j++){
                contador = 0;
                direccion = "";
                try{
                    if(this.matriz[i][j-1].getForma() == this.matriz[i-1][j].getForma()){
                        contador++;
                        direccion = "leftup";
                    }

                    if(this.matriz[i-1][j].getForma() == this.matriz[i][j+1].getForma()){
                        contador++;
                        direccion = "uprigth";
                    }

                    if(this.matriz[i][j+1].getForma() == this.matriz[i+1][j].getForma()){
                        contador++;
                        direccion = "rigthdown";
                    }

                    if(this.matriz[i+1][j].getForma() == this.matriz[i][j-1].getForma()){
                        contador++;
                        direccion = "downleft";
                    }

                    if(this.matriz[i][j-1].getForma() == this.matriz[i][j+1].getForma()){
                        contador++;
                        direccion = "fila";
                    }

                    if(this.matriz[i-1][j].getForma() == this.matriz[i+1][j].getForma()){
                        contador++;
                        direccion = "columna";
                    }

                    if(contador >= 3){
                        return true;
                    }else if(contador == 1){
                        contador = 0;
                        if(direccion.equals("leftup")){
                            if(this.matriz[i][j-2].getForma() == this.matriz[i][j-1].getForma()){
                                contador++;
                            }

                            if(this.matriz[i-2][j].getForma() == this.matriz[i-1][j].getForma()){
                                contador++;
                            }

                            if(contador >= 2){
                                return true;
                            }
                        }

                        if(direccion.equals("uprigth")){
                            if(this.matriz[i-2][j].getForma() == this.matriz[i-1][j].getForma()){
                                contador++;
                            }

                            if(this.matriz[i][j+2].getForma() == this.matriz[i][j+1].getForma()){
                                contador++;
                            }

                            if(contador >= 2){
                                return true;
                            }
                        }

                        if(direccion.equals("rigthdown")){
                            if(this.matriz[i][j+2].getForma() == this.matriz[i][j+1].getForma()){
                                contador++;
                            }

                            if(this.matriz[i+2][j].getForma() == this.matriz[i+1][j].getForma()){
                                contador++;
                            }

                            if(contador >= 2){
                                return true;
                            }
                        }

                        if(direccion.equals("downleft")){
                            if(this.matriz[i+2][j].getForma() == this.matriz[i+1][j].getForma()){
                                contador++;
                            }

                            if(this.matriz[i][j-2].getForma() == this.matriz[i][j-1].getForma()){
                                contador++;
                            }

                            if(contador >= 2){
                                return true;
                            }
                        }

                        if(direccion.equals("columna")){
                            if(this.matriz[i+2][j].getForma() == this.matriz[i+1][j].getForma()){
                                contador++;
                            }

                            if(this.matriz[i-2][j].getForma() == this.matriz[i-1][j].getForma()){
                                contador++;
                            }

                            if(contador >= 2){
                                return true;
                            }
                        }


                        if(direccion.equals("fila")){
                            if(this.matriz[i][j+2].getForma() == this.matriz[i][j+1].getForma()){
                                contador++;
                            }

                            if(this.matriz[i][j-2].getForma() == this.matriz[i][j-1].getForma()){
                                contador++;
                            }

                            if(contador >= 2){
                                return true;
                            }
                        }

                    }

                }catch(ArrayIndexOutOfBoundsException e){}
            }
        }
        return false;
    }


    public boolean validarPuntuacion(boolean sumaPuntuacion) {
        int cantidadDulces = 0;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j<9; j++){
                if(this.matriz[i][j].getForma() == 0){
                    cantidadDulces++;
                }
            }
        }
        if (sumaPuntuacion)
            sumarPuntuacion(cantidadDulces);
        return cantidadDulces != 0;
    }


    private void sumarPuntuacion( int cantidadDulces ) {
        switch(cantidadDulces){
            case 3:
                jugador.sumarPuntaje(50);
                break;
            case 4:
                jugador.sumarPuntaje(100);
                break;
            case 5:
                jugador.sumarPuntaje(200);
                break;
            case 6:
                jugador.sumarPuntaje(400);
                break;
            case 7:
                jugador.sumarPuntaje(500);
                break;
        }
    }

}