/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Proceso.Aclarado;
import Proceso.Macerado;
import Proceso.Triturado;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.Proceso;
import visual.TablaPlanP;

/**
 *
 * @author Felipe Montoya
 */
public class ControlPlanP {
    private TablaPlanP tablaPP = new TablaPlanP();
    private JTable tabla = new javax.swing.JTable();
    private ArrayList<Integer> idBebidas ;
    private ArrayList<Float> beCantidad ;
    
    private Proceso proceso;
    private float costoAcumulado = 0;
    
    private int columna=1;
    private int filaIn = 0;
    private String nombre = "";
    
    
    // creacion de los procesos para guardar la posicion en la tabla
    private Aclarado aclarado = new Aclarado();
    private Macerado macerado = new Macerado();
    private Triturado triturado = new Triturado();

    
    //constructor
    public ControlPlanP(TablaPlanP tablaPP, ArrayList<Integer> idBebidas, ArrayList<Float> beCantidad) {
        this.tablaPP = tablaPP;
        this.idBebidas = idBebidas;
        this.beCantidad=beCantidad;
        this.proceso=new Proceso();
        
        iniciar();
    }
    
    public void iniciar(){
        if(idBebidas == null || idBebidas.size()== 0){JOptionPane.showMessageDialog(tablaPP,"Porfavor seleccione una orden");}
        else{
            for(int i=0;i<idBebidas.size();i++){
            int bebida = idBebidas.get(i);
            float cantidad = beCantidad.get(i); 
          triturar(bebida,1,cantidad);          
           macerar(bebida,2,cantidad);
           aclarar(bebida,3,cantidad);
            
            }
//triturar(1,1,250);
//macerar(1,2,6);
//aclarar(1,3,6);
        
        }
 
    }


    private void triturar(int idbebida, int idproceso, float cantidad) {
        if(proceso.comprobar(idbebida, idproceso)){ // comprueba si la bebida pertenece al proceso     
          int fila= triturado.getFila();
          float cantidadMP = proceso.getCantidadMP(idbebida, cantidad, idproceso);
          
          int Horas = proceso.getHoras(idbebida,cantidadMP,idproceso);
          for (int i=0;i<Horas;i++){
          fila = fila+1;
          columna = idproceso;
          nombre = proceso.getBebida(idbebida);
          System.out.println(Horas);
          añadirTabla(fila-1,1,nombre);
          }
          filaIn = fila;
          triturado.setFila(fila);
          triturado.setColumna(columna);
          triturado.setNombre(nombre);
          triturado.setCantidadPT(cantidadMP);
          
        } else {}
    }

    private void macerar(int idbebida, int idproceso, float cantidad) {
        if(proceso.comprobar(idbebida, idproceso)){ // comprueba si la bebida pertenece al proceso     
             if(idbebida == 1){    
          macerado.setFila(triturado.getFila());
             }
          int fila= macerado.getFila();
          float cantidadMP = proceso.getCantidadMP(idbebida, cantidad, idproceso);
          cantidadMP = cantidadMP + triturado.getCantidadPT();
          int Horas = proceso.getHoras(idbebida,cantidadMP,idproceso);
          
          for (int i=0;i<Horas;i++){
          fila = fila+1;
          columna = idproceso;
          nombre = proceso.getBebida(idbebida);
          //System.out.println(fila);
          añadirTabla(fila-1,2,nombre);
          }         
          macerado.setFila(fila);
          macerado.setColumna(columna);
          macerado.setNombre(nombre);
          macerado.setCantidadPT(cantidadMP);
          
        } else {}
    }
    
    
        private void aclarar(int idbebida, int idproceso, float cantidad) {
        if(proceso.comprobar(idbebida, idproceso)){ // comprueba si la bebida pertenece al proceso     
             if(idbebida == 1){    
          aclarado.setFila(macerado.getFila());
             }
          int fila= aclarado.getFila();
          float cantidadMP = proceso.getCantidadMP(idbebida, cantidad, idproceso);
          cantidadMP = cantidadMP + macerado.getCantidadPT();
          System.out.println("el problema es"+cantidadMP);
          int Horas = proceso.getHoras(idbebida,cantidadMP,idproceso);
          System.out.println("el problema es"+Horas);
          for (int i=0;i<Horas;i++){
          fila = fila+1;
          columna = idproceso;
          nombre = proceso.getBebida(idbebida);
          
          añadirTabla(fila-1,3,nombre);
          }         
          aclarado.setFila(fila);
          aclarado.setColumna(columna);
          aclarado.setNombre(nombre);
          aclarado.setCantidadPT(cantidadMP);
        } else {}
    }
    
    
    private void añadirTabla(int fila, int columna, String nombre) {
            
            tabla = tablaPP.getjTable1();
            tabla.setValueAt(nombre, fila, columna);

    }

    
    
    }



