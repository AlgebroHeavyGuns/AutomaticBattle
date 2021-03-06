/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import java.awt.Font;

import automaticbattle.Controlador;
import automaticbattle.Escenografia;
import automaticbattle.Tablero;
import automaticbattle.Unidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

/**
 *
 * @author Algebro
 */
public class Region extends javax.swing.JPanel implements ComponentListener, ActionListener{

    /**
     * Creates new form PanelPrueba
     */
    
    final int nRows = 9;
    final int nColumns = 9;
    int varX=0, varY=0;
    
    JButton[][] buttons;
    Tablero mapa;
    
    public Region() {
        initComponents();
    }
    
    
    public void generateZone(){
        int nR = nRows;
        int nC = nColumns;
        int TAM = 60;
        
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
        Panel.updateUI();
    }
    
    public void setMap(Tablero tablero){
        this.mapa = tablero;
        drawMap(0,0);
    }
    
    public void drawMap(int xpiv,int ypiv){
        Unidad U;

        if(xpiv >= nRows/2){
            if(xpiv >= mapa.getTAM_X()-nRows/2)
                varX = mapa.getTAM_X()-nRows;
            else
                varX = xpiv-4;
        }else
            varX = 0;
        if(ypiv >= nColumns/2){
            if(ypiv >= mapa.getTAM_Y()-nColumns/2)
                varY = mapa.getTAM_Y()-nColumns;
            else
                varY = ypiv-4;   
        }else
            varY=0;
        for(int i=0;i<nRows;i++)
            for(int j=0;j<nColumns;j++){
                U = mapa.ocupada(i+varX, j+varY);
                if(U==null){
                    buttons[i][j].setIcon(new ImageIcon(getClass().getResource("/Images/icons/suelo.jpg")));
                    buttons[i][j].setBorder(null);
                }else{
                    if(U instanceof Escenografia){
                        buttons[i][j].setIcon(new ImageIcon(getClass().getResource("/Images/escenas/"+ U.getImagen())));
                        buttons[i][j].setBorder(null);
                    }else{
                        buttons[i][j].setIcon(new ImageIcon(getClass().getResource("/Images/units/"+ U.getImagen())));
                        buttons[i][j].setBorder(getBorderUnidad(U));
                    }
                }
            }
                
    }
    
    
    private Border getBorderUnidad(Unidad U){
        boolean atacada = U.getSidoAtacada();
        if(atacada){
            if(U.getVida()<100)
                return new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true);
            else if(U.getVida() < 250)
                return new javax.swing.border.LineBorder(new java.awt.Color(200, 120, 120), 2, true);
            else
                return new javax.swing.border.LineBorder(new java.awt.Color(80, 220, 80), 2, true);
        }else
            return null;
    }
    
    private void pressed (JButton B){
        int num = Integer.parseInt(B.getName() );
        Unidad U = U = mapa.ocupada(num/nColumns+varX,  num%nColumns+varY);
        
        if(U!=null){
            if(U instanceof Escenografia)
                Controlador.getInstance().combateActual.panel.insertarInfo("Obstáculo " + U.getNombre());
            else
                /*Controlador.getInstance().combateActual.panel.insertarInfo(U.getNombre()+ " (" + 
                        U.getVida() + " | " + U.getEnergia() + "  | " +
                        U.getFuerza() + " | " + U.getIntelecto() + "  | " +
                        U.getArmadura() + " | " + U.getBlindaje() + " )");
                */
                Controlador.getInstance().combateActual.panel.insertarInfo(U.getNombre() + " ( " +
                        U.getVida() + "/" + U.getVidaInicial() + " )");
        }else
            Controlador.getInstance().combateActual.panel.insertarInfo("Casilla vacía.");
        /*
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
