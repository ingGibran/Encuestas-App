package com.mycompany.encuestas_app.vistas.client;

import com.mycompany.encuestas_app.services.PreguntaService;
import com.mycompany.encuestas_app.services.RespuestaService;
import com.mycompany.encuestas_app.services.UsuarioService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.Encuesta;
import modelos.Pregunta;
import modelos.Respuesta;

public class ContestarEncuestaComplejaFrame extends javax.swing.JFrame {
        
        private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ContestarEncuestaComplejaFrame.class.getName());
        public Encuesta encuesta;
        public String usuario;
        public ArrayList<Integer> valores_respuestas = new ArrayList<>();
        
        private PreguntaService preguntaService = new PreguntaService();
        private UsuarioService usuarioService = new UsuarioService();
        private RespuestaService respuestaService = new RespuestaService();
        
        public ContestarEncuestaComplejaFrame(Encuesta encuesta, String usuario) {
                this.encuesta = encuesta;
                this.usuario = usuario;
                
                System.out.println(encuesta.getId_encuesta() + " . " + usuario);
                
                initComponents();
                
                setLocationRelativeTo(null);
                
                actualizarEncuesta();
                
                lblNombre.setText( encuesta.getNombre() );
                
                System.out.println(encuesta.getId_encuesta() + " - - - " + usuario);
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
                new ContestarEncuestaComplejaFrame( encuesta, usuario ).setVisible(true);
                this.dispose();
        }//GEN-LAST:event_btnReiniciarActionPerformed

        private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
                
                boolean valido = true;
                for (int r : valores_respuestas) {
                        if (r == 0) {
                                JOptionPane.showMessageDialog(null, "Conteste todas las preguntas");
                                return;
                        }
                }
                
                try {
                        int indice = 0;
                        for ( Pregunta pregunta : preguntaService.getPreguntasPorEncuesta(encuesta.getId_encuesta()) ) {
                                Respuesta respuesta = new Respuesta(pregunta.getId_pregunta(), usuarioService.getIdUsuarioPorNombre(usuario), valores_respuestas.get(indice), indice );
                                respuestaService.agregarRespuesta(respuesta);
                                indice++;
                        }
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al guardar respuestas");
                        return;
                }
                
                JOptionPane.showMessageDialog(null, "Encuesta contestada correctamente");
                new MenuUsuarioFrame(usuario).setVisible(true);
                this.dispose();

        }//GEN-LAST:event_btnFinalizarActionPerformed

        public void actualizarEncuesta() {
                System.out.println("=== ACTUALIZANDO ENCUESTA ===");

                preguntasPanel.removeAll();
                valores_respuestas.clear();   // importante: limpiar también esto si lo usas como estado

                if (encuesta == null) {
                    System.out.println("Encuesta es null");
                    JOptionPane.showMessageDialog(null, "No hay encuesta seleccionada");
                    return;
                }

                System.out.println("Encuesta id = " + encuesta.getId_encuesta());

                int indice = 0;

                try {
                    List<Pregunta> preguntas = preguntaService.getPreguntasPorEncuesta(encuesta.getId_encuesta());
                    System.out.println("Preguntas encontradas: " + (preguntas != null ? preguntas.size() : 0));

                    for (Pregunta pregunta : preguntas) {
                        System.out.println("  -> Pregunta: " + pregunta.getId_pregunta() + " / " + pregunta.getTexto());

                        ContestarEncuestaComplejaPanel panel = new ContestarEncuestaComplejaPanel(
                                indice,
                                pregunta.getTexto(),
                                this
                        );

                        preguntasPanel.add(panel);
                        valores_respuestas.add(0);
                        indice++;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al agregar las preguntas");
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
