package modelos;

/**
 *
 * @author alexpy
 */
public class Pregunta {

    private String id_pregunta;
    private String texto;
    private String id_encuesta;
    private int es_principal;
    public int orden;

    public Pregunta(String texto, boolean es_principal) {
        this.texto = texto;
        this.es_principal = es_principal ? 1 : 0;
    }

    public Pregunta(String id_pregunta, String texto, String id_encuesta, boolean es_principal, int orden) {
        this.id_pregunta = id_pregunta;
        this.texto = texto;
        this.id_encuesta = id_encuesta;
        this.es_principal = es_principal ? 1 : 0;
        this.orden = orden;
    }

    public Pregunta(String texto, String id_encuesta, boolean es_principal, int orden) {
        this.texto = texto;
        this.id_encuesta = id_encuesta;
        this.es_principal = es_principal ? 1 : 0;
        this.orden = orden;
    }

    // Constructor adicional que acepta int directamente
    public Pregunta(String id_pregunta, String texto, String id_encuesta, int es_principal, int orden) {
        this.id_pregunta = id_pregunta;
        this.texto = texto;
        this.id_encuesta = id_encuesta;
        this.es_principal = es_principal;
        this.orden = orden;
    }

    // --- Getters y Setters ---

    public int getOrder() {
        return orden;
    }

    public void setOrder(int order) {
        this.orden = order;
    }

    public String getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(String id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getId_encuesta() {
        return id_encuesta;
    }

    public void setId_encuesta(String id_encuesta) {
        this.id_encuesta = id_encuesta;
    }

    // Devuelve boolean para compatibilidad con código existente
    public boolean isEs_principal() {
        return es_principal == 1;
    }

    // Setter que acepta boolean
    public void setEs_principal(boolean es_principal) {
        this.es_principal = es_principal ? 1 : 0;
    }

    // Setter que acepta int directamente
    public void setEs_principal(int es_principal) {
        this.es_principal = es_principal;
    }

}
