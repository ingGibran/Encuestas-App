package com.mycompany.encuestas_app.vistas.admin;

import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import com.mycompany.encuestas_app.services.EncuestaService;
import com.mycompany.encuestas_app.services.ExportarExcel;
import com.mycompany.encuestas_app.vistas.cuentas.IniciarSesionFrame;
import modelos.Encuesta;

public class MenuAdminFrame extends javax.swing.JFrame {
        
        private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuAdminFrame.class.getName());
        
        private EncuestaService encuestaService = new EncuestaService();
        
        public List<Encuesta> encuestas;
        
       
        
        public MenuAdminFrame() {
                initComponents();
                
                setLocationRelativeTo(null);
                
                try {
                        encuestas = encuestaService.getAllEncuestas();
                } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al obtener encuestas");
                }

                actualizarEncuestas();
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jLabel1 = new javax.swing.JLabel();
                jPanel1 = new javax.swing.JPanel();
                jLabel2 = new javax.swing.JLabel();
                btnAgregarEncuestaSimple = new javax.swing.JButton();
                btnAgregarEncuestaCompleja = new javax.swing.JButton();
                btnAgregarAdministrador = new javax.swing.JButton();
                btnExportarDatos = new javax.swing.JButton();
                btnCerrarSesion = new javax.swing.JButton();
                jLabel3 = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                panelEncuestas = new javax.swing.JPanel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setBackground(new java.awt.Color(255, 255, 255));

                jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 80)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(0, 153, 204));
                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel1.setText("EncuestApp");

                jPanel1.setBackground(new java.awt.Color(204, 204, 204));
                jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

                jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
                jLabel2.setForeground(new java.awt.Color(0, 0, 0));
                jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel2.setText("Panel de control");

                btnAgregarEncuestaSimple.setBackground(new java.awt.Color(51, 102, 255));
                btnAgregarEncuestaSimple.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                btnAgregarEncuestaSimple.setForeground(new java.awt.Color(255, 255, 255));
                btnAgregarEncuestaSimple.setText("Agregar encuesta simple");
                btnAgregarEncuestaSimple.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnAgregarEncuestaSimpleActionPerformed(evt);
                        }
                });

                btnAgregarEncuestaCompleja.setBackground(new java.awt.Color(51, 102, 255));
                btnAgregarEncuestaCompleja.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                btnAgregarEncuestaCompleja.setForeground(new java.awt.Color(255, 255, 255));
                btnAgregarEncuestaCompleja.setText("Agregar encuesta compleja");
                btnAgregarEncuestaCompleja.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnAgregarEncuestaComplejaActionPerformed(evt);
                        }
                });

                btnAgregarAdministrador.setBackground(new java.awt.Color(51, 102, 255));
                btnAgregarAdministrador.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                btnAgregarAdministrador.setForeground(new java.awt.Color(255, 255, 255));
                btnAgregarAdministrador.setText("Agregar administrador");
                btnAgregarAdministrador.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnAgregarAdministradorActionPerformed(evt);
                        }
                });

                btnExportarDatos.setBackground(new java.awt.Color(0, 204, 0));
                btnExportarDatos.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                btnExportarDatos.setForeground(new java.awt.Color(255, 255, 255));
                btnExportarDatos.setText("Exportar excel");
                btnExportarDatos.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnExportarDatosActionPerformed(evt);
                        }
                });

                btnCerrarSesion.setBackground(new java.awt.Color(204, 0, 0));
                btnCerrarSesion.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
                btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
                btnCerrarSesion.setText("Cerrar Sesion");
                btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCerrarSesionActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(btnAgregarAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregarEncuestaSimple)
                                .addGap(63, 63, 63)
                                .addComponent(btnAgregarEncuestaCompleja)
                                .addGap(101, 101, 101)
                                .addComponent(btnExportarDatos)
                                .addGap(18, 18, 18)
                                .addComponent(btnCerrarSesion)
                                .addGap(23, 23, 23))
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAgregarAdministrador)
                                        .addComponent(btnAgregarEncuestaSimple)
                                        .addComponent(btnAgregarEncuestaCompleja)
                                        .addComponent(btnExportarDatos)
                                        .addComponent(btnCerrarSesion))
                                .addContainerGap(14, Short.MAX_VALUE))
                );

                jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
                jLabel3.setForeground(new java.awt.Color(0, 0, 0));
                jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel3.setText("Encuestas");

                jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

                panelEncuestas.setLayout(new javax.swing.BoxLayout(panelEncuestas, javax.swing.BoxLayout.Y_AXIS));
                jScrollPane1.setViewportView(panelEncuestas);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1400, Short.MAX_VALUE)
                        .addComponent(jScrollPane1)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnAgregarAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAdministradorActionPerformed
                new AgregarAdministradorFrame().setVisible(true);
                this.dispose();
        }//GEN-LAST:event_btnAgregarAdministradorActionPerformed

        private void btnAgregarEncuestaSimpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEncuestaSimpleActionPerformed
                new AgregarEncuestaSimpleFrame().setVisible(true);
                this.dispose();
        }//GEN-LAST:event_btnAgregarEncuestaSimpleActionPerformed

        private void btnAgregarEncuestaComplejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEncuestaComplejaActionPerformed
                new AgregarEncuestaComplejaFrame().setVisible(true);
                this.dispose();
        }//GEN-LAST:event_btnAgregarEncuestaComplejaActionPerformed

        private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
                new IniciarSesionFrame().setVisible(true);
                this.dispose();
        }//GEN-LAST:event_btnCerrarSesionActionPerformed

        private void btnExportarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarDatosActionPerformed
                try {
                        String fileName = "Reporte_Consolidado_Encuestas.xlsx";

                        ExportarExcel exporter = new ExportarExcel();

                        exporter.Reportar(fileName);

                        JOptionPane.showMessageDialog(this, "Reporte exportado como: " + fileName);

                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error al generar el reporte: " + e.getMessage());
                    }
        }//GEN-LAST:event_btnExportarDatosActionPerformed

        public static void main(String args[]) {
                /* Set the Nimbus look and feel */
                //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
                /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
                 */
                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
                        logger.log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(() -> new MenuAdminFrame().setVisible(true));
        }
        
        public void actualizarEncuestas() {
                try {
                        encuestas = encuestaService.getAllEncuestas();
                } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al obtener encuestas");
                }
                panelEncuestas.removeAll();
                
                int indice = 0;
                for (Encuesta e : encuestas) {
                        MenuAdminEncuestaSimplePanel panel = new MenuAdminEncuestaSimplePanel(e, indice, this);
                        panelEncuestas.add(panel);
                        indice++;
                }
                
                        panelEncuestas.revalidate(); 
                        panelEncuestas.repaint(); 
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnAgregarAdministrador;
        private javax.swing.JButton btnAgregarEncuestaCompleja;
        private javax.swing.JButton btnAgregarEncuestaSimple;
        private javax.swing.JButton btnCerrarSesion;
        private javax.swing.JButton btnExportarDatos;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JPanel panelEncuestas;
        // End of variables declaration//GEN-END:variables
}
