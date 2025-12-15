package com.mycompany.encuestas_app.vistas.admin;

import com.mycompany.encuestas_app.services.EncuestaService;
import com.mycompany.encuestas_app.services.ExportarPDF;
import com.mycompany.encuestas_app.vistas.respuestas.ResultadosSimpleFrame;
import com.mycompany.encuestas_app.vistas.admin.MenuAdminFrame;
import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;
import modelos.Encuesta;

public class MenuAdminEncuestaSimplePanel extends javax.swing.JPanel {

        public Encuesta encuesta;
        private int indice;
        public MenuAdminFrame frame;
        
        private EncuestaService service = new EncuestaService();
        
        public MenuAdminEncuestaSimplePanel(Encuesta encuesta, int indice, MenuAdminFrame frame) {
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
                btnExportarPDF = new javax.swing.JButton();

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

                btnExportarPDF.setBackground(new java.awt.Color(255, 153, 0));
                btnExportarPDF.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
                btnExportarPDF.setForeground(new java.awt.Color(255, 255, 255));
                btnExportarPDF.setText("Exportar PDF");
                btnExportarPDF.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnExportarPDFActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                                .addGap(31, 31, 31)
                                .addComponent(btnExportarPDF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnResultados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditarEncuesta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                                        .addComponent(btnResultados)
                                        .addComponent(btnExportarPDF))
                                .addGap(23, 23, 23))
                );
        }// </editor-fold>//GEN-END:initComponents

        private void btnEliminarPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPreguntaActionPerformed
                int confirm = JOptionPane.showConfirmDialog(frame, "¿Deseas eliminar la encuesta?", "Confirmar",JOptionPane.YES_NO_OPTION);
                
                if (confirm == JOptionPane.YES_OPTION) {
                        try {
                                service.deleteEncuesta(encuesta.getId_encuesta());
                                JOptionPane.showMessageDialog(null, "Encuesta eliminada correctamente");
                                frame.actualizarEncuestas();frame.actualizarEncuestas();
                        } catch (Exception ex) {
                                System.getLogger(MenuAdminEncuestaSimplePanel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                                JOptionPane.showMessageDialog(null, "Error al eliminar la encuesta");
                        }
                }
                
        }//GEN-LAST:event_btnEliminarPreguntaActionPerformed

        private void btnEditarEncuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarEncuestaActionPerformed
                new AgregarEncuestaSimpleFrame(encuesta).setVisible(true);
                frame.dispose();
        }//GEN-LAST:event_btnEditarEncuestaActionPerformed

        private void btnResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResultadosActionPerformed
                new ResultadosSimpleFrame(encuesta).setVisible(true);
                frame.dispose();
        }//GEN-LAST:event_btnResultadosActionPerformed

        private void btnExportarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarPDFActionPerformed
                if (encuesta == null || encuesta.getId_encuesta() == null) {
                        JOptionPane.showMessageDialog(this, "Por favor, seleccione una encuesta primero.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Define el nombre del archivo PDF
                    String nombreArchivo = "Reporte_Graficos_" + encuesta.getNombre().replaceAll(" ", "_") + "_" + System.currentTimeMillis() + ".pdf";

                    try {
                        ExportarPDF exporter = new ExportarPDF();
                        exporter.generarReporteDeEncuesta(encuesta, nombreArchivo);

                        JOptionPane.showMessageDialog(this, "PDF con gráficos generado exitosamente en: " + nombreArchivo, "PDF Generado", JOptionPane.INFORMATION_MESSAGE);

                        if (Desktop.isDesktopSupported()) {
                            File pdfFile = new File(nombreArchivo);
                            if (pdfFile.exists()) {
                                Desktop.getDesktop().open(pdfFile);
                            }
                        }

                    } catch (IllegalArgumentException e) {
                        JOptionPane.showMessageDialog(this, e.getMessage(), "Error de Parámetros", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error al generar el PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
        }//GEN-LAST:event_btnExportarPDFActionPerformed


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnEditarEncuesta;
        private javax.swing.JButton btnEliminarPregunta;
        private javax.swing.JButton btnExportarPDF;
        private javax.swing.JButton btnResultados;
        private javax.swing.JLabel lblNombre;
        // End of variables declaration//GEN-END:variables
}
