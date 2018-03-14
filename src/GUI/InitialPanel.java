/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import automaticbattle.Controlador;

/**
 *
 * @author Algebro
 */
public class InitialPanel extends javax.swing.JPanel {

    /**
     * Creates new form InitialPanel
     */
    VentanaDeJuego vj;
    public InitialPanel(VentanaDeJuego VJ) {
        initComponents();
        backgroundPanel1.setBackground("src/Images/backgrounds/back1.jpg");
        vj = VJ;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel1 = new GUI.BackgroundPanel();
        jugarButton = new javax.swing.JButton();

        jugarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/letters/jugar100.png"))); // NOI18N
        jugarButton.setBorderPainted(false);
        jugarButton.setContentAreaFilled(false);
        jugarButton.setFocusPainted(false);
        jugarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundPanel1Layout = new javax.swing.GroupLayout(backgroundPanel1);
        backgroundPanel1.setLayout(backgroundPanel1Layout);
        backgroundPanel1Layout.setHorizontalGroup(
            backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanel1Layout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(jugarButton)
                .addContainerGap(306, Short.MAX_VALUE))
        );
        backgroundPanel1Layout.setVerticalGroup(
            backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanel1Layout.createSequentialGroup()
                .addContainerGap(301, Short.MAX_VALUE)
                .addComponent(jugarButton)
                .addGap(162, 162, 162))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jugarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarButtonActionPerformed
        Controlador.getInstance().iniciaCombate();
        vj.setPanel(new CombatePanel(vj));
    }//GEN-LAST:event_jugarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.BackgroundPanel backgroundPanel1;
    private javax.swing.JButton jugarButton;
    // End of variables declaration//GEN-END:variables
}