<?php

require "/var/www/html/tap/encuestas_app/Conexion.php";

class EncuestaService {
    private $conexion;

    public function __construct() {
        $this->conexion = new Conexion();
    }

    // Método para obtener todas las encuestas
    public function getAllEncuestas() {
        $sql = "SELECT id_encuesta, nombre, compleja FROM encuestas";

        $results = array();

        try {
            $con = $this->conexion->open();

            // Usamos mysqli_query simple ya que no hay parámetros de usuario
            $resultSet = mysqli_query($con, $sql);
            while ($row = mysqli_fetch_assoc($resultSet)) {
                $results[] = $row;
            }

            $this->conexion->close($con);
        } catch (\Throwable $th) {
            echo "Error al obtener las encuestas: " . $th->getMessage();
        }

        return $results;
    }

    // Método para obtener una encuesta por nombre (ejemplo de SELECT con parámetro)
    public function getEncuestaPorNombre($nombre) {
        $sql = "SELECT id_encuesta, nombre, compleja FROM encuestas WHERE nombre = ?";
        $results = array();

        try {
            $con = $this->conexion->open();
            $query = mysqli_prepare($con, $sql);
            mysqli_stmt_bind_param($query, "s", $nombre);
            
            // Ejecuta y obtiene los resultados
            mysqli_stmt_execute($query);
            $resultSet = mysqli_stmt_get_result($query);
            
            while ($row = mysqli_fetch_assoc($resultSet)) {
                $results[] = $row;
            }

            $this->conexion->close($con);
        } catch (\Throwable $th) {
            echo "Error al obtener la encuesta: " . $th->getMessage();
        }

        return $results;
    }

    // Método para agregar una nueva encuesta (ejemplo de INSERT)
    public function addEncuesta($nombre, $compleja) {
        // En MySQL, UUID() genera el ID. 'i' es para entero (boolean en DB se trata como 0/1)
        $sql = "INSERT INTO encuestas (id_encuesta, nombre, compleja) VALUES (UUID(), ?, ?)";
        $rowsAffected = 0;

        try {
            $con = $this->conexion->open();

            $query = mysqli_prepare($con, $sql);

            // 's' para string (nombre), 'i' para integer (compleja, que es un booleano)
            mysqli_stmt_bind_param($query, "si", $nombre, $compleja); 

            $rowsAffected = mysqli_stmt_execute($query);

            $this->conexion->close($con);
        } catch (\Throwable $th) {
            // No mostrar errores internos al cliente final, solo en desarrollo.
            error_log("Error al agregar la encuesta: " . $th->getMessage());
            // Puedes cambiar esto para que solo devuelva 0 o un error más genérico.
            echo "Error al agregar la encuesta: " . $th->getMessage(); 
        }

        return $rowsAffected;
    }

    public function deleteEncuesta($id_encuesta) {
        $sql = "DELETE FROM encuestas WHERE id_encuesta = ?";
        $rowsAffected = 0;

        try {
            $con = $this->conexion->open();
            $query = mysqli_prepare($con, $sql);
            mysqli_stmt_bind_param($query, "s", $id_encuesta);
            
            $rowsAffected = mysqli_stmt_execute($query);

            $this->conexion->close($con);
        } catch (\Throwable $th) {
            // Nota: Si hay claves foráneas (preguntas, respuestas), la eliminación fallará aquí.
            error_log("Error al eliminar encuesta: " . $th->getMessage());
        }

        return $rowsAffected;
    }
}
?>