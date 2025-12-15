package com.mycompany.encuestas_app.vistas.admin;

import com.mycompany.encuestas_app.vistas.admin.AgregarEncuestaComplejaFrame;
import modelos.Pregunta;

public class PreguntaSecundariaPanel extends javax.swing.JPanel {
        
        private int indicePanel;
        private int indice;
        private Pregunta pregunta;
        private AgregarEncuestaComplejaFrame frame;
        
        public PreguntaSecundariaPanel(int indicePanel, int indice, Pregunta pregunta, AgregarEncuestaComplejaFrame frame) {
                initComponents();
                
                this.indicePanel = indicePanel;
                this.indice = indice;
                this.pregunta = pregunta;
                this.frame = frame;
                
                lblIndice.setText( (indice+1) + "");
                lblPregunta.setText(pregunta.getTexto());
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
                btnEliminarPregunta.setText("Eliminar");
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
                                .addGap(272, 272, 272)
                                .addComponent(lblIndice, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminarPregunta)
                                .addGap(14, 14, 14))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPregunta)
                                        .addComponent(btnEliminarPregunta)
                                        .addComponent(lblIndice, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
        }// </editor-fold>//GEN-END:initComponents

        private void btnEliminarPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPreguntaActionPerformed
                
                frame.preguntas.remove(indice);
                //frame.preguntas.get( indicePanel ).secundarias.remove( indice );
                frame.actualizarScrollPreguntas();
        }//GEN-LAST:event_btnEliminarPreguntaActionPerformed


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnEliminarPregunta;
        private javax.swing.JLabel lblIndice;
        private javax.swing.JLabel lblPregunta;
        // End of variables declaration//GEN-END:variables
}
