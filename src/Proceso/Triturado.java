/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proceso;


public class Triturado {
    
    private int fila = 0;
    private int columna = 1 ;
    private String Nombre;
    private float cantidadPT;
    

    public Triturado(int fila, int columna, String Nombre, float cantidadPT ) {
        this.fila = fila;
        this.columna = columna;
        this.Nombre = Nombre;
        this.cantidadPT = cantidadPT;
       
    }

    public Triturado() {
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public float getCantidadPT() {
        return cantidadPT;
    }

    public void setCantidadPT(float cantidadPT) {
        this.cantidadPT = cantidadPT;
    }


    
}
