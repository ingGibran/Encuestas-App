package com.mycompany.encuestas_app.vistas.respuestas;

import modelos.Encuesta;

public class ResultadoPanel extends javax.swing.JPanel {
        
        private String usuario;
        private int prom;
        private Encuesta encuesta;
        
        
        public ResultadoPanel(String usuario, Encuesta encuesta) {
                initComponents();
                
                this.usuario = usuario;
                this.encuesta = encuesta;
                
                lblUsername.setText("Usuario: " + usuario);
                
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                lblUsername = new javax.swing.JLabel();

                lblUsername.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
                lblUsername.setText("Username");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(811, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblUsername)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
        }// </editor-fold>//GEN-END:initComponents
        
        

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel lblUsername;
        // End of variables declaration//GEN-END:variables
}
