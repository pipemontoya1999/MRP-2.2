/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proceso;

/**
 *
 * @author Felipe Montoya
 */
public class Macerado {
     
    private int fila = 0;
    private int columna;
    private String Nombre;

    public Macerado(int fila, int columna, String Nombre) {
        this.fila = fila;
        this.columna = columna;
        this.Nombre = Nombre;
    }

    public Macerado() {
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


}
