package com.mycompany.encuestas_app.vistas.respuestas;

import com.mycompany.encuestas_app.services.PreguntaService;
import com.mycompany.encuestas_app.services.RespuestaService;
import com.mycompany.encuestas_app.services.UsuarioService;
import com.mycompany.encuestas_app.vistas.respuestas.ResultadoPanel;
import com.mycompany.encuestas_app.vistas.admin.MenuAdminFrame;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.Encuesta;
import modelos.Pregunta;
import modelos.Respuesta;
import modelos.Usuario;

public class ResultadosSimpleFrame extends javax.swing.JFrame {

        private static final java.util.logging.Logger logger = java.util.logging.Logger
                        .getLogger(ResultadosSimpleFrame.class.getName());
        public Encuesta encuesta;

        private PreguntaService preguntaService = new PreguntaService();
        private RespuestaService respuestaService = new RespuestaService();
        private UsuarioService usuarioService = new UsuarioService();

        public ResultadosSimpleFrame(Encuesta encuesta) {
                initComponents();
                this.encuesta = encuesta;

                setLocationRelativeTo(null);

                lblEncuesta.setText("Encuesta: " + encuesta.getNombre());
                actualizar();
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jLabel1 = new javax.swing.JLabel();
                jPanel1 = new javax.swing.JPanel();
                btnRegresar = new javax.swing.JButton();
                lblEncuesta = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                encuestasPanel = new javax.swing.JPanel();
                jLabel2 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 80)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(0, 153, 204));
                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel1.setText("EncuestApp");

                jPanel1.setBackground(new java.awt.Color(204, 204, 204));

                btnRegresar.setBackground(new java.awt.Color(204, 51, 0));
                btnRegresar.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
                btnRegresar.setText("Regresar");
                btnRegresar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnRegresarActionPerformed(evt);
                        }
                });

                lblEncuesta.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
                lblEncuesta.setForeground(new java.awt.Color(0, 0, 0));
                lblEncuesta.setText("Encuesta");

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                                .createSequentialGroup()
                                                                .addGap(22, 22, 22)
                                                                .addComponent(lblEncuesta)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(btnRegresar)
                                                                .addGap(17, 17, 17)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(btnRegresar)
                                                                                .addComponent(lblEncuesta))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                encuestasPanel.setLayout(new javax.swing.BoxLayout(encuestasPanel, javax.swing.BoxLayout.Y_AXIS));
                jScrollPane1.setViewportView(encuestasPanel);

                jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
                jLabel2.setForeground(new java.awt.Color(0, 0, 0));
                jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel2.setText("Resultados");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1400,
                                                                Short.MAX_VALUE)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane1)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel2,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addContainerGap()));
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
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                627, Short.MAX_VALUE)));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRegresarActionPerformed
                new MenuAdminFrame().setVisible(true);
                this.dispose();
        }// GEN-LAST:event_btnRegresarActionPerformed

        public void actualizar() {
                encuestasPanel.removeAll();

                try {

                        List<Pregunta> preguntasEncuesta = preguntaService
                                        .getPreguntasPorEncuesta(encuesta.getId_encuesta());

                        if (preguntasEncuesta == null || preguntasEncuesta.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "La encuesta no tiene preguntas");
                                return;
                        }

                        String idPrimeraPregunta = preguntasEncuesta.get(0).getId_pregunta();

                        // Obtener todas las respuestas para la primera pregunta
                        List<Respuesta> respuestas = respuestaService.getRespuestasPorPregunta(idPrimeraPregunta);

                        // Usar un HashSet para evitar usuarios duplicados
                        java.util.Set<String> usuariosMostrados = new java.util.HashSet<>();

                        for (Respuesta respuesta : respuestas) {
                                String idUsuario = respuesta.getId_usuario();

                                // Solo agregar si no se ha mostrado este usuario
                                if (idUsuario != null && !idUsuario.isEmpty()
                                                && !usuariosMostrados.contains(idUsuario)) {
                                        usuariosMostrados.add(idUsuario);

                                        // Buscar el nombre del usuario
                                        List<Usuario> usuarios = usuarioService.getAllUsers();
                                        String nombreUsuario = idUsuario; // Por defecto usar ID
                                        for (Usuario u : usuarios) {
                                                if (idUsuario.equals(u.getId())) {
                                                        nombreUsuario = u.getNombre();
                                                        break;
                                                }
                                        }

                                        ResultadoPanel panel = new ResultadoPanel(nombreUsuario, encuesta);
                                        encuestasPanel.add(panel);
                                }
                        }

                        if (usuariosMostrados.isEmpty()) {
                                javax.swing.JLabel noDataLabel = new javax.swing.JLabel(
                                                "No hay respuestas para esta encuesta.");
                                noDataLabel.setFont(new java.awt.Font("Liberation Sans", java.awt.Font.PLAIN, 24));
                                noDataLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                                encuestasPanel.add(noDataLabel);
                        }

                } catch (Exception e) {
                        e.printStackTrace();
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
        private javax.swing.JLabel lblEncuesta;
        // End of variables declaration//GEN-END:variables
}
