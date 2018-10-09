/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe Montoya
 */
public class ProcesoR {
   private final ConexionDB conexionDB;
   private final Connection conexion;
   private String Nombre;
   private float duracionP;
   private ArrayList<Integer> idMP ;
   ArrayList<Float> cantidadMP;

   public float[][] costosMP = new float[10][];
   

    public ProcesoR() {
        this.conexionDB = new ConexionDB();
        this.conexion= conexionDB.getConnection();
    }
    
    
    public void llenarReceta(String nombre, DefaultTableModel model){
    String consulta= "select be.nombre, mp.nombre, re.cantidad, re.idInvMP from receta re, materiaprima mp, bebida be where re.idInvMP = mp.idInvMP and re.idBebida = be.idBebida and be.nombre='"+nombre+"'";
     try {
           PreparedStatement ps = conexion.prepareStatement(consulta);
           ResultSet rs = ps.executeQuery();
           while(rs.next()){
            String a = rs.getString(2);
            float b = rs.getFloat(3);
            int c = rs.getInt(4);
            model.addRow(new Object[]{c, a, b});
           }
       } catch (SQLException ex) {
           Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    
    public void actualizarReceta(JTable tabla,int idB){
        cantidadMP = new ArrayList<>();
        idMP = new ArrayList<>();
        int c = tabla.getRowCount();  
        for (int i=0;i<c;i++){
        int id = (int) tabla.getModel().getValueAt(i, 0);
        idMP.add(id);
        }
        for (int i=0;i<c;i++){
        float cant = (float) tabla.getModel().getValueAt(i, 2);
        cantidadMP.add(cant);
        }
        
        System.out.println(cantidadMP);
        
        int t = idMP.size();
        for(int i=0; i<t; i++){
        String consulta= "update RecetaModificada set cantidad="+cantidadMP.get(i)+" where idBebida="+idB+" and idInvMP="+idMP.get(i);
      
        try {
           PreparedStatement ps = conexion.prepareStatement(consulta);
           ps.executeUpdate();

       } catch (SQLException ex) {
           Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
        
    }

    
   

    


}
