package com.mycompany.encuestas_app.vistas.client;

import com.mycompany.encuestas_app.services.RespuestaService;
import com.mycompany.encuestas_app.services.UsuarioService;
import com.mycompany.encuestas_app.vistas.respuestas.ResultadosEncuestaComplejaFrame;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.Encuesta;
import modelos.Respuesta;

public class EncuestaUsuarioPanelCompleja extends javax.swing.JPanel {
        
        public Encuesta encuesta;
        public List<Respuesta> respuestas;
        public String usuario;
        public EncuestasUsuarioFrame frame;
        
        private RespuestaService respuestaService = new RespuestaService();
        private UsuarioService usuarioService = new UsuarioService();
        
        public EncuestaUsuarioPanelCompleja(String usuario, Encuesta encuesta, EncuestasUsuarioFrame frame) {
                initComponents();
                
                this.usuario = usuario;
                this.encuesta = encuesta;
                this.frame = frame;
                try {
                        this.respuestas = respuestaService.getRespuestasPorEncuestaYUsuario( encuesta.getId_encuesta(), usuarioService.getIdUsuarioPorNombre(usuario) );
                } catch (Exception ex) {
                        System.getLogger(EncuestaUsuarioPanelCompleja.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                        JOptionPane.showMessageDialog(null, "Error al cargar las preguntas");
                }
                
                System.out.println("listo");
                
                lblEncuesta.setText("Encuesta: " + encuesta.getNombre());
        }
        

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                lblEncuesta = new javax.swing.JLabel();
                btnRespuestas = new javax.swing.JButton();
                jSeparator1 = new javax.swing.JSeparator();

                lblEncuesta.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
                lblEncuesta.setForeground(new java.awt.Color(0, 0, 0));
                lblEncuesta.setText("Nombre encuesta");

                btnRespuestas.setBackground(new java.awt.Color(0, 102, 255));
                btnRespuestas.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                btnRespuestas.setForeground(new java.awt.Color(255, 255, 255));
                btnRespuestas.setText("Ver respuestas");
                btnRespuestas.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnRespuestasActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblEncuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 490, Short.MAX_VALUE)
                                .addComponent(btnRespuestas)
                                .addGap(107, 107, 107))
                        .addComponent(jSeparator1)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblEncuesta)
                                        .addComponent(btnRespuestas))
                                .addContainerGap(32, Short.MAX_VALUE))
                );
        }// </editor-fold>//GEN-END:initComponents

        private void btnRespuestasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRespuestasActionPerformed
                new ResultadosEncuestaComplejaFrame(encuesta, usuario).setVisible(true);
                frame.dispose();
        }//GEN-LAST:event_btnRespuestasActionPerformed


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnRespuestas;
        private javax.swing.JSeparator jSeparator1;
        private javax.swing.JLabel lblEncuesta;
        // End of variables declaration//GEN-END:variables
}
