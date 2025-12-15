package modelos;

public class Usuario {

    // Campos para coincidir con el JSON del endpoint PHP
    String id_usuario;
    String nombre;
    String email;
    String password_crypt;
    // Cambiado de boolean a String para compatibilidad con JSON de PHP ("1"/"0")
    String es_admin;

    // Constructor para crear usuarios nuevos (antes de guardar en BD)
    public Usuario(String nombre, String email, String password_crypt, boolean es_admin) {
        this.nombre = nombre;
        this.email = email;
        this.password_crypt = password_crypt;
        this.es_admin = es_admin ? "1" : "0";
    }

    public Usuario(String nombre, String email, boolean es_admin) {
        this.nombre = nombre;
        this.email = email;
        this.es_admin = es_admin ? "1" : "0";
    }

    // Constructor para leer usuarios desde la BD
    public Usuario(String id_usuario, String nombre, String email, String password_crypt, boolean es_admin) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.email = email;
        this.password_crypt = password_crypt;
        this.es_admin = es_admin ? "1" : "0";
    }

    // Constructor que acepta String directamente
    public Usuario(String id_usuario, String nombre, String email, String password_crypt, String es_admin) {
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

    // Getter compatible con código existente - devuelve boolean
    public boolean isAdmin() {
        return "1".equals(es_admin) || "true".equalsIgnoreCase(es_admin);
    }

    public boolean isEs_admin() {
        return "1".equals(es_admin) || "true".equalsIgnoreCase(es_admin);
    }

    // Setter que acepta boolean
    public void setEs_admin(boolean es_admin) {
        this.es_admin = es_admin ? "1" : "0";
    }

    // Setter que acepta String directamente
    public void setEs_admin(String es_admin) {
        this.es_admin = es_admin;
    }
}