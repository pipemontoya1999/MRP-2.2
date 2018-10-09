/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.OrdenProduccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe Montoya
 */
public class Bebidas {
    
    
    private final ConexionDB conexionDB;
    private static Connection conexion;
    public static ArrayList<String> nombre = new ArrayList<>();
    private static PreparedStatement ps;

    
    
    public  Bebidas() {
        this.conexionDB = new ConexionDB();
        this.conexion= conexionDB.getConnection();  
    }
    
    
        public static  ArrayList<String> getBebidas(){
              String consulta = "select nombre from Bebida";
                           
        try {
             
             
            ps = conexion.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            nombre.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdenProduccion.class.getName()).log(Level.SEVERE, null, ex);
        }
              
        return nombre;    
    }
        
        public static int getIdBebida(String nombre){
        String consulta = "select idBebida, nombre from Bebida where nombre='"+nombre+"'";
         int id=0;                  
        try {             
            ps = conexion.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdenProduccion.class.getName()).log(Level.SEVERE, null, ex);
        }             
          return id;                
        }
    
}
