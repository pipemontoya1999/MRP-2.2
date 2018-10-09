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

/**
 *
 * @author Felipe Montoya
 */
public class Proceso {
   private final ConexionDB conexionDB;
   private final Connection conexion;
   private String Nombre;
   private float duracionP;
   private float costoMP = 0;

   

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

    public int getHoras(int idB,float cantidadMP, int idP) {

       float capacidadM = getCapacidad(idP);
       float division = cantidadMP/capacidadM;
       int cargas = (int) Math.ceil(division);
       float duracion = getDuracionP(idP);
       
       int Horas = (int) (cargas*duracion);
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

    private float getDuracionP(int idP) {
    String consulta = "select idProceso,duracion from proceso where idProceso="+idP;
       try {
          
          PreparedStatement ps= conexion.prepareStatement(consulta);
          ResultSet rs = ps.executeQuery();
          while(rs.next()){
         duracionP = rs.getFloat(2);
          }
       } catch (SQLException ex) {
           Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
       }
       
      return duracionP; 
    }
    
    
    public float getCantidadMP(int idB,float cantidad, int idP){
            float cantidadT = 0;
        String consulta = "select re.idBebida, mp.idProceso, re.idInvMP, cantidad, mp.costo from receta re, MateriaPrima mp "
                + "where re.idInvMP = mp.idInvMP and idBebida="+idB+" and idProceso ="+idP+" group by re.idInvMP";
       try {
           PreparedStatement ps = conexion.prepareStatement(consulta);
           ResultSet rs = ps.executeQuery();

           while(rs.next()){
               
               costoMP = costoMP+(rs.getFloat(5)*rs.getFloat(4));
               if(rs.getInt(3)!= 14){
               cantidadT = cantidadT + rs.getFloat(4);
               
               }
                
           }
           cantidadT = cantidadT*cantidad;
            System.out.println(cantidadT);
       } catch (SQLException ex) {
           Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
       }
       return cantidadT;
    }
    
    
    public float getCostoMP(){
    
    return costoMP;
    }

    public float getCostoMan(int Horas, int idproceso) {
        String consulta = "select idMantenimiento, Costo from Mantenimiento where idProceso="+idproceso;
       float costo = 0;
        try {
          
          PreparedStatement ps= conexion.prepareStatement(consulta);
          ResultSet rs = ps.executeQuery();
          while(rs.next()){
         costo = rs.getFloat(2)* Horas;
          }
       } catch (SQLException ex) {
           Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
       }
       
      return costo; 
    }

 

    public float getCostoRH(int Horas, int idproceso) {
       String consulta = "select idProceso,idRecursoHumano,nombre, costo from recursohumano where idProceso="+idproceso;
      float costo=0;
       try {         
          PreparedStatement ps= conexion.prepareStatement(consulta);
          ResultSet rs = ps.executeQuery();
          while(rs.next()){
          costo = rs.getFloat(4)* Horas;
          }
       } catch (SQLException ex) {
           Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
       }
       
      return costo; 
    }
    
    
    
    


}
