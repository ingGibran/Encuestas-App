package com.mycompany.encuestas_app.vistas.client;

import com.mycompany.encuestas_app.vistas.client.EncuestasUsuarioFrame;
import com.mycompany.encuestas_app.vistas.cuentas.IniciarSesionFrame;
import java.util.List;
import com.mycompany.encuestas_app.services.EncuestaService;
import com.mycompany.encuestas_app.services.RespuestaService;
import com.mycompany.encuestas_app.services.UsuarioService;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Encuesta;
import modelos.Respuesta;

public class MenuUsuarioFrame extends javax.swing.JFrame {
        
        private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuUsuarioFrame.class.getName());
        public String user;
        
        private EncuestaService encuestaService = new EncuestaService();
        private RespuestaService respuestaService = new RespuestaService();
        private UsuarioService usuarioService = new UsuarioService();
        
        public List<Encuesta> encuestas = new ArrayList<>();
        
        public MenuUsuarioFrame(String user) {
                initComponents();
                
                this.user = user;
                
                lblSaludo.setText( "Bienvenido " + user);
                
                setLocationRelativeTo(null);
                
                actualizarEncuestas();
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jLabel1 = new javax.swing.JLabel();
                jPanel1 = new javax.swing.JPanel();
                btnCerrarSesion = new javax.swing.JButton();
                btnMisEncuestas = new javax.swing.JButton();
                lblSaludo = new javax.swing.JLabel();
                panelImage1 = new org.edisoncor.gui.panel.PanelImage();
                jScrollPane1 = new javax.swing.JScrollPane();
                panelEncuestas = new javax.swing.JPanel();
                jLabel2 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 80)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(0, 153, 204));
                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel1.setText("EncuestApp");

                jPanel1.setBackground(new java.awt.Color(204, 204, 204));

                btnCerrarSesion.setBackground(new java.awt.Color(204, 51, 0));
                btnCerrarSesion.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
                btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
                btnCerrarSesion.setText("Cerrar Sesion");
                btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCerrarSesionActionPerformed(evt);
                        }
                });

                btnMisEncuestas.setBackground(new java.awt.Color(0, 102, 255));
                btnMisEncuestas.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
                btnMisEncuestas.setForeground(new java.awt.Color(255, 255, 255));
                btnMisEncuestas.setText("Mis encuestas");
                btnMisEncuestas.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnMisEncuestasActionPerformed(evt);
                        }
                });

                lblSaludo.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
                lblSaludo.setForeground(new java.awt.Color(0, 0, 0));
                lblSaludo.setText("Bienvenido, username");

                panelImage1.setIcon(new javax.swing.ImageIcon("/home/alexpy/NetBeansProjects/Encuestas_App/images/user.png")); // NOI18N

                javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
                panelImage1.setLayout(panelImage1Layout);
                panelImage1Layout.setHorizontalGroup(
                        panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 62, Short.MAX_VALUE)
                );
                panelImage1Layout.setVerticalGroup(
                        panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
                );

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSaludo, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnMisEncuestas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCerrarSesion)
                                .addGap(18, 18, 18))
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblSaludo)
                                        .addComponent(btnMisEncuestas)
                                        .addComponent(btnCerrarSesion))
                                .addGap(14, 14, 14))
                );

                jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

                panelEncuestas.setLayout(new javax.swing.BoxLayout(panelEncuestas, javax.swing.BoxLayout.Y_AXIS));
                jScrollPane1.setViewportView(panelEncuestas);

                jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
                jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel2.setText("Encuestas Disponibles");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1388, Short.MAX_VALUE)
                                .addContainerGap())
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
               new IniciarSesionFrame().setVisible(true);
                this.dispose();
        }//GEN-LAST:event_btnCerrarSesionActionPerformed

        private void btnMisEncuestasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMisEncuestasActionPerformed
                new EncuestasUsuarioFrame(user).setVisible(true);
                this.dispose();
        }//GEN-LAST:event_btnMisEncuestasActionPerformed

        public void actualizarEncuestas() {
    panelEncuestas.removeAll();

                String idUsuario = null;
                try {
                    idUsuario = usuarioService.getIdUsuarioPorNombre(user);
                } catch (Exception ex) {
                    System.getLogger(MenuUsuarioFrame.class.getName())
                          .log(System.Logger.Level.ERROR, (String) null, ex);
                    JOptionPane.showMessageDialog(null, "Error al obtener el usuario");
                    return;
                }

                try {
                    this.encuestas = encuestaService.getAllEncuestas();
                } catch (Exception ex) {
                    System.getLogger(MenuUsuarioFrame.class.getName())
                          .log(System.Logger.Level.ERROR, (String) null, ex);
                    JOptionPane.showMessageDialog(null, "Error al cargar las encuestas");
                    return;
                }

                int indice = 0;

                for (Encuesta e : encuestas) {
                    try {
                        // Obtener respuestas de ESTA encuesta para ESTE usuario
                        List<Respuesta> respuestas = respuestaService
                                .getRespuestasPorEncuestaYUsuario(e.getId_encuesta(), idUsuario);

                        // Mostrar SOLO las encuestas NO contestadas
                        boolean noContestada = (respuestas == null || respuestas.isEmpty());

                        if (noContestada) {
                            if (e.isCompleja()) {
                                MenuUsuarioEncuestaComplejaPanel panel =
                                    new MenuUsuarioEncuestaComplejaPanel(e, indice, this);
                                panelEncuestas.add(panel);
                            } else {
                                MenuUsuarioEncuestaSimplePanel panel =
                                    new MenuUsuarioEncuestaSimplePanel(e, indice, this);
                                panelEncuestas.add(panel);
                            }
                            indice++;
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al cargar las encuestas");
                    }
                }

                panelEncuestas.revalidate();
                panelEncuestas.repaint();
            }
        
        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnCerrarSesion;
        private javax.swing.JButton btnMisEncuestas;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JLabel lblSaludo;
        private javax.swing.JPanel panelEncuestas;
        private org.edisoncor.gui.panel.PanelImage panelImage1;
        // End of variables declaration//GEN-END:variables
}
