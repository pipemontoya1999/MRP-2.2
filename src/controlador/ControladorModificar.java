/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Bebidas;
import modelo.ConexionDB;
import modelo.ProcesoR;
import visual.Eventos;
import visual.ModificarReceta;

/**
 *
 * @author Felipe Montoya
 */
public class ControladorModificar {
    JComboBox bebidasBox = new javax.swing.JComboBox<>();
    ModificarReceta modificar = new ModificarReceta();
    JButton jButton = new javax.swing.JButton();
    JTable tabla = new javax.swing.JTable();
    private DefaultTableModel model;
   private  ArrayList<String> nombreB = new ArrayList<>();
   ProcesoR proceso = new ProcesoR();
   int idBebida = 0;

    public ControladorModificar(ModificarReceta modr,ArrayList<String> bebidas) {
        this.modificar = modr;
        
        bebidasBox = modr.getjComboBox1();     
        tabla = modr.getjTable1();
        model = (DefaultTableModel) tabla.getModel();
        nombreB = bebidas;
        rellenarBox();
        
    }


        private void rellenarBox() { 
       ActionListener cbActionListener = new ActionListener() {
            @Override
       public void actionPerformed(ActionEvent e) {
           int filas=tabla.getRowCount();
            limpiarTabla(filas,model);
       String s = (String) bebidasBox.getSelectedItem();
       Bebidas bebida = new Bebidas();
       idBebida = bebida.getIdBebida(s);
       
       bebida= null;
       proceso.llenarReceta(s,model);      
            }
        };
                             
       bebidasBox.addActionListener(cbActionListener);                    
       jButton = modificar.getjButton1();
       
      jButton.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
       System.out.println("seeee");
       tabla = modificar.getjTable1();
       proceso.actualizarReceta(tabla,idBebida);
      } 
       } );
       
       
           
      for(int i=0; i<nombreB.size(); i++) {    
     bebidasBox.addItem(nombreB.get(i));
    
    }
      

        
    }
    
               
     public void limpiarTabla(int filas, DefaultTableModel modelo){
        try {
            modelo=(DefaultTableModel) tabla.getModel();
            
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            System.out.println("Error al limpiar la tabla.");
        }
    }
    
    
    
}
