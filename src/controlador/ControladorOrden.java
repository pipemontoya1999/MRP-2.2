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
import modelo.ConexionDB;
import visual.TablaOrden;
import visual.TablaPlanP;

/**
 *
 * @author Felipe Montoya
 */
public class ControladorOrden  {
    JComboBox ordenesBox = new javax.swing.JComboBox<>();
    JButton jButton = new javax.swing.JButton();
    JTable tabla = new javax.swing.JTable();
     private TablaOrden torden = new TablaOrden();
     private DefaultTableModel model;
    OrdenProduccion ordenProduccion = new OrdenProduccion();
    ControlPlanP control;
    private final ConexionDB conexionDB;
   private Connection conexion;
   public TablaPlanP tablaPP;
   private ArrayList<Integer> idBebidas ;
   private ArrayList<Float> beCantidad ;


    public ControladorOrden(TablaOrden torden) {
        this.torden=torden;
        this.conexionDB = new ConexionDB();
        this.conexion= conexionDB.getConnection(); 
       ordenesBox = torden.getjComboBox1();
       
       tabla = torden.getjTable1();
       model = (DefaultTableModel) tabla.getModel();
       
        rellenarBox();

    }
    
    
    
    private void rellenarBox() {              
       ActionListener cbActionListener = new ActionListener() {
            @Override
       public void actionPerformed(ActionEvent e) {
           int filas=tabla.getRowCount();
            limpiarTabla(filas,model);
       String s = (String) ordenesBox.getSelectedItem();
       llenarTabla(s);
            }
        };
       
       
         
       
       ordenesBox.addActionListener(cbActionListener);
       
       
       


      ArrayList<String> fechasOP = ordenProduccion.getFechasOP();
      
      
      for(int i=0; i<fechasOP.size(); i++) {    
     ordenesBox.addItem(fechasOP.get(i));
    
    }
    }
    
    


    
    
    
           private void llenarTabla(String s) {
               
               String consulta = "select op.idOrdenProduccion, be.nombre, ob.cantidad,be.idBebida, op.fecha from OrdenProduccion op, Bebida be, OrdenBebida ob \n" +
               "where be.idBebida = ob.idBebida and op.idOrdenProduccion = ob.idOrdenProduccion and op.fecha='"+s+"'";
               
            PreparedStatement ps;            
        try {
            ps = conexion.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            idBebidas = new ArrayList<>();
            beCantidad = new ArrayList<>();
            while(rs.next()){
                String a = rs.getString(2);
                Float b = rs.getFloat(3);
                int id = rs.getInt(4);
            model.addRow(new Object[]{a, b});
            idBebidas.add(id);
            beCantidad.add(b);
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(ControladorOrden.class.getName()).log(Level.SEVERE, null, ex);
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

    public ArrayList<Integer> getIdBebidas() {
        return idBebidas;
    }

    public ArrayList<Float> getBeCantidad() {
        return beCantidad;
    }

    
    
}
