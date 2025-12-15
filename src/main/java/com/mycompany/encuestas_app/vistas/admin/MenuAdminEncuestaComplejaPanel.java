package com.mycompany.encuestas_app.vistas.admin;

import com.mycompany.encuestas_app.services.EncuestaService;
import com.mycompany.encuestas_app.vistas.admin.AgregarEncuestaComplejaFrame;
import com.mycompany.encuestas_app.vistas.admin.MenuAdminFrame;
import javax.swing.JOptionPane;
import com.mycompany.encuestas_app.vistas.respuestas.ResultadosComplejaFrame;
import modelos.Encuesta;

public class MenuAdminEncuestaComplejaPanel extends javax.swing.JPanel {

        private Encuesta encuesta;
        private int indice;
        private MenuAdminFrame frame;
        
        private EncuestaService encuestaService = new EncuestaService();
        
        public MenuAdminEncuestaComplejaPanel(Encuesta encuesta, int indice, MenuAdminFrame frame) {
                initComponents();
                
                this.encuesta = encuesta;
                this.indice = indice;
                this.frame = frame;
                
                lblNombre.setText("" + encuesta.getNombre() );
                
        }
        
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                btnEliminarPregunta = new javax.swing.JButton();
                lblNombre = new javax.swing.JLabel();
                btnEditarEncuesta = new javax.swing.JButton();
                btnResultados = new javax.swing.JButton();

                btnEliminarPregunta.setBackground(new java.awt.Color(255, 51, 0));
                btnEliminarPregunta.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                btnEliminarPregunta.setForeground(new java.awt.Color(255, 255, 255));
                btnEliminarPregunta.setText("Eliminar encuesta");
                btnEliminarPregunta.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnEliminarPreguntaActionPerformed(evt);
                        }
                });

                lblNombre.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
                lblNombre.setText("Nombre");

                btnEditarEncuesta.setBackground(new java.awt.Color(0, 102, 255));
                btnEditarEncuesta.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                btnEditarEncuesta.setForeground(new java.awt.Color(255, 255, 255));
                btnEditarEncuesta.setText("Editar encuesta");
                btnEditarEncuesta.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnEditarEncuestaActionPerformed(evt);
                        }
                });

                btnResultados.setBackground(new java.awt.Color(0, 204, 51));
                btnResultados.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                btnResultados.setForeground(new java.awt.Color(255, 255, 255));
                btnResultados.setText("Ver resultados");
                btnResultados.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnResultadosActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                                .addComponent(btnResultados)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditarEncuesta)
                                .addGap(31, 31, 31)
                                .addComponent(btnEliminarPregunta)
                                .addGap(26, 26, 26))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(19, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNombre)
                                        .addComponent(btnEliminarPregunta)
                                        .addComponent(btnEditarEncuesta)
                                        .addComponent(btnResultados))
                                .addGap(23, 23, 23))
                );
        }// </editor-fold>//GEN-END:initComponents

        private void btnEliminarPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPreguntaActionPerformed
                int confirm = JOptionPane.showConfirmDialog(frame, "¿Deseas eliminar la encuesta?", "Confirmar",JOptionPane.YES_NO_OPTION);
                
                if (confirm == JOptionPane.YES_OPTION) {
                        try {
                                //EncuestaComplejaService.eliminarEncuesta(encuesta.getNombre());
                                encuestaService.deleteEncuesta(encuesta.getId_encuesta());
                                JOptionPane.showMessageDialog(null, "Encuesta eliminada correctamente");
                                frame.actualizarEncuestas();
                        } catch (Exception ex) {
                                System.getLogger(MenuAdminEncuestaComplejaPanel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                                JOptionPane.showMessageDialog(null, "Error al eliminar la encuesta");
                        }
                }
                
        }//GEN-LAST:event_btnEliminarPreguntaActionPerformed

        private void btnEditarEncuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarEncuestaActionPerformed
                new AgregarEncuestaComplejaFrame( encuesta ).setVisible(true);
                frame.dispose();
        }//GEN-LAST:event_btnEditarEncuestaActionPerformed

        private void btnResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResultadosActionPerformed
                new ResultadosComplejaFrame(encuesta).setVisible(true);
                frame.dispose();
        }//GEN-LAST:event_btnResultadosActionPerformed


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnEditarEncuesta;
        private javax.swing.JButton btnEliminarPregunta;
        private javax.swing.JButton btnResultados;
        private javax.swing.JLabel lblNombre;
        // End of variables declaration//GEN-END:variables
}
