package com.mycompany.encuestas_app.vistas.client;

import com.mycompany.encuestas_app.services.EncuestaService;
import com.mycompany.encuestas_app.services.RespuestaService;
import com.mycompany.encuestas_app.services.UsuarioService;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.Encuesta;
import modelos.Respuesta;

public class EncuestasUsuarioFrame extends javax.swing.JFrame {
        
        private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(EncuestasUsuarioFrame.class.getName());
        
        private RespuestaService respuestaService = new RespuestaService();
        private EncuestaService encuestaService = new EncuestaService();
        private UsuarioService usuarioService = new UsuarioService();
        
        public String usuario;
        
        public EncuestasUsuarioFrame(String usuario) {
                initComponents();
                
                this.usuario = usuario;
                
                setLocationRelativeTo(null);
                
                actualizar();
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jLabel1 = new javax.swing.JLabel();
                jPanel1 = new javax.swing.JPanel();
                btnRegresar = new javax.swing.JButton();
                jLabel2 = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                encuestasPanel = new javax.swing.JPanel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 80)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(0, 153, 204));
                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel1.setText("EncuestApp");

                jPanel1.setBackground(new java.awt.Color(204, 204, 204));

                btnRegresar.setBackground(new java.awt.Color(255, 51, 0));
                btnRegresar.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
                btnRegresar.setText("Regresar");
                btnRegresar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnRegresarActionPerformed(evt);
                        }
                });

                jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
                jLabel2.setForeground(new java.awt.Color(0, 0, 0));
                jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel2.setText("Encuestas Contestadas");

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegresar)
                                .addGap(17, 17, 17))
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnRegresar)
                                        .addComponent(jLabel2))
                                .addContainerGap(12, Short.MAX_VALUE))
                );

                jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

                encuestasPanel.setLayout(new javax.swing.BoxLayout(encuestasPanel, javax.swing.BoxLayout.Y_AXIS));
                jScrollPane1.setViewportView(encuestasPanel);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1400, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
                new MenuUsuarioFrame(usuario).setVisible(true);
                this.dispose();
        }//GEN-LAST:event_btnRegresarActionPerformed
        
        public void actualizar() {
                encuestasPanel.removeAll();

                try {
                    // Obtener id del usuario solo una vez
                    String idUsuario = usuarioService.getIdUsuarioPorNombre(usuario);

                    // Obtener todas las encuestas
                    List<Encuesta> encuestas = encuestaService.getAllEncuestas();

                    for (Encuesta e : encuestas) {

                        // Respuestas de esta encuesta para este usuario
                        List<Respuesta> respuestas = respuestaService
                                .getRespuestasPorEncuestaYUsuario(e.getId_encuesta(), idUsuario);

                        // Solo mostrar las encuestas que SÍ fueron respondidas
                        boolean yaRespondio = (respuestas != null && !respuestas.isEmpty());

                        if (yaRespondio) {
                            if (e.isCompleja()) {
                                EncuestaUsuarioPanelCompleja panel =
                                    new EncuestaUsuarioPanelCompleja(usuario, e, this);
                                encuestasPanel.add(panel);
                            } else {
                                EncuestaUsuarioPanelSimple panel =
                                    new EncuestaUsuarioPanelSimple(usuario, e, this);
                                encuestasPanel.add(panel);
                            }
                        }
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al cargar las encuestas");
                }

                encuestasPanel.revalidate();
                encuestasPanel.repaint();
            }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnRegresar;
        private javax.swing.JPanel encuestasPanel;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        // End of variables declaration//GEN-END:variables
}
