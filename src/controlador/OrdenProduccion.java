/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ConexionDB;
import modelo.Mantenimiento;

/**
 *
 * @author Felipe Montoya
 */
public class OrdenProduccion {
    private final ConexionDB conexionDB;
    private Connection conexion;
    private ArrayList<String> fechasOP = new ArrayList<>();
    ArrayList<Integer> idOrdenp = new ArrayList<>();
   private java.sql.Date dbSqlDate;
    private  Date fecha2;
    private int var;
    int lol = 2;
    public OrdenProduccion() {
        this.conexionDB = new ConexionDB();
        this.conexion= conexionDB.getConnection();  
    }
    
    
    public void insertarOrden(){
         
     String consulta = "select dem.fecha as agregar,ord.fecha, count(ord.fecha) from ordenproduccion ord, demanda dem where ord.fecha <> dem.fecha group by dem.Fecha";
     String consultao = "select count(idOrdenProduccion) from ordenproduccion";  
     try {
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            PreparedStatement ls = conexion.prepareStatement(consultao);
            ResultSet ms = ls.executeQuery();
            while (ms.next()) {var = ms.getInt(1);}
            while(rs.next()){
            if(rs.getInt(3)!= 0 && var ==1){
            java.sql.Date  SqlDate = rs.getDate(1);
            Date fecha = new java.util.Date(SqlDate.getTime());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaComoCadena = sdf.format(fecha);
            System.out.println(fechaComoCadena);
             
             calcularOrden(fechaComoCadena);
           
            }else{System.out.println("Ya hay registros");}
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error al obtener ordenes de produccion\n"+e);
        }
     
    }

    private void calcularOrden(String fecha) {
            ArrayList<Float> demanda = new ArrayList<>();
            ArrayList<Float> stock = new ArrayList<>();
            ArrayList<Integer> idBebida = new ArrayList<>();
            
            
            String consulta1 = "select idBebida,demanda, fecha from Demanda where fecha = '"+fecha+"'";
            String consulta2 = "select idBebida,Stock from Bebida";
            String consulta3 = "insert into OrdenProduccion(fecha,descripcion) values(?,'aplica')";
           
            //consulta#1 Demanda
            try {
            PreparedStatement ps = conexion.prepareStatement(consulta1);            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            dbSqlDate = rs.getDate(3);
            System.out.println("se consulto la fecha"+ rs.getDate(3) );
            fecha2 = new java.util.Date(dbSqlDate.getTime());
            float demandaPT = rs.getFloat(2);
            demanda.add(demandaPT);
            }
            //consulta#2 inventario de PT         
            ps = conexion.prepareStatement(consulta2);
            rs = ps.executeQuery();
            while(rs.next()){
            float StockPT = rs.getFloat(2);
            stock.add(StockPT);
            int idPT = rs.getInt(1);
            idBebida.add(idPT);
            }
            //poner en la base de datos una orden
            ps = conexion.prepareStatement(consulta3);
            ps.setDate(1,dbSqlDate);
            ps.execute();
            idOrdenp.add(lol);
            
            System.out.println(lol);
            
            //relacionar la orden con la cantidad y los productos            
             llenarOrdenB(demanda, stock,idBebida,lol);
             lol++;
            }
            catch(Exception e){
            System.out.println(e+" algo salio mal");
            }

    }

    private void llenarOrdenB(ArrayList<Float> demanda, ArrayList<Float> stock, ArrayList<Integer> idBebida, int lol) {
          String consulta4 = "insert into OrdenBebida(IdOrdenProduccion,idBebida,Cantidad) values(?,?,?)";
       
          
           for(int i=0; i<idBebida.size();i++){
               System.out.println(lol+", "+idBebida.get(i));
              PreparedStatement ps;
               try {
                   ps = conexion.prepareStatement(consulta4);
                   ps.setInt(1,lol);
                   ps.setInt(2,idBebida.get(i));
                   
                   ps.setFloat(3,demanda.get(i)-stock.get(i));
                   ps.execute();
                   
               } catch (SQLException ex) {
                   Logger.getLogger(OrdenProduccion.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
               
    }
    
    public ArrayList<String> getFechasOP(){
              String consulta = "select IdOrdenProduccion,fecha,descripcion from OrdenProduccion where idOrdenProduccion>1";
                           
        try {
             
            PreparedStatement ps; 
            ps = conexion.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            java.sql.Date sqlfecha = rs.getDate(2);
            Date fechaop = new java.util.Date(sqlfecha.getTime());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaComoCadena = sdf.format(fechaop);
            fechasOP.add(fechaComoCadena);
            System.out.println(fechaComoCadena);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdenProduccion.class.getName()).log(Level.SEVERE, null, ex);
        }
              
        return fechasOP;    
    }
}
