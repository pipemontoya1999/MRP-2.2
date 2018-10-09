/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Proceso.Aclarado;
import Proceso.Embotellado;
import Proceso.Fermentado;
import Proceso.Filtrado;
import Proceso.Gasificado;
import Proceso.Macerado;
import Proceso.Madurado;
import Proceso.Mezclado;
import Proceso.Triturado;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Proceso;
import visual.Costos;
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
    private int contador=1;
    private int columna=1;
    private int filaIn = 0;
    private String nombre = "";
    
    //variables para ir guardando los costos

    private float costoMP=0;
    private float costoMantenimiento=0;
    private float costoRH=0;
    
    private float costoMPt;
    private float costoMantenimientot;
    private float costoRHt;
  
    // creacion de los procesos para guardar la posicion en la tabla
    private Embotellado embotellado = new Embotellado();
    private Gasificado gasificado = new Gasificado();
    private Mezclado mezclado = new Mezclado();
    private Filtrado filtrado = new Filtrado();
    private Madurado maduracion = new Madurado();
    private Fermentado fermentado = new Fermentado();
    private Aclarado aclarado = new Aclarado();
    private Macerado macerado = new Macerado();
    private Triturado triturado = new Triturado();
    
    private Costos costos = new Costos();
    private JTable tablaCostos = new javax.swing.JTable(); 
   private DefaultTableModel model;
   private JTextField jtotalP;
    
    //constructor
    public ControlPlanP(TablaPlanP tablaPP, ArrayList<Integer> idBebidas, ArrayList<Float> beCantidad, Costos costos) {
        this.tablaPP = tablaPP;
        this.idBebidas = idBebidas;
        this.beCantidad=beCantidad;
        this.proceso=new Proceso();
        this.costos = costos;
        jtotalP = costos.getJtotalP();
        tabla = tablaPP.getjTable1();
        tablaCostos = costos.getTcostoP();
        model = (DefaultTableModel) tablaCostos.getModel();
        limpiarTabla();
        
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
           fermentar(bebida,4,cantidad);
           madurar(bebida,5,cantidad);
           filtrar(bebida,6,cantidad);
           mezclar(bebida,7,cantidad);
           gasificar(bebida,8,cantidad);
           embotellar(bebida,9,cantidad);
           contador++;
            }
          
          limpiarTabla(tablaCostos.getRowCount(),model);
          rellenarTablaC(model);
          ponerTotalP(jtotalP,tablaCostos);
          System.out.println(costoRH);
//triturar(1,1,250);
//macerar(1,2,6);
//aclarar(1,3,6);
        
        }
 
    }


    private void triturar(int idbebida, int idproceso, float cantidad) {
        if(proceso.comprobar(idbebida, idproceso)&& cantidad>0){ // comprueba si la bebida pertenece al proceso     
          int fila= triturado.getFila();
          float cantidadMP = proceso.getCantidadMP(idbebida, cantidad, idproceso); 
          
          costoMPt = proceso.getCostoMP();//costo materia prima        
          ponerCostoMP(costoMPt);//se agrega al costo general
          cantidadMP = cantidadMP + triturado.getCantidadPT(); 
          int Horas = proceso.getHoras(idbebida,cantidadMP,idproceso);
          
          costoMantenimientot=proceso.getCostoMan(Horas,idproceso);//costo mantenimiento
          ponerCostoMan(costoMantenimientot);// se agrega al costo general
          costoRHt=proceso.getCostoRH(Horas,idproceso);//costo de materia prima
          ponerCostoRH(costoRHt);// se agrega al costo general
          for (int i=0;i<Horas;i++){
          fila = fila+1;
          columna = idproceso;
          nombre = proceso.getBebida(idbebida);
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
        if(proceso.comprobar(idbebida, idproceso)&& cantidad>0){ // comprueba si la bebida pertenece al proceso     
             if(contador == 1){    
          macerado.setFila(triturado.getFila());
             }
          int fila= macerado.getFila();
          float cantidadMP = proceso.getCantidadMP(idbebida, cantidad, idproceso);
          costoMPt = proceso.getCostoMP();//costo materia prima        
          ponerCostoMP(costoMPt);//se agrega al costo general
          int Horas = proceso.getHoras(idbebida,cantidadMP,idproceso);
          costoMantenimientot=proceso.getCostoMan(Horas,idproceso);//costo mantenimiento
          ponerCostoMan(costoMantenimientot);// se agrega al costo general
          costoRHt=proceso.getCostoRH(Horas,idproceso);//costo de materia prima
          ponerCostoRH(costoRHt);// se agrega al costo general
          
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
        if(proceso.comprobar(idbebida, idproceso)&& cantidad>0){ // comprueba si la bebida pertenece al proceso     
             if(contador == 1){    
          aclarado.setFila(macerado.getFila());
             }
          int fila= aclarado.getFila();
          float cantidadMP = proceso.getCantidadMP(idbebida, cantidad, idproceso);
          cantidadMP = cantidadMP + macerado.getCantidadPT();
          costoMPt = proceso.getCostoMP();//costo materia prima        
          ponerCostoMP(costoMPt);//se agrega al costo general
          int Horas = proceso.getHoras(idbebida,cantidadMP,idproceso);
                    costoMantenimientot=proceso.getCostoMan(Horas,idproceso);//costo mantenimiento
          ponerCostoMan(costoMantenimientot);// se agrega al costo general
          costoRHt=proceso.getCostoRH(Horas,idproceso);//costo de materia prima
          ponerCostoRH(costoRHt);// se agrega al costo general
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
    
        private void fermentar(int idbebida, int idproceso, float cantidad) {
            if(proceso.comprobar(idbebida, idproceso)&& cantidad>0){
                float cantidadMP = proceso.getCantidadMP(idbebida, cantidad, idproceso);
                 costoMPt = proceso.getCostoMP();//costo materia prima        
                 ponerCostoMP(costoMPt);//se agrega al costo general
                cantidadMP = aclarado.getCantidadPT() + cantidadMP;            
                fermentado.setCantidadPT(cantidadMP);           
            }
            
    }
        
        private void madurar(int idbebida, int idproceso, float cantidad) {
           if(proceso.comprobar(idbebida, idproceso)&& cantidad>0){
               float cantidadMP = proceso.getCantidadMP(idbebida, cantidad, idproceso);
                costoMPt = proceso.getCostoMP();//costo materia prima        
          ponerCostoMP(costoMPt);//se agrega al costo general
                cantidadMP = fermentado.getCantidadPT() + cantidadMP;            
            maduracion.setCantidadPT(cantidadMP);
           }
    }
      private void filtrar(int idbebida, int idproceso, float cantidad) {
         if(proceso.comprobar(idbebida, idproceso)){
         if(contador == 1){    
          filtrado.setFila(aclarado.getFila());
             }
          int fila= filtrado.getFila();
          float cantidadMP = proceso.getCantidadMP(idbebida, cantidad, idproceso);
          costoMPt = proceso.getCostoMP();//costo materia prima        
          ponerCostoMP(costoMPt);//se agrega al costo general
          cantidadMP = cantidadMP + maduracion.getCantidadPT();         
          int Horas = proceso.getHoras(idbebida,cantidadMP,idproceso);
          
          costoMantenimientot=proceso.getCostoMan(Horas,idproceso);//costo mantenimiento
          ponerCostoMan(costoMantenimientot);// se agrega al costo general
          costoRHt=proceso.getCostoRH(Horas,idproceso);//costo de materia prima
          ponerCostoRH(costoRHt);// se agrega al costo general
     
          for (int i=0;i<Horas;i++){
          fila = fila+1;
          columna = idproceso;
          nombre = proceso.getBebida(idbebida);
          //System.out.println(fila);
          añadirTabla(fila-1,idproceso,nombre);
          }         
          filtrado.setFila(fila);
          filtrado.setColumna(columna);
          filtrado.setNombre(nombre);
          filtrado.setCantidadPT(cantidadMP);
         } 
    }

      private void mezclar(int idbebida, int idproceso, float cantidad) {
         if(proceso.comprobar(idbebida, idproceso)&& cantidad>0){
         if(idbebida == 6){    
          mezclado.setFila(filtrado.getFila());
             }
         if(idbebida == 7){mezclado.setFila(0);}
          int fila= mezclado.getFila();
          float cantidadMP = proceso.getCantidadMP(idbebida, cantidad, idproceso);
           costoMPt = proceso.getCostoMP();//costo materia prima        
          ponerCostoMP(costoMPt);//se agrega al costo general
          if(idbebida == 6){
          cantidadMP = cantidadMP + filtrado.getCantidadPT();          
          }                            
          System.out.println(cantidad+" "+nombre+" tiene "+cantidadMP);
          int Horas = proceso.getHoras(idbebida,cantidadMP,idproceso);
                     costoMantenimientot=proceso.getCostoMan(Horas,idproceso);//costo mantenimiento
          ponerCostoMan(costoMantenimientot);// se agrega al costo general
          costoRHt=proceso.getCostoRH(Horas,idproceso);//costo de materia prima
          ponerCostoRH(costoRHt);// se agrega al costo general
          for (int i=0;i<Horas;i++){
          fila = fila+1;
          columna = idproceso;
          nombre = proceso.getBebida(idbebida);
         añadirTabla(fila-1,idproceso,nombre);
          
          }         
          mezclado.setFila(fila);
          mezclado.setColumna(columna);
          mezclado.setNombre(nombre);
          mezclado.setCantidadPT(cantidadMP);
         } 
    }

      private void gasificar(int idbebida, int idproceso, float cantidad) {
         if(proceso.comprobar(idbebida, idproceso)&& cantidad>0){
          
          gasificado.setFila(mezclado.getFila());

          int fila= gasificado.getFila();
          float cantidadMP = proceso.getCantidadMP(idbebida, cantidad, idproceso);
           costoMPt = proceso.getCostoMP();//costo materia prima        
          ponerCostoMP(costoMPt);//se agrega al costo general
          cantidadMP = cantidadMP + mezclado.getCantidadPT();                      
          int Horas = proceso.getHoras(idbebida,cantidadMP,idproceso);
                     costoMantenimientot=proceso.getCostoMan(Horas,idproceso);//costo mantenimiento
          ponerCostoMan(costoMantenimientot);// se agrega al costo general
          costoRHt=proceso.getCostoRH(Horas,idproceso);//costo de materia prima
          ponerCostoRH(costoRHt);// se agrega al costo general
          for (int i=0;i<Horas;i++){
          fila = fila+1;
          columna = idproceso;
          nombre = proceso.getBebida(idbebida);
         añadirTabla(fila-1,idproceso,nombre);
          
          }         
          gasificado.setFila(fila);
          gasificado.setColumna(columna);
          gasificado.setNombre(nombre);
          gasificado.setCantidadPT(cantidadMP);
         } 
    }      
 
      private void embotellar(int idbebida, int idproceso, float cantidad) {
         if(proceso.comprobar(idbebida, idproceso)&& cantidad>0){
          if(idbebida>5){
          embotellado.setFila(gasificado.getFila());
          }else{
          embotellado.setFila(filtrado.getFila());
          }
          

          int fila= embotellado.getFila();
          float cantidadMP = cantidad;
          costoMPt = 15*cantidad;//costo materia prima        
          ponerCostoMP(costoMPt);//se agrega al costo general
                       
          int Horas = proceso.getHoras(idbebida,cantidad,idproceso);
                     costoMantenimientot=proceso.getCostoMan(Horas,idproceso);//costo mantenimiento
          ponerCostoMan(costoMantenimientot);// se agrega al costo general
          costoRHt=proceso.getCostoRH(Horas,idproceso);//costo de materia prima
          ponerCostoRH(costoRHt);// se agrega al costo general
          for (int i=0;i<Horas;i++){
          fila = fila+1;
          columna = idproceso;
          nombre = proceso.getBebida(idbebida);
         añadirTabla(fila-1,idproceso,nombre);
          
          }         
          embotellado.setFila(fila);
          embotellado.setColumna(columna);
          embotellado.setNombre(nombre);
          embotellado.setCantidadPT(cantidadMP);
          
         } 
    } 

      
    private void añadirTabla(int fila, int columna, String nombre) {            

            tabla.setValueAt(nombre, fila, columna);
    }
    
        private void limpiarTabla() {            
           int a = tabla.getRowCount();
           System.out.println(a);
           for(int l=1;l<10;l++){
            for(int i=0;i<a;i++){
            tabla.setValueAt("", i, l);
            }
           }
            
    }

    private void ponerCostoMP(float costoMPt1) {
        costoMP = costoMP + costoMPt1; 
    }

    private void ponerCostoMan(float costoMantenimientot) {
        costoMantenimiento= costoMantenimiento+ costoMantenimientot;
    }

    private void ponerCostoRH(float costoRHt) {
        costoRH=costoRH+costoRHt;
    }

    private void rellenarTablaC(DefaultTableModel tablaCostos) {
        model.addRow(new Object[]{costoRH, costoMP,costoMantenimiento});
    }
    
    public void limpiarTabla(int filas, DefaultTableModel modelo){
        try {        
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            System.out.println("Error al limpiar la tabla.");
        }
    }

    private void ponerTotalP(JTextField jtotalP, JTable tablaCostos) {
        float costrh = (float) tablaCostos.getValueAt(0, 0);
        float costmp = (float) tablaCostos.getValueAt(0, 1);
        float costma = (float) tablaCostos.getValueAt(0, 2);
        
        float total = costrh+costmp+costma;
        
        jtotalP.setText(Float.toString(total));
        
    }

 
    
    
    
    }



