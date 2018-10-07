/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.BorderLayout;
import visual.PanelPrincipal;
import visual.TablaOrden;
import visual.TablaPlanP;

/**
 *
 * @author Felipe Montoya
 */
public class ControladorPanel {

    private TablaPlanP tabla;
    private PanelPrincipal panel;
    private TablaOrden torden;


    public ControladorPanel(PanelPrincipal panel, TablaPlanP tabla, TablaOrden torden) {
        this.tabla = tabla;
        this.panel = panel;
        this.torden = torden;
    }
    
        public void inicializarPestanas()
    {        
        panel.getjPanel1().setLayout(new java.awt.FlowLayout());
        panel.getjPanel1().add(tabla, BorderLayout.CENTER);
        panel.getjPanel2().setLayout(new java.awt.FlowLayout());
        panel.getjPanel2().add(torden, BorderLayout.CENTER);
    }
    
}
