package modelos;

public class Respuesta {

    private String id_respuesta;
    private String id_pregunta;
    private String id_usuario;
    private int valor;
    public int orden;

    public Respuesta() {
    }

        public Respuesta(String id_respuesta, String id_pregunta, String id_usuario, int valor, int orden) {
                this.id_respuesta = id_respuesta;
                this.id_pregunta = id_pregunta;
                this.id_usuario = id_usuario;
                this.valor = valor;
                this.orden = orden;
        }
        
        public Respuesta(String id_pregunta, String id_usuario, int valor, int orden) {
                this.id_pregunta = id_pregunta;
                this.id_usuario = id_usuario;
                this.valor = valor;
                this.orden = orden;
        }

        public String getId_usuario() {
                return id_usuario;
        }

        public void setId_usuario(String id_usuario) {
                this.id_usuario = id_usuario;
        }

        public int getOrden() {
                return orden;
        }

        public void setOrden(int orden) {
                this.orden = orden;
        }

    public String getId_respuesta() {
        return id_respuesta;
    }

    public void setId_respuesta(String id_respuesta) {
        this.id_respuesta = id_respuesta;
    }

    public String getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(String id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        if (valor < 1 || valor > 5) {
            throw new IllegalArgumentException("El valor de la respuesta debe estar entre 1 y 5");
        }
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Respuesta{" +
                "id_respuesta='" + id_respuesta + '\'' +
                ", id_pregunta='" + id_pregunta + '\'' +
                ", valor=" + valor +
                '}';
    }
}
