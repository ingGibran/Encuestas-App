package com.mycompany.encuestas_app.vistas.respuestas;

import com.mycompany.encuestas_app.services.PreguntaService;
import com.mycompany.encuestas_app.vistas.respuestas.ResultadosEncuestaSimpleFrame;
import java.awt.Color;
import javax.swing.JOptionPane;
import modelos.Respuesta;

public class RespuestasEncuestaSimpleAdminPanel extends javax.swing.JPanel {
        
        public int indice;
        public Respuesta respuesta;
        public ResultadosEncuestaSimpleAdminFrame frame;
        
        private PreguntaService preguntaService = new PreguntaService();
        

        public RespuestasEncuestaSimpleAdminPanel(int indice, Respuesta respuesta, ResultadosEncuestaSimpleAdminFrame frame) {
                initComponents();
                
                this.indice = indice;
                this.respuesta = respuesta;
                this.frame = frame;
                
                try {
                        lblPregunta.setText( preguntaService.getPreguntaPorId(respuesta.getId_pregunta()).getTexto() );
                } catch (Exception ex) {
                        System.getLogger(RespuestasEncuestaSimpleAdminPanel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                        JOptionPane.showMessageDialog(null, "Error al encontrar la pregunta");
                }
                lblIndice.setText( (indice+1) + "" );
                
                switch (respuesta.getValor()) {
                        case 1:
                                btnUno.setBackground(Color.GREEN);
                                break;
                        case 2:
                                btnDos.setBackground(Color.GREEN);
                                break;
                        case 3:
                                btnTres.setBackground(Color.GREEN);
                                break;
                        
                        case 4:
                                btnCuatro.setBackground(Color.GREEN);
                                break;
                                
                        case 5:
                                btnCinco.setBackground(Color.GREEN);
                                break;
                }
                
        }
        
        

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                btnUno = new org.edisoncor.gui.button.ButtonIcon();
                btnDos = new org.edisoncor.gui.button.ButtonIcon();
                btnTres = new org.edisoncor.gui.button.ButtonIcon();
                btnCuatro = new org.edisoncor.gui.button.ButtonIcon();
                btnCinco = new org.edisoncor.gui.button.ButtonIcon();
                lblPregunta = new javax.swing.JLabel();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                lblIndice = new javax.swing.JLabel();

                btnUno.setIcon(new javax.swing.ImageIcon("/home/alexpy/NetBeansProjects/Encuestas_App/images/1.png")); // NOI18N
                btnUno.setText("buttonIcon1");

                btnDos.setIcon(new javax.swing.ImageIcon("/home/alexpy/NetBeansProjects/Encuestas_App/images/2.png")); // NOI18N
                btnDos.setText("buttonIcon1");

                btnTres.setIcon(new javax.swing.ImageIcon("/home/alexpy/NetBeansProjects/Encuestas_App/images/3.png")); // NOI18N
                btnTres.setText("buttonIcon1");

                btnCuatro.setIcon(new javax.swing.ImageIcon("/home/alexpy/NetBeansProjects/Encuestas_App/images/4.png")); // NOI18N
                btnCuatro.setText("buttonIcon1");

                btnCinco.setIcon(new javax.swing.ImageIcon("/home/alexpy/NetBeansProjects/Encuestas_App/images/5.png")); // NOI18N
                btnCinco.setText("buttonIcon1");

                lblPregunta.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
                lblPregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lblPregunta.setText("Pregunta");

                jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
                jLabel1.setText("Muy de acuerdo / a favor");

                jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
                jLabel2.setText("Muy en desacuerdo / en contra");

                lblIndice.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
                lblIndice.setText("n");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(lblIndice, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(222, 222, 222)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(btnUno, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btnDos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnTres, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnCuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnCinco, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPregunta)
                                        .addComponent(lblIndice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnTres, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCinco, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnUno, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addContainerGap(14, Short.MAX_VALUE))
                );
        }// </editor-fold>//GEN-END:initComponents
        

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private org.edisoncor.gui.button.ButtonIcon btnCinco;
        private org.edisoncor.gui.button.ButtonIcon btnCuatro;
        private org.edisoncor.gui.button.ButtonIcon btnDos;
        private org.edisoncor.gui.button.ButtonIcon btnTres;
        private org.edisoncor.gui.button.ButtonIcon btnUno;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel lblIndice;
        private javax.swing.JLabel lblPregunta;
        // End of variables declaration//GEN-END:variables
}
