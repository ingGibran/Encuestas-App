<?php

require "/var/www/html/tap/encuestas_app/Conexion.php";

class RespuestaService {
    private $conexion;

    public function __construct() {
        $this->conexion = new Conexion();
    }

    /**
     * Obtiene una respuesta específica de un usuario para una pregunta dada.
     */
    public function getRespuestaPorPreguntaYUsuario($id_pregunta, $id_usuario) {
        $sql = 
            "SELECT id_respuesta, id_pregunta, id_usuario, valor, orden " .
            "FROM respuestas " .
            "WHERE id_pregunta = ? AND id_usuario = ? " .
            "ORDER BY orden ASC " .
            "LIMIT 1"; // Solo la primera respuesta

        $results = array();

        try {
            $con = $this->conexion->open();
            $query = mysqli_prepare($con, $sql);
            
            // Enlaza los IDs (strings)
            mysqli_stmt_bind_param($query, "ss", $id_pregunta, $id_usuario);
            mysqli_stmt_execute($query);
            $resultSet = mysqli_stmt_get_result($query);
            
            while ($row = mysqli_fetch_assoc($resultSet)) {
                $results[] = $row;
            }

            $this->conexion->close($con);
        } catch (\Throwable $th) {
            error_log("Error al obtener respuesta por pregunta y usuario: " . $th->getMessage());
        }

        return $results;
    }
    
    /**
     * Obtiene todas las respuestas de un usuario para una encuesta específica.
     */
    public function getRespuestasPorEncuestaYUsuario($id_encuesta, $id_usuario) {
        $sql =
            "SELECT r.id_respuesta, r.id_pregunta, r.id_usuario, r.valor, r.orden " .
            "FROM respuestas r " .
            "INNER JOIN preguntas p ON r.id_pregunta = p.id_pregunta " .
            "WHERE p.id_encuesta = ? AND r.id_usuario = ? " .
            "ORDER BY r.orden ASC";

        $results = array();

        try {
            $con = $this->conexion->open();
            $query = mysqli_prepare($con, $sql);
            
            // Enlaza los IDs (strings)
            mysqli_stmt_bind_param($query, "ss", $id_encuesta, $id_usuario);
            mysqli_stmt_execute($query);
            $resultSet = mysqli_stmt_get_result($query);
            
            while ($row = mysqli_fetch_assoc($resultSet)) {
                $results[] = $row;
            }

            $this->conexion->close($con);
        } catch (\Throwable $th) {
            error_log("Error al obtener respuestas por encuesta y usuario: " . $th->getMessage());
        }

        return $results;
    }

    /**
     * Agrega una nueva respuesta.
     */
    public function agregarRespuesta($id_pregunta, $id_usuario, $valor, $orden) {
        // Validación de valor (como en tu Java)
        if ($valor < 1 || $valor > 5) {
            throw new Exception("El valor de la respuesta debe estar entre 1 y 5");
        }
        
        // Usamos UUID() para el id_respuesta (similar a tu Java si el ID era null/vacío)
        $sql = "INSERT INTO respuestas (id_respuesta, id_pregunta, id_usuario, valor, orden) " .
               "VALUES (UUID(), ?, ?, ?, ?)";
        $rowsAffected = 0;

        try {
            $con = $this->conexion->open();

            $query = mysqli_prepare($con, $sql);

            // 's' id_pregunta, 's' id_usuario, 'i' valor, 'i' orden
            mysqli_stmt_bind_param($query, "ssii", $id_pregunta, $id_usuario, $valor, $orden); 

            $rowsAffected = mysqli_stmt_execute($query);

            $this->conexion->close($con);
        } catch (\Throwable $th) {
            error_log("Error al agregar respuesta: " . $th->getMessage());
        }

        return $rowsAffected;
    }
    
    /**
     * Elimina una respuesta por su ID.
     */
    public function eliminarRespuesta($id_respuesta) {
        $sql = "DELETE FROM respuestas WHERE id_respuesta = ?";
        $rowsAffected = 0;

        try {
            $con = $this->conexion->open();

            $query = mysqli_prepare($con, $sql);
            mysqli_stmt_bind_param($query, "s", $id_respuesta);
            $rowsAffected = mysqli_stmt_execute($query);

            $this->conexion->close($con);
        } catch (\Throwable $th) {
            error_log("Error al eliminar respuesta: " . $th->getMessage());
        }

        return $rowsAffected;
    }
    
    /**
     * Obtiene todas las respuestas para una pregunta específica.
     */
    public function getRespuestasPorPregunta($id_pregunta) {
        $sql = "SELECT id_respuesta, id_pregunta, id_usuario, valor, orden FROM respuestas WHERE id_pregunta = ?";
        $results = array();

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
            error_log("Error al obtener respuestas por pregunta: " . $th->getMessage());
        }

        return $results;
    }
}
?>