package com.mycompany.encuestas_app.vistas.client;

import com.mycompany.encuestas_app.vistas.client.MenuUsuarioFrame;
import com.mycompany.encuestas_app.vistas.client.ContestarEncuestaComplejaFrame;
import modelos.Encuesta;

public class MenuUsuarioEncuestaComplejaPanel extends javax.swing.JPanel {

        private Encuesta encuesta;
        private MenuUsuarioFrame frame;
        
        public MenuUsuarioEncuestaComplejaPanel(Encuesta encuesta, int indice, MenuUsuarioFrame frame) {
                initComponents();
                
                this.encuesta = encuesta;
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
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 396, Short.MAX_VALUE)
                                .addComponent(btnContestar)
                                .addGap(171, 171, 171))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNombre)
                                        .addComponent(btnContestar))
                                .addGap(24, 24, 24))
                );
        }// </editor-fold>//GEN-END:initComponents

        private void btnContestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContestarActionPerformed
                new ContestarEncuestaComplejaFrame(encuesta,  frame.user ).setVisible(true);
                frame.dispose();
        }//GEN-LAST:event_btnContestarActionPerformed


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnContestar;
        private javax.swing.JLabel lblNombre;
        // End of variables declaration//GEN-END:variables
}
