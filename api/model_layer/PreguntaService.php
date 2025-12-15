<?php

require "/var/www/html/tap/encuestas_app/Conexion.php";

class PreguntaService {
    private $conexion;

    public function __construct() {
        $this->conexion = new Conexion();
    }

    /**
     * Obtiene todas las preguntas asociadas a una encuesta específica.
     */
    public function getPreguntasPorEncuesta($id_encuesta) {
        // Incluyo 'orden' para mantener la lógica de tu modelo Java
        $sql = "SELECT id_pregunta, texto, id_encuesta, es_principal, orden FROM preguntas WHERE id_encuesta = ? ORDER BY orden ASC";
        $results = array();

        try {
            $con = $this->conexion->open();
            $query = mysqli_prepare($con, $sql);
            
            // Enlaza el id_encuesta (string)
            mysqli_stmt_bind_param($query, "s", $id_encuesta);
            mysqli_stmt_execute($query);
            $resultSet = mysqli_stmt_get_result($query);
            
            while ($row = mysqli_fetch_assoc($resultSet)) {
                $results[] = $row;
            }

            $this->conexion->close($con);
        } catch (\Throwable $th) {
            error_log("Error al obtener preguntas por encuesta: " . $th->getMessage());
        }

        return $results;
    }

    /**
     * Obtiene una pregunta por su ID.
     */
    public function getPreguntaPorId($id_pregunta) {
        $sql = "SELECT id_pregunta, texto, id_encuesta, es_principal, orden FROM preguntas WHERE id_pregunta = ?";
        $results = array(); // Devolvemos un array, que podría contener 0 o 1 elemento

        try {
            $con = $this->conexion->open();
            $query = mysqli_prepare($con, $sql);
            
            mysqli_stmt_bind_param($query, "s", $id_pregunta);
            mysqli_stmt_execute($query);
            $resultSet = mysqli_stmt_get_result($query);
            
            while ($row = mysqli_fetch_assoc($resultSet)) {
                $results[] = $row;
            }

            $this->conexion->close($con);
        } catch (\Throwable $th) {
            error_log("Error al obtener pregunta por ID: " . $th->getMessage());
        }

        return $results;
    }

    /**
     * Agrega una nueva pregunta.
     * En tu Java, el ID se genera si no existe; aquí usaremos UUID() para asegurarlo.
     */
    public function agregarPregunta($texto, $id_encuesta, $es_principal, $orden) {
        // Nota: En tu Java usas (id_pregunta, texto, id_encuesta, es_principal) y generas el ID
        // Aquí simplificaremos usando UUID() para el ID.
        // Asumo que 'orden' es un campo obligatorio en tu BD por el constructor de Java.
        $sql = "INSERT INTO preguntas (id_pregunta, texto, id_encuesta, es_principal, orden) VALUES (UUID(), ?, ?, ?, ?)";
        $rowsAffected = 0;

        try {
            $con = $this->conexion->open();

            $query = mysqli_prepare($con, $sql);

            // 's' texto, 's' id_encuesta, 'i' es_principal (boolean), 'i' orden (integer)
            mysqli_stmt_bind_param($query, "ssii", $texto, $id_encuesta, $es_principal, $orden); 

            $rowsAffected = mysqli_stmt_execute($query);

            $this->conexion->close($con);
        } catch (\Throwable $th) {
            error_log("Error al agregar pregunta: " . $th->getMessage());
        }

        return $rowsAffected;
    }
    
    /**
     * Elimina una pregunta por su ID.
     */
    public function eliminarPregunta($id_pregunta) {
        $sql = "DELETE FROM preguntas WHERE id_pregunta = ?";
        $rowsAffected = 0;

        try {
            $con = $this->conexion->open();

            $query = mysqli_prepare($con, $sql);
            mysqli_stmt_bind_param($query, "s", $id_pregunta);
            $rowsAffected = mysqli_stmt_execute($query);

            $this->conexion->close($con);
        } catch (\Throwable $th) {
            error_log("Error al eliminar pregunta: " . $th->getMessage());
        }

        return $rowsAffected;
    }
}
?>