package modelos;

/**
 *
 * @author alexpy
 */
public class Encuesta {

    private String id_encuesta;
    private String nombre;
    private String compleja;

    public Encuesta() {

    }

    public Encuesta(String nombre, boolean compleja) {
        this.nombre = nombre;
        this.compleja = compleja ? "1" : "0";
    }

    public Encuesta(String id_encuesta, String nombre, boolean compleja) {
        this.id_encuesta = id_encuesta;
        this.nombre = nombre;
        this.compleja = compleja ? "1" : "0";
    }

    public Encuesta(String id_encuesta, String nombre, String compleja) {
        this.id_encuesta = id_encuesta;
        this.nombre = nombre;
        this.compleja = compleja;
    }

    public String getId_encuesta() {
        return id_encuesta;
    }

    public void setId_encuesta(String id_encuesta) {
        this.id_encuesta = id_encuesta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Devuelve boolean para compatibilidad con código existente
    public boolean isCompleja() {
        return "1".equals(compleja);
    }

    // Setter que acepta boolean
    public void setCompleja(boolean compleja) {
        this.compleja = compleja ? "1" : "0";
    }

    // Setter que acepta String directamente
    public void setCompleja(String compleja) {
        this.compleja = compleja;
    }

}
