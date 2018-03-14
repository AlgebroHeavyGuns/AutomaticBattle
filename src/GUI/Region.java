/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Algebro
 */
public class Region extends javax.swing.JPanel implements ComponentListener, ActionListener{

    /**
     * Creates new form PanelPrueba
     */
    
    final int nRows = 7;
    final int nColumns = 7;
    
    JButton[][] buttons;
    
    public Region() {
        initComponents();
    }
    
    
    public void generateZone(){
        int nR = nRows;
        int nC = nColumns;
        int TAM = 80;
        
        Panel.removeAll();
        
        buttons = new JButton[nR][nC];
        
        for(int r=0; r<nR; r++)
            for(int c=0; c<nC; c++){
                JButton B = new JButton();
                B.setName(Integer.toString(r*nC+c));
                B.setBounds(c*TAM, r*TAM, TAM, TAM);
                B.addActionListener(this);
                B.setFocusable(false);
                Panel.add(B);
                buttons[r][c] = B;
            }
        drawMap();
        Panel.updateUI();
    }
    
    public void drawMap(){
    
    }
    
    private void pressed (JButton B){
        int num = Integer.parseInt(B.getName() );
        /*System.out.println("\nPressed : " + num);
        System.out.println("Coordenadas : [" + num/nColumnas + "][" + num%nColumnas + "]"););
        *//*
        int r = num/nColumns, c = num%nColumns;
        Building building = M.getIn(r, c);
        if(BW == null)
            BW = new BuildWindow(r,c,this);
        else{
            BW.dispose();
            BW = new BuildWindow(r,c,this);
        }
        BW.setVisible(true);
        */
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();

        Panel.setToolTipText("");
        Panel.setOpaque(false);
        Panel.setPreferredSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentResized(ComponentEvent e) {
        generateZone();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentShown(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void actionPerformed (ActionEvent e){
        if(e.getSource() instanceof JButton){
            pressed((JButton)e.getSource());
        }
    }
}
