package com.mycompany.encuestas_app.vistas.cuentas;

import com.mycompany.encuestas_app.services.UsuarioService;
import com.mycompany.encuestas_app.vistas.admin.MenuAdminFrame;
import javax.swing.JOptionPane;
import com.mycompany.encuestas_app.vistas.client.MenuUsuarioFrame;
import modelos.Usuario;
import org.mindrot.jbcrypt.BCrypt;

public class CrearCuentaFrame extends javax.swing.JFrame {
        
        private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CrearCuentaFrame.class.getName());
        
        public UsuarioService service = new UsuarioService();
        
        public CrearCuentaFrame() {
                initComponents();
                
                new MenuAdminFrame().setVisible(true);
                
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
                ent_email = new javax.swing.JTextField();
                ent_password = new javax.swing.JPasswordField();
                btnContinuar = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setBackground(new java.awt.Color(255, 255, 255));

                jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 80)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(0, 153, 204));
                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel1.setText("EncuestApp");

                jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
                jLabel2.setText("¿Ya tienes una cuenta?");

                jButton2.setBackground(new java.awt.Color(255, 255, 255));
                jButton2.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
                jButton2.setForeground(new java.awt.Color(0, 51, 204));
                jButton2.setText("Inicia sesion");
                jButton2.setBorder(null);
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }
                });

                jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                jPanel1.setForeground(new java.awt.Color(255, 255, 255));

                jLabel3.setBackground(new java.awt.Color(204, 204, 204));
                jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 48)); // NOI18N
                jLabel3.setForeground(new java.awt.Color(0, 0, 0));
                jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel3.setText("Crear Cuenta");

                ent_username.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
                ent_username.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre de usuario"));
                ent_username.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                ent_usernameActionPerformed(evt);
                        }
                });

                ent_email.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
                ent_email.setBorder(javax.swing.BorderFactory.createTitledBorder("Email"));
                ent_email.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                ent_emailActionPerformed(evt);
                        }
                });

                ent_password.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
                ent_password.setBorder(javax.swing.BorderFactory.createTitledBorder("Contraseña"));

                btnContinuar.setBackground(new java.awt.Color(0, 102, 255));
                btnContinuar.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
                btnContinuar.setForeground(new java.awt.Color(255, 255, 255));
                btnContinuar.setText("Continuar");
                btnContinuar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnContinuarActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 16, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(ent_email)
                                                                        .addComponent(ent_password, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                                                                        .addComponent(ent_username))
                                                                .addGap(15, 15, 15))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addComponent(btnContinuar)
                                                                .addGap(135, 135, 135))))
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(43, 43, 43)
                                .addComponent(ent_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ent_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ent_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(47, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 509, Short.MAX_VALUE)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton2)
                                                .addGap(492, 492, 492))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(450, 450, 450))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(36, 36, 36)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2)
                                        .addComponent(jLabel2))
                                .addContainerGap(79, Short.MAX_VALUE))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void ent_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ent_emailActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_ent_emailActionPerformed

        private void ent_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ent_usernameActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_ent_usernameActionPerformed

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                new IniciarSesionFrame().setVisible(true);
                this.dispose();
        }//GEN-LAST:event_jButton2ActionPerformed

        private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
                
               // Conseguir datos
    String username = ent_username.getText().trim();
    String email = ent_email.getText().trim();
    String password = new String(ent_password.getPassword()).trim(); // mejor si es JPasswordField

    // Validar datos
    String errores = "";

    if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
        errores += "-Ingrese todos los datos";
    }

    // Validar espacios en username
    for (int i = 0; i < username.length(); i++) {
        char u = username.charAt(i);
        if (u == ' ') {
            errores += "\n-No use espacio entre el nombre";
            break;
        }
    }

    // Validar email básico
    int arroba = 0;
    boolean tienePunto = false;
    OUTER:
    for (int i = 0; i < email.length(); i++) {
        char u = email.charAt(i);
        switch (u) {
            case ' ' -> {
                errores += "\n-No use espacio entre el email";
                break OUTER;
            }
            case '@' -> arroba++;
            case '.' -> tienePunto = true;
            default -> {
            }
        }
    }
    if (arroba != 1 || !tienePunto) {
        errores += "\n-Use un formato de email";
    }

    // Validar contraseña
    if (password.length() < 5) {
        errores += "\n-Ingrese una contraseña con al menos 5 caracteres";
    }

    for (int i = 0; i < password.length(); i++) {
        char u = password.charAt(i);
        if (u == ' ') {
            errores += "\n-No use espacio entre la contraseña";
            break;
        }
    }

    // Validar existencia de usuario / email (mejor con métodos específicos)
    try {
        Usuario usuarioPorNombre = service.getUsuarioPorNombre(username);
        if (usuarioPorNombre != null) {
            errores += "\n-Nombre de usuario ya en uso";
        }

        Usuario usuarioPorEmail = service.getUsuarioPorEmail(email); // crea este método en el service
        if (usuarioPorEmail != null) {
            errores += "\n-Email ya en uso";
        }

    } catch (Exception ex) {
        System.getLogger(CrearCuentaFrame.class.getName())
              .log(System.Logger.Level.ERROR, (String) null, ex);
        JOptionPane.showMessageDialog(null, "Error al validar existencia del usuario");
        return;
    }

    // Si hay errores, mostrarlos
    if (!errores.isEmpty()) {
        JOptionPane.showMessageDialog(null, errores);
        return;
    }

    // Hashear contraseña con BCrypt
    String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());

    // Crear usuario con contraseña hasheada
    Usuario user = new Usuario(username, email, passwordHash, false);

    try {
        service.createUsuario(user, passwordHash);
    } catch (Exception ex) {
        System.getLogger(CrearCuentaFrame.class.getName())
              .log(System.Logger.Level.ERROR, (String) null, ex);
        JOptionPane.showMessageDialog(null, "Error al guardar el usuario");
        return;
    }

    System.out.println("cuenta creada");
    new MenuUsuarioFrame(username).setVisible(true);
    this.dispose();
                

        }//GEN-LAST:event_btnContinuarActionPerformed


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnContinuar;
        private javax.swing.JTextField ent_email;
        private javax.swing.JPasswordField ent_password;
        private javax.swing.JTextField ent_username;
        private javax.swing.JButton jButton2;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        // End of variables declaration//GEN-END:variables
}
