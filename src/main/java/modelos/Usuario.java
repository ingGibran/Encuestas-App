package modelos;

public class Usuario {

    // Campos renombrados para coincidir con el JSON del endpoint PHP
    String id_usuario; // Antes: id
    String nombre;
    String email;
    String password_crypt;
    boolean es_admin; // Antes: admin

    // Constructor para crear usuarios nuevos (antes de guardar en BD)
    public Usuario(String nombre, String email, String password_crypt, boolean es_admin) {
        this.nombre = nombre;
        this.email = email;
        this.password_crypt = password_crypt;
        this.es_admin = es_admin;
    }

    public Usuario(String nombre, String email, boolean es_admin) {
        this.nombre = nombre;
        this.email = email;
        this.es_admin = es_admin;
    }

    // Constructor para leer usuarios desde la BD
    public Usuario(String id_usuario, String nombre, String email, String password_crypt, boolean es_admin) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.email = email;
        this.password_crypt = password_crypt;
        this.es_admin = es_admin;
    }

    // Getter compatible con código existente (alias)
    public String getId() {
        return id_usuario;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword_crypt() {
        return password_crypt;
    }

    // Getter compatible con código existente (alias)
    public boolean isAdmin() {
        return es_admin;
    }

    public boolean isEs_admin() {
        return es_admin;
    }

    public void setEs_admin(boolean es_admin) {
        this.es_admin = es_admin;
    }
}