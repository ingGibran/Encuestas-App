package com.mycompany.encuestas_app.vistas.respuestas;

import com.mycompany.encuestas_app.services.EncuestaService;
import com.mycompany.encuestas_app.services.PreguntaService;
import com.mycompany.encuestas_app.services.RespuestaService;
import com.mycompany.encuestas_app.services.UsuarioService;
import com.mycompany.encuestas_app.vistas.client.MenuUsuarioFrame;
import javax.swing.JOptionPane;
import modelos.Encuesta;
import modelos.Respuesta;

public class ResultadosEncuestaSimpleAdminFrame extends javax.swing.JFrame {

        private static final java.util.logging.Logger logger = java.util.logging.Logger
                        .getLogger(ResultadosEncuestaSimpleAdminFrame.class.getName());
        public Encuesta encuesta;
        public String usuario;

        private RespuestaService respuestaService = new RespuestaService();
        private PreguntaService preguntaService = new PreguntaService();
        private EncuestaService encuestaService = new EncuestaService();
        private UsuarioService usuarioService = new UsuarioService();

        public ResultadosEncuestaSimpleAdminFrame(Encuesta encuesta, String usuario) {
                initComponents();

                this.encuesta = encuesta;
                this.usuario = usuario;

                lblNombre.setText(encuesta.getNombre());

                actualizarEncuesta();

                setLocationRelativeTo(null);

        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jLabel1 = new javax.swing.JLabel();
                jPanel1 = new javax.swing.JPanel();
                btnCancelar = new javax.swing.JButton();
                lblNombre = new javax.swing.JLabel();
                jScrollPane2 = new javax.swing.JScrollPane();
                preguntasPanel = new javax.swing.JPanel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 80)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(0, 153, 204));
                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel1.setText("EncuestApp");

                jPanel1.setBackground(new java.awt.Color(204, 204, 204));

                btnCancelar.setBackground(new java.awt.Color(204, 51, 0));
                btnCancelar.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
                btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
                btnCancelar.setText("Regresar");
                btnCancelar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCancelarActionPerformed(evt);
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
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                758, Short.MAX_VALUE)
                                                                .addComponent(btnCancelar)
                                                                .addGap(53, 53, 53)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(btnCancelar)
                                                                                .addComponent(lblNombre))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

                preguntasPanel.setLayout(new javax.swing.BoxLayout(preguntasPanel, javax.swing.BoxLayout.Y_AXIS));
                jScrollPane2.setViewportView(preguntasPanel);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane2));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane2,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                657, Short.MAX_VALUE)));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelarActionPerformed
                new MenuUsuarioFrame(usuario).setVisible(true);
                this.dispose();
        }// GEN-LAST:event_btnCancelarActionPerformed

        public void actualizarEncuesta() {
                System.out.println("Cargando respuestas para encuesta: " + encuesta.getId_encuesta());

                preguntasPanel.removeAll();
                int indices = 0;

                try {
                        // Obtener todas las preguntas de la encuesta
                        for (modelos.Pregunta pregunta : preguntaService
                                        .getPreguntasPorEncuesta(encuesta.getId_encuesta())) {
                                // Para cada pregunta, obtener todas las respuestas
                                java.util.List<Respuesta> respuestas = respuestaService
                                                .getRespuestasPorPregunta(pregunta.getId_pregunta());

                                // Mostrar cada respuesta
                                for (Respuesta respuesta : respuestas) {
                                        System.out.println("Pregunta: " + pregunta.getTexto() + " - Valor: "
                                                        + respuesta.getValor());
                                        RespuestasEncuestaSimpleAdminPanel panel = new RespuestasEncuestaSimpleAdminPanel(
                                                        indices, respuesta, this);
                                        preguntasPanel.add(panel);
                                        indices++;
                                }
                        }

                        if (indices == 0) {
                                javax.swing.JLabel noDataLabel = new javax.swing.JLabel(
                                                "No hay respuestas registradas para esta encuesta.");
                                noDataLabel.setFont(new java.awt.Font("Liberation Sans", java.awt.Font.PLAIN, 24));
                                noDataLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                                preguntasPanel.add(noDataLabel);
                        }

                } catch (Exception e) {
                        e.printStackTrace();
                        javax.swing.JOptionPane.showMessageDialog(null, "Error al leer las respuestas de la encuesta");
                }

                preguntasPanel.revalidate();
                preguntasPanel.repaint();
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnCancelar;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JLabel lblNombre;
        private javax.swing.JPanel preguntasPanel;
        // End of variables declaration//GEN-END:variables
}
