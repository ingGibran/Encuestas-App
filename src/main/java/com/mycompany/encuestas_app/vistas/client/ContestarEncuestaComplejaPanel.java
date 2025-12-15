package com.mycompany.encuestas_app.vistas.client;

import com.mycompany.encuestas_app.vistas.client.ContestarEncuestaComplejaFrame;
import java.awt.Color;

public class ContestarEncuestaComplejaPanel extends javax.swing.JPanel {
        
        public int indice;
        public String pregunta;
        public int respuesta = 0;
        public ContestarEncuestaComplejaFrame frame;
        

        public ContestarEncuestaComplejaPanel(int indice, String pregunta, ContestarEncuestaComplejaFrame frame) {
                initComponents();
                
                this.indice = indice;
                this.pregunta = pregunta;
                this.frame = frame;
                
                lblPregunta.setText(pregunta);
                lblIndice.setText( (indice+1) + "" );
                
        }
        
        

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                btnUno = new org.edisoncor.gui.button.ButtonIcon();
                btnDos = new org.edisoncor.gui.button.ButtonIcon();
                btnTres = new org.edisoncor.gui.button.ButtonIcon();
                btnCuatro = new org.edisoncor.gui.button.ButtonIcon();
                btnCinco = new org.edisoncor.gui.button.ButtonIcon();
                lblPregunta = new javax.swing.JLabel();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                lblIndice = new javax.swing.JLabel();
                jSeparator1 = new javax.swing.JSeparator();

                btnUno.setIcon(new javax.swing.ImageIcon("/home/alexpy/NetBeansProjects/Encuestas_App/images/1.png")); // NOI18N
                btnUno.setText("buttonIcon1");
                btnUno.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnUnoActionPerformed(evt);
                        }
                });

                btnDos.setIcon(new javax.swing.ImageIcon("/home/alexpy/NetBeansProjects/Encuestas_App/images/2.png")); // NOI18N
                btnDos.setText("buttonIcon1");
                btnDos.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnDosActionPerformed(evt);
                        }
                });

                btnTres.setIcon(new javax.swing.ImageIcon("/home/alexpy/NetBeansProjects/Encuestas_App/images/3.png")); // NOI18N
                btnTres.setText("buttonIcon1");
                btnTres.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnTresActionPerformed(evt);
                        }
                });

                btnCuatro.setIcon(new javax.swing.ImageIcon("/home/alexpy/NetBeansProjects/Encuestas_App/images/4.png")); // NOI18N
                btnCuatro.setText("buttonIcon1");
                btnCuatro.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCuatroActionPerformed(evt);
                        }
                });

                btnCinco.setIcon(new javax.swing.ImageIcon("/home/alexpy/NetBeansProjects/Encuestas_App/images/5.png")); // NOI18N
                btnCinco.setText("buttonIcon1");
                btnCinco.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCincoActionPerformed(evt);
                        }
                });

                lblPregunta.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
                lblPregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lblPregunta.setText("Pregunta");

                jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
                jLabel1.setText("Muy de acuerdo / a favor");

                jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
                jLabel2.setText("Muy en desacuerdo / en contra");

                lblIndice.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
                lblIndice.setText("n");

                jSeparator1.setBackground(new java.awt.Color(0, 102, 255));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(lblIndice, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(208, 208, 208)
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnUno, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(32, 32, 32)
                                                .addComponent(btnDos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(btnTres, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addComponent(btnCuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(29, 29, 29)
                                                .addComponent(btnCinco, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(98, 98, 98))
                        .addComponent(jSeparator1)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPregunta)
                                        .addComponent(lblIndice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnTres, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCinco, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnUno, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addGap(16, 16, 16))
                );
        }// </editor-fold>//GEN-END:initComponents

        private void btnUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnoActionPerformed
                respuesta = 1;
                frame.valores_respuestas.set(indice, respuesta);
                limpiar();
                btnUno.setBackground(Color.GREEN);
        }//GEN-LAST:event_btnUnoActionPerformed

        private void btnDosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDosActionPerformed
                respuesta = 2;
                frame.valores_respuestas.set(indice, respuesta);
                limpiar();
                btnDos.setBackground(Color.GREEN);
        }//GEN-LAST:event_btnDosActionPerformed

        private void btnTresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTresActionPerformed
                respuesta = 3;
                frame.valores_respuestas.set(indice, respuesta);
                limpiar();
                btnTres.setBackground(Color.GREEN);
        }//GEN-LAST:event_btnTresActionPerformed

        private void btnCuatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuatroActionPerformed
                respuesta = 4;
                frame.valores_respuestas.set(indice, respuesta);
                limpiar();
                btnCuatro.setBackground(Color.GREEN);
        }//GEN-LAST:event_btnCuatroActionPerformed

        private void btnCincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCincoActionPerformed
                respuesta = 5;
                frame.valores_respuestas.set(indice, respuesta);
                limpiar();
                btnCinco.setBackground(Color.GREEN);
        }//GEN-LAST:event_btnCincoActionPerformed
        
        public void limpiar() {
                btnUno.setBackground(Color.white);
                btnDos.setBackground(Color.white);
                btnTres.setBackground(Color.white);
                btnCuatro.setBackground(Color.white);
                btnCinco.setBackground(Color.white);
        }
        

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private org.edisoncor.gui.button.ButtonIcon btnCinco;
        private org.edisoncor.gui.button.ButtonIcon btnCuatro;
        private org.edisoncor.gui.button.ButtonIcon btnDos;
        private org.edisoncor.gui.button.ButtonIcon btnTres;
        private org.edisoncor.gui.button.ButtonIcon btnUno;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JSeparator jSeparator1;
        private javax.swing.JLabel lblIndice;
        private javax.swing.JLabel lblPregunta;
        // End of variables declaration//GEN-END:variables
}
