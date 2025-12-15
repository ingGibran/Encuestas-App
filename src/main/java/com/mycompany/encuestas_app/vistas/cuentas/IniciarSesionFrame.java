package com.mycompany.encuestas_app.vistas.cuentas;

import com.mycompany.encuestas_app.services.UsuarioService;
import com.mycompany.encuestas_app.vistas.admin.MenuAdminFrame;
import javax.swing.JOptionPane;
import com.mycompany.encuestas_app.vistas.client.MenuUsuarioFrame;
import modelos.Usuario;
import org.mindrot.jbcrypt.BCrypt;

public class IniciarSesionFrame extends javax.swing.JFrame {
        
        private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(IniciarSesionFrame.class.getName());
        

        private UsuarioService usuarioService = new UsuarioService();
        
        public IniciarSesionFrame() {
                
                initComponents();
                
/*
                Usuario user = new Usuario("Gibran", "alegizago@gmail.com", true);
                try {
                        usuarioService.addUsr(user, "12345");
                } catch (Exception ex) {
                        System.getLogger(IniciarSesionFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
*/
                
                
                
                
                ent_username.setText("alegizago@gmail.com");
                ent_password.setText("12345");
                
                this.setLocationRelativeTo(null);
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jButton2 = new javax.swing.JButton();
                jPanel1 = new javax.swing.JPanel();
                jLabel3 = new javax.swing.JLabel();
                ent_username = new javax.swing.JTextField();
                ent_password = new javax.swing.JPasswordField();
                btnEntrar = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setBackground(new java.awt.Color(153, 153, 153));

                jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 80)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(0, 153, 204));
                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel1.setText("EncuestApp");

                jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
                jLabel2.setText("¿Aún no tienes una cuenta?");

                jButton2.setBackground(new java.awt.Color(255, 255, 255));
                jButton2.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
                jButton2.setForeground(new java.awt.Color(0, 51, 255));
                jButton2.setText("Crea una");
                jButton2.setBorder(null);
                jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }
                });

                jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

                jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 48)); // NOI18N
                jLabel3.setForeground(new java.awt.Color(0, 0, 0));
                jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel3.setText("Iniciar Sesión");

                ent_username.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
                ent_username.setBorder(javax.swing.BorderFactory.createTitledBorder("Email"));
                ent_username.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                ent_usernameActionPerformed(evt);
                        }
                });

                ent_password.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
                ent_password.setBorder(javax.swing.BorderFactory.createTitledBorder("Contraseña"));

                btnEntrar.setBackground(new java.awt.Color(0, 102, 255));
                btnEntrar.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
                btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
                btnEntrar.setText("Entrar");
                btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                btnEntrar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnEntrarActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(28, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ent_username)
                                        .addComponent(ent_password, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22))
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel3)
                                .addGap(68, 68, 68)
                                .addComponent(ent_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(ent_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton2)
                                                .addGap(489, 489, 489))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(454, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(444, 444, 444))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(33, 33, 33)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jButton2))
                                .addGap(73, 73, 73))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void ent_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ent_usernameActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_ent_usernameActionPerformed

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                new CrearCuentaFrame().setVisible(true);
                this.dispose();
        }//GEN-LAST:event_jButton2ActionPerformed

        private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed

                // 1. Obtener datos
                String loginInput = ent_username.getText(); // Email o Nombre, dependiendo de tu lógica
                String password = new String(ent_password.getPassword()); 

                Usuario usuario_logeado = null;

                try {
                    // 2. LLAMADA CLAVE: Usamos el método 'login' del servicio Java, 
                    //    el cual llama al endpoint PHP. PHP hace la validación BCrypt con password_verify().
                    usuario_logeado = usuarioService.login(loginInput, password);

                } catch (Exception ex) {
                    // Manejo de errores de comunicación con el servidor
                    System.err.println("Error al comunicar con el servidor: " + ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Error al comunicar con el servidor o en la conexión.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // 3. Validar la respuesta del servidor PHP
                if (usuario_logeado == null) {
                    // Si PHP devuelve null (o error), significa credenciales incorrectas.
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // --- Autenticación Exitosa (La validación BCrypt la hizo PHP) ---
                System.out.println("Validación exitosa. Iniciando sesión...");

                // Redirección a menús
                System.out.println(usuario_logeado.isAdmin() + "");
                if (usuario_logeado.isAdmin()) {
                    new MenuAdminFrame().setVisible(true);
                    this.dispose();
                } else {
                    // Usar el nombre del objeto Usuario devuelto
                    new MenuUsuarioFrame(usuario_logeado.getNombre()).setVisible(true);
                    this.dispose();
                }

        }//GEN-LAST:event_btnEntrarActionPerformed


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnEntrar;
        private javax.swing.JPasswordField ent_password;
        private javax.swing.JTextField ent_username;
        private javax.swing.JButton jButton2;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        // End of variables declaration//GEN-END:variables
}
