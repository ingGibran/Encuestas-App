<?php

class Conexion {
    private string $host;
    private int $port;
    private string $user;
    private string $password;
    private string $database;

    public function __construct() {
        // Constructor único y correcto
        $this->host = "localhost";
        $this->port = 3306;
        $this->user = "root";
        $this->password = "123";
        $this->database = "encuestas_app";
    }

    public function open() { 
        $conexion = mysqli_connect(
            $this->host, $this->user, $this->password, $this->database, $this->port
        );
        if (!$conexion) {
            die("Error. No se pudo conectar a la base de datos: " . mysqli_connect_error());
        }

        return $conexion;
    }

    public function close($conexion) {
        mysqli_close($conexion);
    }

}
?>
