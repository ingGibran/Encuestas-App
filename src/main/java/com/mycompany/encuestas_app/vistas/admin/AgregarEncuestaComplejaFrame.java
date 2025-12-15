package com.mycompany.encuestas_app.vistas.admin;


import com.mycompany.encuestas_app.services.EncuestaService;
import com.mycompany.encuestas_app.services.PreguntaService;
import com.mycompany.encuestas_app.vistas.admin.MenuAdminFrame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Encuesta;
import modelos.Pregunta;

public class AgregarEncuestaComplejaFrame extends javax.swing.JFrame {
        
        private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AgregarEncuestaComplejaFrame.class.getName());
        Encuesta encuesta = new Encuesta();
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        
        public int orden = 0;
        
        EncuestaService encuestaService = new EncuestaService();
        PreguntaService preguntaService = new PreguntaService();
        
        public AgregarEncuestaComplejaFrame() {
                initComponents();
                setLocationRelativeTo(null);
        }
        
        public AgregarEncuestaComplejaFrame(Encuesta encuesta) {
                initComponents();
                setLocationRelativeTo(null);
                
                this.encuesta = encuesta;
                
                try {
                        this.preguntas = (ArrayList<Pregunta>) preguntaService.getPreguntasPorEncuesta( encuesta.getId_encuesta() );
                } catch (Exception ex) {
                        System.getLogger(AgregarEncuestaComplejaFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                        JOptionPane.showMessageDialog(null, "Error al cargar la encuesta");
                }
                
                nombreEncuesta.setText(encuesta.getNombre());
                
                actualizarScrollPreguntas();
        }

        
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jLabel1 = new javax.swing.JLabel();
                scrollPanelPreguntas = new javax.swing.JScrollPane();
                panelPreguntas = new javax.swing.JPanel();
                jPanel3 = new javax.swing.JPanel();
                jLabel2 = new javax.swing.JLabel();
                nombreEncuesta = new javax.swing.JTextField();
                btnFinalizar = new javax.swing.JButton();
                btnCancelar = new javax.swing.JButton();
                btnAgregarPregunta = new javax.swing.JButton();
                btnReiniciar = new javax.swing.JButton();
                pregunta = new javax.swing.JTextField();
                jLabel3 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 80)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(0, 153, 204));
                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel1.setText("EncuestApp");

                scrollPanelPreguntas.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                scrollPanelPreguntas.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

                panelPreguntas.setLayout(new javax.swing.BoxLayout(panelPreguntas, javax.swing.BoxLayout.Y_AXIS));
                scrollPanelPreguntas.setViewportView(panelPreguntas);

                jPanel3.setBackground(new java.awt.Color(204, 204, 204));

                jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                jLabel2.setForeground(new java.awt.Color(0, 0, 0));
                jLabel2.setText("Nombre de la encuesta");

                nombreEncuesta.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N

                btnFinalizar.setBackground(new java.awt.Color(0, 153, 51));
                btnFinalizar.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                btnFinalizar.setForeground(new java.awt.Color(255, 255, 255));
                btnFinalizar.setText("Finalizar");
                btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnFinalizarActionPerformed(evt);
                        }
                });

                btnCancelar.setBackground(new java.awt.Color(255, 51, 0));
                btnCancelar.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
                btnCancelar.setText("Cancelar");
                btnCancelar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCancelarActionPerformed(evt);
                        }
                });

                btnAgregarPregunta.setBackground(new java.awt.Color(51, 102, 255));
                btnAgregarPregunta.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                btnAgregarPregunta.setForeground(new java.awt.Color(255, 255, 255));
                btnAgregarPregunta.setText("Agregar pregunta");
                btnAgregarPregunta.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnAgregarPreguntaActionPerformed(evt);
                        }
                });

                btnReiniciar.setBackground(new java.awt.Color(255, 204, 0));
                btnReiniciar.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                btnReiniciar.setForeground(new java.awt.Color(255, 255, 255));
                btnReiniciar.setText("Reiniciar");
                btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnReiniciarActionPerformed(evt);
                        }
                });

                pregunta.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N

                jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                jLabel3.setForeground(new java.awt.Color(0, 0, 0));
                jLabel3.setText("Pregunta");

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nombreEncuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(jLabel2)))
                                .addGap(54, 54, 54)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel3))
                                        .addComponent(pregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addComponent(btnAgregarPregunta)
                                .addGap(62, 62, 62)
                                .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnCancelar)
                                .addGap(0, 26, Short.MAX_VALUE))
                );
                jPanel3Layout.setVerticalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnFinalizar)
                                        .addComponent(btnReiniciar)
                                        .addComponent(btnCancelar)
                                        .addComponent(btnAgregarPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addGap(13, 13, 13)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nombreEncuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pregunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addComponent(scrollPanelPreguntas)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scrollPanelPreguntas, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnAgregarPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPreguntaActionPerformed
                // Validar pregunta
                if (pregunta.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(null, "Ingresa una pregunta correcta");
                        return;
                }
                preguntas.add( new Pregunta(pregunta.getText(), encuesta.getId_encuesta(), true, orden));
                pregunta.setText("");
                actualizarScrollPreguntas();
                System.out.println(preguntas);
        }//GEN-LAST:event_btnAgregarPreguntaActionPerformed

        private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
                preguntas = new ArrayList();
                actualizarScrollPreguntas();
        }//GEN-LAST:event_btnReiniciarActionPerformed

        private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
                new MenuAdminFrame().setVisible(true);
                this.dispose();
        }//GEN-LAST:event_btnCancelarActionPerformed

        private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
                
                
                if (nombreEncuesta.getText().trim().equals("")) {
                        JOptionPane.showConfirmDialog(null, "Agregue un nombre valido");
                                return;
                }
                
                if (encuesta.getId_encuesta() != null) {
                        try {
                                for (Pregunta p : preguntaService.getPreguntasPorEncuesta( encuesta.getId_encuesta() )) {
                                        preguntaService.eliminarPregunta( p.getId_encuesta() );
                                }
                                encuestaService.deleteEncuesta(encuesta.getId_encuesta());
                        } catch (Exception ex) {
                                System.getLogger(AgregarEncuestaComplejaFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                        }
                }

                encuesta.setNombre( nombreEncuesta.getText() );
                encuesta.setCompleja(true);
                try {
                        //encuesta.setPreguntas( preguntas );
                        encuestaService.addEncuesta(encuesta);
                        Encuesta nueva= encuestaService.getEncuestaPorNombre(encuesta.getNombre());
                        // Agregar todas las preguntas
                        for (Pregunta p : preguntas) {
                                System.out.println(p.getTexto());
                                p.setId_encuesta( nueva.getId_encuesta() );
                                preguntaService.agregarPregunta(p);
                        }
                        JOptionPane.showMessageDialog(null, "Encuesta agregada correctmente");
                        
                        new MenuAdminFrame().setVisible(true);
                        this.dispose();
                } catch (Exception ex) {
                        System.getLogger(AgregarEncuestaComplejaFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                        JOptionPane.showMessageDialog(null, "Error al agregar la encuesta");
                }
        }//GEN-LAST:event_btnFinalizarActionPerformed


        
        public void actualizarScrollPreguntas() {
                panelPreguntas.removeAll();
                int indices = 0;
                for (Pregunta pregunta : preguntas) {
                        
                        if (pregunta.isEs_principal()) {
                                PreguntaComplejaPanel panel = new PreguntaComplejaPanel(indices, pregunta, this);
                                panelPreguntas.add(panel);
                                indices++;
                        } else {
                                PreguntaSecundariaPanel panel = new PreguntaSecundariaPanel(indices, indices, pregunta, this);
                                panelPreguntas.add(panel);
                                indices++;
                        }
                }
                        panelPreguntas.revalidate(); 
                        panelPreguntas.repaint(); 
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnAgregarPregunta;
        private javax.swing.JButton btnCancelar;
        private javax.swing.JButton btnFinalizar;
        private javax.swing.JButton btnReiniciar;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JTextField nombreEncuesta;
        private javax.swing.JPanel panelPreguntas;
        private javax.swing.JTextField pregunta;
        private javax.swing.JScrollPane scrollPanelPreguntas;
        // End of variables declaration//GEN-END:variables
}
