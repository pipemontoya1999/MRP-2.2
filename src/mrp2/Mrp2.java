/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrp2;

import controlador.ControlPlanP;
import controlador.ControlPlanR;
import controlador.ControladorModificar;
import controlador.ControladorOrden;
import controlador.ControladorOrdenR;
import controlador.ControladorPanel;
import controlador.OrdenProduccion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Bebidas;
import visual.Costos;
import visual.Eventos;
import visual.ModificarReceta;
import visual.PanelPrincipal;
import visual.TablaOrden;
import visual.TablaOrdenR;
import visual.TablaPlanP;
import visual.TablaPlanR;

/**
 *
 * @author Felipe Montoya
 */
public class Mrp2 {

    /**
     * @param args the command line arguments
     */
    private static ControlPlanP controlPP;
    private static ControlPlanR controlPR;
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        

        /* Create and display the form */
        OrdenProduccion orden = new OrdenProduccion();
        orden.insertarOrden();
        
        PanelPrincipal panel = new PanelPrincipal();
        Costos costos = new Costos();
        TablaPlanP tablaPP = new TablaPlanP();
        TablaOrden torden = new TablaOrden();
        TablaOrdenR tordenr = new TablaOrdenR();
        TablaPlanR tablaPR = new TablaPlanR();
        Eventos eventos = new Eventos();
        ModificarReceta modr = new ModificarReceta();
        ControladorPanel controladorPanel = new ControladorPanel(panel,tablaPP,torden,tordenr,tablaPR,costos);
        controladorPanel.inicializarPestanas();
        ControladorOrden ordenF = new ControladorOrden (torden);
        ControladorOrdenR ordenR = new ControladorOrdenR (tordenr);
        
        JButton jButton1 = torden.getjButton1();
        JButton jButton2 = tordenr.getjButton1();
        
        Bebidas bebidas = new Bebidas();
                
       jButton1.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
            controlPP = null;
            controlPP = new ControlPlanP(tablaPP,ordenF.getIdBebidas(),ordenF.getBeCantidad(),costos);
            controlPP.iniciar();     
      } 
       } );
       
              jButton2.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
            eventos.setVisible(true);
            JButton jButton = eventos.getjButton1();
            
        jButton.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
            ControladorModificar modificar = new ControladorModificar(modr,bebidas.getBebidas());
            modr.setVisible(true);                  }        } );
        
        JButton jButton2 = eventos.getjButton2();

                jButton2.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
            System.out.println("seeeee papuuu");
             controlPR = null;
          controlPR = new ControlPlanR(tablaPR,ordenR.getIdBebidas(),ordenR.getBeCantidad(),costos);
          controlPR.iniciar();
                             }        } );
            
        // controlPR = null;
         //   controlPR = new ControlPlanR(tablaPR,ordenF.getIdBebidas(),ordenF.getBeCantidad());
        //   controlPR.iniciar();
           
      
      } 
       } );
       
        
        
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PanelPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                panel.setVisible(true);
            }
        });
    }
    

    
}
