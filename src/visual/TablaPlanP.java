/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import javax.swing.JTable;

/**
 *
 * @author Felipe Montoya
 */
public class TablaPlanP extends javax.swing.JPanel {

    /**
     * Creates new form TablaDemandaP
     */
    public TablaPlanP() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1:00 am", null, null, null, null, null, null, null, null, null},
                {"2:00 am", null, null, null, null, null, null, null, null, null},
                {"3:00 am", null, null, null, null, null, null, null, null, null},
                {"4:00 am", null, null, null, null, null, null, null, null, null},
                {"5:00 am", null, null, null, null, null, null, null, null, null},
                {"6:00 am", null, null, null, null, null, null, null, null, null},
                {"7:00 am", null, null, null, null, null, null, null, null, null},
                {"8:00 am", null, null, null, null, null, null, null, null, null},
                {"9:00 am", null, null, null, null, null, null, null, null, null},
                {"10:00 am", null, null, null, null, null, null, null, null, null},
                {"11:00 am", null, null, null, null, null, null, null, null, null},
                {"12:00 am", null, null, null, null, null, null, null, null, null},
                {"13:00 am", null, null, null, null, null, null, null, null, null},
                {"14:00 am", null, null, null, null, null, null, null, null, null},
                {"15:00 am", null, null, null, null, null, null, null, null, null},
                {"16:00 am", null, null, null, null, null, null, null, null, null},
                {"17:00 am", null, null, null, null, null, null, null, null, null},
                {"18:00 am", null, null, null, null, null, null, null, null, null},
                {"19:00 am", null, null, null, null, null, null, null, null, null},
                {"20:00 am", null, null, null, null, null, null, null, null, null},
                {"21:00 am", null, null, null, null, null, null, null, null, null},
                {"22:00 am", null, null, null, null, null, null, null, null, null},
                {"23:00 am", null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Hora", "Triturado de malta", "Macerado", "Filtrado y aclarado", "Fermentación", "Maduración", "Filtración", "Mezclado", "Gasificación", "Embotellado"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
