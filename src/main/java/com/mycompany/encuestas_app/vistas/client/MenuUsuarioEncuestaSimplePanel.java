package com.mycompany.encuestas_app.vistas.client;

import com.mycompany.encuestas_app.vistas.client.MenuUsuarioFrame;
import com.mycompany.encuestas_app.vistas.client.ContestarEncuestaSimpleFrame;
import modelos.Encuesta;

public class MenuUsuarioEncuestaSimplePanel extends javax.swing.JPanel {

        private Encuesta encuesta;
        private int indice;
        private MenuUsuarioFrame frame;
        
        public MenuUsuarioEncuestaSimplePanel(Encuesta encuesta, int indice, MenuUsuarioFrame frame) {
                initComponents();
                
                this.encuesta = encuesta;
                this.indice = indice;
                this.frame = frame;
                
                lblNombre.setText("" + encuesta.getNombre() );
                
        }
        
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                lblNombre = new javax.swing.JLabel();
                btnContestar = new javax.swing.JButton();

                lblNombre.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
                lblNombre.setText("Nombre");

                btnContestar.setBackground(new java.awt.Color(0, 102, 255));
                btnContestar.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                btnContestar.setForeground(new java.awt.Color(255, 255, 255));
                btnContestar.setText("Contestar");
                btnContestar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnContestarActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                .addComponent(btnContestar)
                                .addGap(171, 171, 171))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNombre)
                                        .addComponent(btnContestar))
                                .addContainerGap(24, Short.MAX_VALUE))
                );
        }// </editor-fold>//GEN-END:initComponents

        private void btnContestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContestarActionPerformed
                
                if (encuesta.isCompleja()) {
                        new ContestarEncuestaComplejaFrame(encuesta, frame.user).setVisible(true);
                        System.out.println("compleja");
                } else {
                        new ContestarEncuestaSimpleFrame(encuesta, frame.user).setVisible(true);
                        System.out.println("no compleja");
                }
                
                frame.dispose();
                
        }//GEN-LAST:event_btnContestarActionPerformed


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnContestar;
        private javax.swing.JLabel lblNombre;
        // End of variables declaration//GEN-END:variables
}
