package com.mycompany.encuestas_app.vistas.admin;

import com.mycompany.encuestas_app.vistas.admin.AgregarEncuestaComplejaFrame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Pregunta;



public class PreguntaComplejaPanel extends javax.swing.JPanel {
        
        private int indice;
        private Pregunta pregunta;
        private AgregarEncuestaComplejaFrame frame = new AgregarEncuestaComplejaFrame();
        
        public PreguntaComplejaPanel(int indice, Pregunta pregunta, AgregarEncuestaComplejaFrame frame) {
                initComponents();
                this.indice = indice;
                this.pregunta = pregunta;
                this.frame = frame;
                
                lblPregunta.setText( pregunta.getTexto() );
                lblIndice.setText("" + (indice+1) );
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                lblPregunta = new javax.swing.JLabel();
                btnEliminarPregunta = new javax.swing.JButton();
                lblIndice = new javax.swing.JLabel();
                btnAgregarSubpregunta = new javax.swing.JButton();
                jLabel2 = new javax.swing.JLabel();
                preguntaSecundaria = new javax.swing.JTextField();

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

                btnAgregarSubpregunta.setBackground(new java.awt.Color(0, 102, 255));
                btnAgregarSubpregunta.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                btnAgregarSubpregunta.setForeground(new java.awt.Color(255, 255, 255));
                btnAgregarSubpregunta.setText("Agregar");
                btnAgregarSubpregunta.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnAgregarSubpreguntaActionPerformed(evt);
                        }
                });

                jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                jLabel2.setForeground(new java.awt.Color(0, 0, 0));
                jLabel2.setText("Pregunta Secundaria");

                preguntaSecundaria.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblIndice, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnEliminarPregunta))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(preguntaSecundaria, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnAgregarSubpregunta))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel2)))
                                .addContainerGap(447, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblIndice, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblPregunta)
                                        .addComponent(btnEliminarPregunta))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(preguntaSecundaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAgregarSubpregunta))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
        }// </editor-fold>//GEN-END:initComponents

        private void btnEliminarPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPreguntaActionPerformed
                frame.preguntas.remove(indice);
                frame.actualizarScrollPreguntas();
        }//GEN-LAST:event_btnEliminarPreguntaActionPerformed

        private void btnAgregarSubpreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarSubpreguntaActionPerformed
                // Validar pregunta
                if (preguntaSecundaria.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(null, "Ingresa una pregunta correcta");
                        return;
                }

                frame.preguntas.add( new Pregunta( preguntaSecundaria.getText().trim(), frame.encuesta.getId_encuesta(), false, indice ) );
  
                
                preguntaSecundaria.setText("");
                frame.actualizarScrollPreguntas();
                
        }//GEN-LAST:event_btnAgregarSubpreguntaActionPerformed


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnAgregarSubpregunta;
        private javax.swing.JButton btnEliminarPregunta;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel lblIndice;
        private javax.swing.JLabel lblPregunta;
        private javax.swing.JTextField preguntaSecundaria;
        // End of variables declaration//GEN-END:variables
}
