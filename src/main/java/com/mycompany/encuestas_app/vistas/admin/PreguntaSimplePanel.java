package com.mycompany.encuestas_app.vistas.admin;

import com.mycompany.encuestas_app.vistas.admin.AgregarEncuestaSimpleFrame;


public class PreguntaSimplePanel extends javax.swing.JPanel {
        
        private int indice;
        private String pregunta;
        private AgregarEncuestaSimpleFrame frame;
        
        public PreguntaSimplePanel(int indice, String pregunta, AgregarEncuestaSimpleFrame frame) {
                initComponents();
                this.indice = indice;
                this.pregunta = pregunta;
                this.frame = frame;
                
                lblPregunta.setText(pregunta);
                lblIndice.setText("" + (indice+1) );
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                lblPregunta = new javax.swing.JLabel();
                btnEliminarPregunta = new javax.swing.JButton();
                lblIndice = new javax.swing.JLabel();

                lblPregunta.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
                lblPregunta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                lblPregunta.setText("¿?");

                btnEliminarPregunta.setBackground(new java.awt.Color(255, 51, 0));
                btnEliminarPregunta.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                btnEliminarPregunta.setForeground(new java.awt.Color(255, 255, 255));
                btnEliminarPregunta.setText("Eliminar pregunta");
                btnEliminarPregunta.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnEliminarPreguntaActionPerformed(evt);
                        }
                });

                lblIndice.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
                lblIndice.setText("n.-");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblIndice, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                                .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarPregunta)
                                .addGap(40, 40, 40))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPregunta)
                                        .addComponent(btnEliminarPregunta)
                                        .addComponent(lblIndice, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(22, Short.MAX_VALUE))
                );
        }// </editor-fold>//GEN-END:initComponents

        private void btnEliminarPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPreguntaActionPerformed
                frame.preguntas.remove(indice);
                frame.actualizarScrollPreguntas();
        }//GEN-LAST:event_btnEliminarPreguntaActionPerformed


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnEliminarPregunta;
        private javax.swing.JLabel lblIndice;
        private javax.swing.JLabel lblPregunta;
        // End of variables declaration//GEN-END:variables
}
