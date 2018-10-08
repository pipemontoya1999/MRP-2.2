/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrp2;

import controlador.ControlPlanP;
import controlador.ControladorOrden;
import controlador.ControladorPanel;
import controlador.OrdenProduccion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import visual.PanelPrincipal;
import visual.TablaOrden;
import visual.TablaPlanP;

/**
 *
 * @author Felipe Montoya
 */
public class Mrp2 {

    /**
     * @param args the command line arguments
     */
    private static ControlPlanP controlPP;
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        

        /* Create and display the form */
        OrdenProduccion orden = new OrdenProduccion();
        orden.insertarOrden();
        
        PanelPrincipal panel = new PanelPrincipal();
        TablaPlanP tablaPP = new TablaPlanP();
        TablaOrden torden = new TablaOrden();
        
        
        ControladorPanel controladorPanel = new ControladorPanel(panel,tablaPP,torden);
        controladorPanel.inicializarPestanas();
        ControladorOrden ordenF = new ControladorOrden (torden);
        
        
        JButton jButton = torden.getjButton1();
        
                
       jButton.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
            controlPP = null;
            controlPP = new ControlPlanP(tablaPP,ordenF.getIdBebidas(),ordenF.getBeCantidad());
            controlPP.iniciar();
      
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
