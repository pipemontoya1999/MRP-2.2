/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import visual.PanelPrincipal;
import visual.TablaOrden;
import visual.TablaOrdenR;
import visual.TablaPlanP;
import visual.TablaPlanR;

/**
 *
 * @author Felipe Montoya
 */
public class ControladorPanel {

    private TablaPlanP tabla;
    private PanelPrincipal panel;
    private TablaOrden torden;
    private TablaOrdenR tordenr;
    private TablaPlanR tablar;



    public ControladorPanel(PanelPrincipal panel, TablaPlanP tabla, TablaOrden torden, TablaOrdenR tordenr, TablaPlanR tablar) {
        this.tabla = tabla;
        this.panel = panel;
        this.torden = torden;
        this.tordenr = tordenr;
        this.tablar = tablar;

    }
    
        public void inicializarPestanas()
    {       
        
        panel.getjPanel1().setLayout(new java.awt.FlowLayout());
        panel.getjPanel1().add(tabla, BorderLayout.CENTER);
        panel.getjPanel2().setLayout(new java.awt.FlowLayout());
        panel.getjPanel2().add(torden, BorderLayout.CENTER);
        panel.getjPanel3().setLayout(new java.awt.FlowLayout());
        panel.getjPanel3().add(tablar, BorderLayout.CENTER);
        panel.getjPanel4().setLayout(new java.awt.FlowLayout());
        panel.getjPanel4().add(tordenr, BorderLayout.CENTER);
    }
    
}
