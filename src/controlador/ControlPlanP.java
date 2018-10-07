/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
    private String nombre = "";
    
    private Macerado macerado = new Macerado();
    private Triturado triturado = new Triturado();

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
            macerar(bebida,1,cantidad);
            
            }
//triturar(1,1,2500);
        
        }
 
    }


    private void triturar(int idbebida, int idproceso, float cantidad) {
        if(proceso.comprobar(idbebida, idproceso)){      
          int fila= triturado.getFila();
          int Horas = proceso.getHoras(idbebida,cantidad,idproceso);
          for (int i=0;i<Horas;i++){
          fila = fila+1;
          columna = idproceso;
          nombre = proceso.getBebida(idbebida);
          //System.out.println(fila);
          añadirTabla(fila-1,1,nombre);
          }
           
          triturado.setFila(fila);
          triturado.setColumna(columna);
          triturado.setNombre(nombre);
          System.out.println("queee"+triturado.getFila());
        } else {
            
        }
    }

    private void añadirTabla(int fila, int columna, String nombre) {
            
            tabla = tablaPP.getjTable1();
            tabla.setValueAt(nombre, fila, columna);

    }

    private void macerar(int idbebida, int idproceso, float cantidad) {
 if(proceso.comprobar(idbebida, idproceso)){   
          macerado.setFila(triturado.getFila());
          int fila= macerado.getFila();
          int Horas = proceso.getHoras(idbebida,cantidad,idproceso);
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
          System.out.println("queee"+macerado.getFila());
        } else {
            
        }
    }
    }



