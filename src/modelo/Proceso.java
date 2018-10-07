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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe Montoya
 */
public class Proceso {
   private final ConexionDB conexionDB;
   private final Connection conexion;
   private String Nombre;

    public Proceso() {
        this.conexionDB = new ConexionDB();
        this.conexion= conexionDB.getConnection();
    }
    

    
    public boolean comprobar(int caso,int proceso){
        String consulta = "select count(idBebida), idProceso from ProcesoBebida where idBebida ="+caso+" and idProceso="+proceso;
     int k=0;
        try {
           PreparedStatement ps = conexion.prepareStatement(consulta);
           ResultSet rs = ps.executeQuery();
           while(rs.next()){
           k = rs.getInt(1);
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
       }
        
       if(k==0){return false;}
       else{return true;}
    
    }

    public int getHoras(int idB,float cantidad, int idP) {
        float cantidadT = 0;
        String consulta = "select re.idBebida, mp.idProceso, re.idInvMP, cantidad from receta re, MateriaPrima mp "
                + "where re.idInvMP = mp.idInvMP and idBebida="+idB+" and idProceso ="+idP+" group by re.idInvMP";
       try {
           PreparedStatement ps = conexion.prepareStatement(consulta);
           ResultSet rs = ps.executeQuery();
           while(rs.next()){
           cantidadT = cantidadT + rs.getFloat(4);
           }
           cantidadT = cantidadT*cantidad;
            System.out.println(cantidadT);
       } catch (SQLException ex) {
           Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
       }
       float capacidadM = getCapacidad(idP);
       float division = cantidadT/capacidadM;
        int Horas = Math.round(division);
        if (Horas == 0){
        Horas =1;
        }
        System.out.println(Horas);
        
        return Horas;
    }
    
    public float getCapacidad(int idP){
     String consulta = "select idMantenimiento, capacidad, prefijo from Mantenimiento where idProceso ="+idP;
     float CapacidadMante = 0;
       try {
          PreparedStatement ps= conexion.prepareStatement(consulta);
          ResultSet rs = ps.executeQuery();
          while(rs.next()){
          CapacidadMante = rs.getFloat(2);
          }
       } catch (SQLException ex) {
           Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
       }
     return CapacidadMante;
    }

    public String getBebida(int idbebida) {
     String consulta = "select idBebida,nombre,Stock from Bebida where idBebida="+idbebida;
       try {
           Nombre = "";
          PreparedStatement ps= conexion.prepareStatement(consulta);
          ResultSet rs = ps.executeQuery();
          while(rs.next()){
          Nombre = rs.getString(2);
          }
       } catch (SQLException ex) {
           Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
       }
       return Nombre;
      
    }
}
