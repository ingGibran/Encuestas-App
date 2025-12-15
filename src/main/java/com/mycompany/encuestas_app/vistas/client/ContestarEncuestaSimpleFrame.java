package com.mycompany.encuestas_app.vistas.client;

import com.mycompany.encuestas_app.services.PreguntaService;
import com.mycompany.encuestas_app.services.RespuestaService;
import com.mycompany.encuestas_app.services.UsuarioService;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import modelos.Encuesta;
import modelos.Pregunta;
import modelos.Respuesta;
import modelos.Usuario;

public class ContestarEncuestaSimpleFrame extends javax.swing.JFrame {
        
        private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ContestarEncuestaSimpleFrame.class.getName());
        public Encuesta encuesta;
        public String usuario;
        public ArrayList<Integer> valores_respuestas = new ArrayList<>();
        
        private PreguntaService preguntaService = new PreguntaService();
        private UsuarioService usuarioService = new UsuarioService();
        private RespuestaService respuestaService = new RespuestaService();
        
        public ContestarEncuestaSimpleFrame(Encuesta encuesta, String usuario) {
                initComponents();
                
                this.encuesta = encuesta;
                this.usuario = usuario;
                
                lblNombre.setText( encuesta.getNombre() );
                actualizarEncuesta();
                setLocationRelativeTo(null);
                
        }
        
        

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jLabel1 = new javax.swing.JLabel();
                jPanel1 = new javax.swing.JPanel();
                btnFinalizar = new javax.swing.JButton();
                btnCancelar = new javax.swing.JButton();
                btnReiniciar = new javax.swing.JButton();
                lblNombre = new javax.swing.JLabel();
                jScrollPane2 = new javax.swing.JScrollPane();
                preguntasPanel = new javax.swing.JPanel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 80)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(0, 153, 204));
                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel1.setText("EncuestApp");

                jPanel1.setBackground(new java.awt.Color(204, 204, 204));

                btnFinalizar.setBackground(new java.awt.Color(0, 153, 0));
                btnFinalizar.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
                btnFinalizar.setForeground(new java.awt.Color(255, 255, 255));
                btnFinalizar.setText("Finalizar");
                btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnFinalizarActionPerformed(evt);
                        }
                });

                btnCancelar.setBackground(new java.awt.Color(204, 51, 0));
                btnCancelar.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
                btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
                btnCancelar.setText("Cancelar");
                btnCancelar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCancelarActionPerformed(evt);
                        }
                });

                btnReiniciar.setBackground(new java.awt.Color(255, 204, 0));
                btnReiniciar.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
                btnReiniciar.setForeground(new java.awt.Color(255, 255, 255));
                btnReiniciar.setText("Reiniciar");
                btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnReiniciarActionPerformed(evt);
                        }
                });

                lblNombre.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
                lblNombre.setForeground(new java.awt.Color(0, 0, 0));
                lblNombre.setText("Encuesta: Nombre encuesta");

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 466, Short.MAX_VALUE)
                                .addComponent(btnFinalizar)
                                .addGap(18, 18, 18)
                                .addComponent(btnReiniciar)
                                .addGap(25, 25, 25)
                                .addComponent(btnCancelar)
                                .addGap(53, 53, 53))
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnFinalizar)
                                        .addComponent(btnCancelar)
                                        .addComponent(btnReiniciar)
                                        .addComponent(lblNombre))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

                preguntasPanel.setLayout(new javax.swing.BoxLayout(preguntasPanel, javax.swing.BoxLayout.Y_AXIS));
                jScrollPane2.setViewportView(preguntasPanel);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
                new MenuUsuarioFrame( usuario ).setVisible(true);
                this.dispose();
        }//GEN-LAST:event_btnCancelarActionPerformed

        private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
                new ContestarEncuestaSimpleFrame( encuesta, usuario ).setVisible(true);
                this.dispose();
        }//GEN-LAST:event_btnReiniciarActionPerformed

        private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
                
                boolean valido = true;
                for (int r : valores_respuestas) {
                        if (r == 0) {
                                valido = false;
                        }
                }
                
                if (valido) {
                        try {
                                int i = 0;
                                for ( Pregunta pregunta : preguntaService.getPreguntasPorEncuesta( encuesta.getId_encuesta() ) ) {
                                        Respuesta r = new Respuesta();
                                        r.setId_pregunta( pregunta.getId_pregunta() );
                                        r.setId_usuario( usuarioService.getIdUsuarioPorNombre(usuario));
                                        r.setValor( valores_respuestas.get(i) );
                                        r.setOrden(i);
                                        respuestaService.agregarRespuesta(r);
                                        i++;
                                }
                                JOptionPane.showMessageDialog(null, "Encuesta contestada correctamente");
                                new MenuUsuarioFrame(usuario).setVisible(true);
                                this.dispose();
                        } catch (Exception ex) {
                                System.getLogger(ContestarEncuestaSimpleFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                                JOptionPane.showMessageDialog(null, "Error al guardar las respuestas");
                        }
                } else {
                        JOptionPane.showMessageDialog(null, "Conteste todas las preguntas");
                }
        }//GEN-LAST:event_btnFinalizarActionPerformed

        public void actualizarEncuesta() {
                preguntasPanel.removeAll();
                valores_respuestas.clear();
                
                int indices = 0;
                try {
                        for ( Pregunta pregunta : preguntaService.getPreguntasPorEncuesta( encuesta.getId_encuesta() ) ) {
                                ContestarEncuestaSimplePanel panel = new ContestarEncuestaSimplePanel(indices, pregunta.getTexto(), this);
                                preguntasPanel.add( panel );
                                valores_respuestas.add(0);
                                indices++;
                        }
                } catch (Exception ex) {
                        System.getLogger(ContestarEncuestaSimpleFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                        JOptionPane.showMessageDialog(null, "Error al encontrar la pregunta");
                }
                
                preguntasPanel.revalidate(); 
                preguntasPanel.repaint(); 
        }
        
        
        
        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnCancelar;
        private javax.swing.JButton btnFinalizar;
        private javax.swing.JButton btnReiniciar;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JLabel lblNombre;
        private javax.swing.JPanel preguntasPanel;
        // End of variables declaration//GEN-END:variables
}
