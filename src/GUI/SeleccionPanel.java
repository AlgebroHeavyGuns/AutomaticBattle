/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import automaticbattle.Controlador;
import automaticbattle.Equipable;
import automaticbattle.Unidad;
import database.Database;
import database.ProductorCombate;
import java.util.ArrayList;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author Algebro
 */
public class SeleccionPanel extends javax.swing.JPanel {

    /**
     * Creates new form CombatePanel
     */
    
    VentanaDeJuego vj;
    int combateNivel;
    int maxPresupuesto;
    int gastoActual=0;
    int indiceEquipo=0;
    int indicePersonaje=0;
    
    public SeleccionPanel(VentanaDeJuego VJ) {
        initComponents();
        this.vj = VJ;
        combateNivel = Controlador.getInstance().indiceCombate;
        maxPresupuesto = ProductorCombate.getInstance().getPresupuestocombateNivel(combateNivel);
        backgroundPanel1.setBackground("src/Images/backgrounds/dark1.jpg");
        DefaultCaret caret = (DefaultCaret)infoPanel.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        setBotones();
        /*
        this.region1.generateZone();
        this.region1.setMap(Controlador.getInstance().combateActual.getTablero());
        */
    }

    ArrayList<Unidad> aliadas = new ArrayList<>();
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel1 = new GUI.BackgroundPanel();
        jButton3 = new javax.swing.JButton();
        personaje1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        infoPanel = new javax.swing.JTextArea();
        personaje2 = new javax.swing.JButton();
        equipo2 = new javax.swing.JButton();
        equipo1 = new javax.swing.JButton();
        equipo3 = new javax.swing.JButton();
        presupuestoRestante = new javax.swing.JLabel();
        coste1 = new javax.swing.JButton();
        coste2 = new javax.swing.JButton();
        coste3 = new javax.swing.JButton();
        equipo5 = new javax.swing.JButton();
        coste5 = new javax.swing.JButton();
        personaje3 = new javax.swing.JButton();
        masEquipos = new javax.swing.JButton();
        masPersonajes = new javax.swing.JButton();
        personaje4 = new javax.swing.JButton();
        coste4 = new javax.swing.JButton();
        equipo4 = new javax.swing.JButton();
        menosEquipos1 = new javax.swing.JButton();
        menosPersonajes = new javax.swing.JButton();

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jButton3.setForeground(new java.awt.Color(153, 204, 255));
        jButton3.setText("COMBATIR");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        personaje1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        personaje1.setForeground(new java.awt.Color(204, 204, 255));
        personaje1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/units/Beast1.png"))); // NOI18N
        personaje1.setText("PERSONAJE 1");
        personaje1.setBorderPainted(false);
        personaje1.setContentAreaFilled(false);
        personaje1.setFocusPainted(false);
        personaje1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personaje1ActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setOpaque(false);

        infoPanel.setEditable(false);
        infoPanel.setBackground(new java.awt.Color(102, 102, 102));
        infoPanel.setColumns(20);
        infoPanel.setFont(new java.awt.Font("Monospaced", 3, 11)); // NOI18N
        infoPanel.setForeground(new java.awt.Color(153, 255, 204));
        infoPanel.setRows(5);
        infoPanel.setBorder(null);
        infoPanel.setFocusable(false);
        infoPanel.setOpaque(false);
        jScrollPane2.setViewportView(infoPanel);

        personaje2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        personaje2.setForeground(new java.awt.Color(204, 204, 255));
        personaje2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/units/Beast1.png"))); // NOI18N
        personaje2.setText("PERSONAJE 2");
        personaje2.setBorderPainted(false);
        personaje2.setContentAreaFilled(false);
        personaje2.setFocusPainted(false);
        personaje2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personaje2ActionPerformed(evt);
            }
        });

        equipo2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        equipo2.setForeground(new java.awt.Color(204, 204, 255));
        equipo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/equipos/axe.png"))); // NOI18N
        equipo2.setText("PERSONAJE 1");
        equipo2.setBorderPainted(false);
        equipo2.setContentAreaFilled(false);
        equipo2.setFocusPainted(false);
        equipo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipo2ActionPerformed(evt);
            }
        });

        equipo1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        equipo1.setForeground(new java.awt.Color(204, 204, 255));
        equipo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/equipos/axe.png"))); // NOI18N
        equipo1.setText("PERSONAJE 1");
        equipo1.setBorderPainted(false);
        equipo1.setContentAreaFilled(false);
        equipo1.setFocusPainted(false);
        equipo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipo1ActionPerformed(evt);
            }
        });

        equipo3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        equipo3.setForeground(new java.awt.Color(204, 204, 255));
        equipo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/equipos/axe.png"))); // NOI18N
        equipo3.setText("PERSONAJE 1");
        equipo3.setBorderPainted(false);
        equipo3.setContentAreaFilled(false);
        equipo3.setFocusPainted(false);
        equipo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipo3ActionPerformed(evt);
            }
        });

        presupuestoRestante.setFont(new java.awt.Font("Urdu Typesetting", 1, 18)); // NOI18N
        presupuestoRestante.setForeground(new java.awt.Color(153, 255, 153));
        presupuestoRestante.setText("PRESUPUESTO RESTANTE : ");

        coste1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        coste1.setForeground(new java.awt.Color(153, 255, 204));
        coste1.setText("COSTE X");
        coste1.setBorderPainted(false);
        coste1.setContentAreaFilled(false);
        coste1.setFocusPainted(false);
        coste1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        coste1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        coste2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        coste2.setForeground(new java.awt.Color(153, 255, 204));
        coste2.setText("COSTE X");
        coste2.setBorderPainted(false);
        coste2.setContentAreaFilled(false);
        coste2.setFocusPainted(false);
        coste2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        coste2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        coste3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        coste3.setForeground(new java.awt.Color(153, 255, 204));
        coste3.setText("COSTE X");
        coste3.setBorderPainted(false);
        coste3.setContentAreaFilled(false);
        coste3.setFocusPainted(false);
        coste3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        coste3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        equipo5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        equipo5.setForeground(new java.awt.Color(204, 204, 255));
        equipo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/equipos/axe.png"))); // NOI18N
        equipo5.setText("PERSONAJE 1");
        equipo5.setBorderPainted(false);
        equipo5.setContentAreaFilled(false);
        equipo5.setFocusPainted(false);
        equipo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipo5ActionPerformed(evt);
            }
        });

        coste5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        coste5.setForeground(new java.awt.Color(153, 255, 204));
        coste5.setText("COSTE X");
        coste5.setBorderPainted(false);
        coste5.setContentAreaFilled(false);
        coste5.setFocusPainted(false);
        coste5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        coste5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        personaje3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        personaje3.setForeground(new java.awt.Color(204, 204, 255));
        personaje3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/units/Beast1.png"))); // NOI18N
        personaje3.setText("PERSONAJE 3");
        personaje3.setBorderPainted(false);
        personaje3.setContentAreaFilled(false);
        personaje3.setFocusPainted(false);
        personaje3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personaje3ActionPerformed(evt);
            }
        });

        masEquipos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        masEquipos.setForeground(new java.awt.Color(153, 153, 255));
        masEquipos.setText("VER MÁS EQUIPOS");
        masEquipos.setBorderPainted(false);
        masEquipos.setContentAreaFilled(false);
        masEquipos.setFocusPainted(false);
        masEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masEquiposActionPerformed(evt);
            }
        });

        masPersonajes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        masPersonajes.setForeground(new java.awt.Color(153, 153, 255));
        masPersonajes.setText("VER MÁS PERSONAJES");
        masPersonajes.setBorderPainted(false);
        masPersonajes.setContentAreaFilled(false);
        masPersonajes.setFocusPainted(false);
        masPersonajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masPersonajesActionPerformed(evt);
            }
        });

        personaje4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        personaje4.setForeground(new java.awt.Color(204, 204, 255));
        personaje4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/units/Beast1.png"))); // NOI18N
        personaje4.setText("PERSONAJE 3");
        personaje4.setBorderPainted(false);
        personaje4.setContentAreaFilled(false);
        personaje4.setFocusPainted(false);
        personaje4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personaje4ActionPerformed(evt);
            }
        });

        coste4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        coste4.setForeground(new java.awt.Color(153, 255, 204));
        coste4.setText("COSTE X");
        coste4.setBorderPainted(false);
        coste4.setContentAreaFilled(false);
        coste4.setFocusPainted(false);
        coste4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        coste4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        equipo4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        equipo4.setForeground(new java.awt.Color(204, 204, 255));
        equipo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/equipos/axe.png"))); // NOI18N
        equipo4.setText("PERSONAJE 1");
        equipo4.setBorderPainted(false);
        equipo4.setContentAreaFilled(false);
        equipo4.setFocusPainted(false);
        equipo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipo4ActionPerformed(evt);
            }
        });

        menosEquipos1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        menosEquipos1.setForeground(new java.awt.Color(153, 153, 255));
        menosEquipos1.setText("VER MENOS EQUIPOS");
        menosEquipos1.setBorderPainted(false);
        menosEquipos1.setContentAreaFilled(false);
        menosEquipos1.setFocusPainted(false);
        menosEquipos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menosEquipos1ActionPerformed(evt);
            }
        });

        menosPersonajes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        menosPersonajes.setForeground(new java.awt.Color(153, 153, 255));
        menosPersonajes.setText("VER MENOS PERSONAJES");
        menosPersonajes.setBorderPainted(false);
        menosPersonajes.setContentAreaFilled(false);
        menosPersonajes.setFocusPainted(false);
        menosPersonajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menosPersonajesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundPanel1Layout = new javax.swing.GroupLayout(backgroundPanel1);
        backgroundPanel1.setLayout(backgroundPanel1Layout);
        backgroundPanel1Layout.setHorizontalGroup(
            backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(personaje2)
                    .addComponent(personaje1)
                    .addComponent(personaje3)
                    .addComponent(presupuestoRestante, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(masPersonajes)
                    .addComponent(personaje4)
                    .addComponent(menosPersonajes))
                .addGap(18, 18, 18)
                .addGroup(backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanel1Layout.createSequentialGroup()
                        .addGroup(backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(backgroundPanel1Layout.createSequentialGroup()
                                .addGroup(backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(backgroundPanel1Layout.createSequentialGroup()
                                        .addComponent(equipo1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(coste1))
                                    .addGroup(backgroundPanel1Layout.createSequentialGroup()
                                        .addComponent(equipo2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(coste2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(backgroundPanel1Layout.createSequentialGroup()
                                        .addComponent(equipo4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(coste4))
                                    .addGroup(backgroundPanel1Layout.createSequentialGroup()
                                        .addComponent(equipo5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(coste5)))))
                        .addGap(0, 23, Short.MAX_VALUE))
                    .addGroup(backgroundPanel1Layout.createSequentialGroup()
                        .addComponent(equipo3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(coste3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(masEquipos)
                            .addComponent(menosEquipos1))))
                .addContainerGap())
        );
        backgroundPanel1Layout.setVerticalGroup(
            backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanel1Layout.createSequentialGroup()
                        .addGroup(backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(equipo1)
                            .addComponent(coste1)
                            .addComponent(coste4)
                            .addComponent(equipo4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(equipo2)
                            .addComponent(coste2)
                            .addComponent(equipo5)
                            .addComponent(coste5))
                        .addGroup(backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(equipo3)
                                    .addComponent(coste3)))
                            .addGroup(backgroundPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(masEquipos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(menosEquipos1)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundPanel1Layout.createSequentialGroup()
                        .addGroup(backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundPanel1Layout.createSequentialGroup()
                                .addComponent(presupuestoRestante)
                                .addGap(83, 83, 83))
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(30, 30, 30)
                        .addComponent(personaje1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(personaje2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(personaje3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(personaje4)
                        .addGap(18, 18, 18)
                        .addComponent(masPersonajes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(menosPersonajes)))
                .addContainerGap(34, Short.MAX_VALUE))
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(!aliadas.isEmpty()){
            Controlador.getInstance().iniciaCombate(aliadas);

            vj.setPanel(new CombatePanel(vj));
        }else
            this.insertarInfo("No dispones de ninguna unidad");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void personaje1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personaje1ActionPerformed
        seleccionarPersonaje(personaje1.getText());
    }//GEN-LAST:event_personaje1ActionPerformed

    private void personaje2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personaje2ActionPerformed
        seleccionarPersonaje(personaje2.getText());
    }//GEN-LAST:event_personaje2ActionPerformed

    private void equipo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipo2ActionPerformed
        equipar(Database.getInstance().getEquipo(equipo2.getText()));
    }//GEN-LAST:event_equipo2ActionPerformed

    private void equipo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipo1ActionPerformed
        equipar(Database.getInstance().getEquipo(equipo1.getText()));
    }//GEN-LAST:event_equipo1ActionPerformed

    private void equipo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipo3ActionPerformed
        equipar(Database.getInstance().getEquipo(equipo3.getText()));
    }//GEN-LAST:event_equipo3ActionPerformed

    private void equipo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipo4ActionPerformed
        equipar(Database.getInstance().getEquipo(equipo4.getText()));
    }//GEN-LAST:event_equipo4ActionPerformed

    private void equipo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipo5ActionPerformed
        equipar(Database.getInstance().getEquipo(equipo5.getText()));
    }//GEN-LAST:event_equipo5ActionPerformed

    private void masEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masEquiposActionPerformed
        indiceEquipo+=5;
        setBotones();
    }//GEN-LAST:event_masEquiposActionPerformed

    private void personaje3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personaje3ActionPerformed
        seleccionarPersonaje(personaje3.getText());
        setBotones();
    }//GEN-LAST:event_personaje3ActionPerformed

    private void masPersonajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masPersonajesActionPerformed
        indicePersonaje+=4;
        setBotones();
    }//GEN-LAST:event_masPersonajesActionPerformed

    private void personaje4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personaje4ActionPerformed
        seleccionarPersonaje(personaje4.getText());
    }//GEN-LAST:event_personaje4ActionPerformed

    private void menosEquipos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menosEquipos1ActionPerformed
        indiceEquipo-=5;
        setBotones();
    }//GEN-LAST:event_menosEquipos1ActionPerformed

    private void menosPersonajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menosPersonajesActionPerformed
        indicePersonaje-=4;
        setBotones();
    }//GEN-LAST:event_menosPersonajesActionPerformed
    
    private void seleccionarPersonaje(String S){
        aliadas.add(Database.getInstance().getUnidadAliada(S));
        insertarInfo("Seleccionado " + S + "\nTotal unidades : " + aliadas.size());
    }

    
    private void equipar(Equipable E){
        Unidad U;
        if(!aliadas.isEmpty()){
            U=aliadas.get(aliadas.size()-1);
            if(!E.puedeEquiparseA(U.getTipo()))
                this.insertarInfo(E.getNombre() + " no se puede equipar a " + U.getTipo().name() + "s.");
            else if(gastoActual+E.getCoste() > maxPresupuesto)
                this.insertarInfo("Fondos insuficientes...");
            else{
                Equipable otro = U.equipar(E);
                if(otro==null){
                    this.insertarInfo(U.getNombre() + " equipado con " + E.getNombre());
                    gastoActual+=E.getCoste();
                    this.presupuestoRestante.setText("Presupuesto restante : "+(maxPresupuesto-gastoActual));
                }else
                    this.insertarInfo("No puede equipar, ya tiene " + otro.getNombre());
            }
        }else
            this.insertarInfo("Primero debes seleccionar una unidad.");
    }
    
    
    public void insertarInfo(String info){
        this.infoPanel.setText(infoPanel.getText()+info+"\n");
    }

    
    
    private void setBotones(){
        ArrayList<Unidad> personajes = Database.getInstance().getUnidadesAliadas();
        if(indicePersonaje > personajes.size()-3)
            indicePersonaje=personajes.size()-4;
        if(indicePersonaje < 0)
            indicePersonaje=0;
        personaje1.setText(personajes.get(indicePersonaje).getNombre());
        personaje1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/units/" + personajes.get(indicePersonaje).getImagen())));
        personaje2.setText(personajes.get(indicePersonaje+1).getNombre());
        personaje2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/units/" + personajes.get(indicePersonaje+1).getImagen())));
        personaje3.setText(personajes.get(indicePersonaje+2).getNombre());
        personaje3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/units/" + personajes.get(indicePersonaje+2).getImagen())));
        personaje4.setText(personajes.get(indicePersonaje+3).getNombre());
        personaje4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/units/" + personajes.get(indicePersonaje+3).getImagen())));
        ArrayList<Equipable> equipos = Database.getInstance().getEquipos(999);
        int tam = equipos.size();
        if(indiceEquipo > tam-4)
            indiceEquipo=tam-5;
        if(indiceEquipo < 0)
            indiceEquipo=0;
        tam = equipos.size()-indiceEquipo;
        if(tam > 5)
            tam=5;
        switch(tam){
            case 5:
                equipo5.setText(equipos.get(indiceEquipo+4).getNombre());
                coste5.setText(""+equipos.get(indiceEquipo+4).getCoste());
                equipo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/equipos/" + equipos.get(indiceEquipo+4).getImagen())));
            case 4:
                equipo4.setText(equipos.get(indiceEquipo+3).getNombre());
                coste4.setText(""+equipos.get(indiceEquipo+3).getCoste());
                equipo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/equipos/" + equipos.get(indiceEquipo+3).getImagen())));
            case 3:
                equipo3.setText(equipos.get(indiceEquipo+2).getNombre());
                coste3.setText(""+equipos.get(indiceEquipo+2).getCoste());
                equipo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/equipos/" + equipos.get(indiceEquipo+2).getImagen())));
            case 2:
                equipo2.setText(equipos.get(indiceEquipo+1).getNombre());
                coste2.setText(""+equipos.get(indiceEquipo+1).getCoste());
                equipo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/equipos/" + equipos.get(indiceEquipo+1).getImagen())));
            case 1:    
                equipo1.setText(equipos.get(indiceEquipo).getNombre());
                coste1.setText(""+equipos.get(indiceEquipo).getCoste());
                equipo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/equipos/" + equipos.get(indiceEquipo).getImagen())));              
        }

        this.presupuestoRestante.setText("Presupuesto  restante   :  "+(maxPresupuesto-gastoActual));
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.BackgroundPanel backgroundPanel1;
    private javax.swing.JButton coste1;
    private javax.swing.JButton coste2;
    private javax.swing.JButton coste3;
    private javax.swing.JButton coste4;
    private javax.swing.JButton coste5;
    private javax.swing.JButton equipo1;
    private javax.swing.JButton equipo2;
    private javax.swing.JButton equipo3;
    private javax.swing.JButton equipo4;
    private javax.swing.JButton equipo5;
    private javax.swing.JTextArea infoPanel;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton masEquipos;
    private javax.swing.JButton masPersonajes;
    private javax.swing.JButton menosEquipos1;
    private javax.swing.JButton menosPersonajes;
    private javax.swing.JButton personaje1;
    private javax.swing.JButton personaje2;
    private javax.swing.JButton personaje3;
    private javax.swing.JButton personaje4;
    private javax.swing.JLabel presupuestoRestante;
    // End of variables declaration//GEN-END:variables
}
