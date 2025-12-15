<?php
// Asegúrate de que 'Conexion.php' esté disponible
require "/var/www/html/tap/encuestas_app/Conexion.php";

class UsuarioService {
    private $conexion;

    public function __construct() {
        $this->conexion = new Conexion();
    }

    public function findUsrByEmailAndPass($email, $password) {
        // 1. **CAMBIO CLAVE**: Seleccionamos TODOS los campos, incluyendo password_crypt, 
        //    y buscamos SOLO por email.
        $sql = "SELECT id_usuario, nombre, email, password_crypt, es_admin FROM usuarios WHERE email = ?";
        $user_data = array();

        try {
            $con = $this->conexion->open();

            // Prepara y ejecuta la consulta solo por email
            $query = mysqli_prepare($con, $sql);
            mysqli_stmt_bind_param($query, "s", $email);
            mysqli_stmt_execute($query);
            $resultSet = mysqli_stmt_get_result($query);

            if ($row = mysqli_fetch_assoc($resultSet)) {
                // 2. **CAMBIO CLAVE**: Obtenemos el hash almacenado
                $stored_hash = $row['password_crypt']; 

                // 3. **CAMBIO CLAVE**: Usamos password_verify para comparar la contraseña plana con el hash BCrypt
                if (password_verify($password, $stored_hash)) {
                    // Si la verificación es exitosa, limpiamos el hash antes de devolver los datos
                    unset($row['password_crypt']); 
                    $user_data[] = $row;
                }
                // Si password_verify falla, $user_data sigue siendo un array vacío.
            }

            $this->conexion->close($con);
            
        } catch (\Throwable $th) {
            error_log("Error al buscar usuario: " . $th->getMessage());
        }

        return $user_data; // Devuelve el usuario solo si la contraseña es válida
    }

    public function addUsr($nombre, $email, $password, $es_admin) {
        
        // CAMBIO CLAVE: Usamos PASSWORD_BCRYPT y definimos el costo (cost: 10)
        $hashed_password = password_hash($password, PASSWORD_BCRYPT, ['cost' => 10]); 

        // 2. Usar la sentencia SQL para insertar el hash
        $sql = "INSERT INTO usuarios (id_usuario, nombre, email, password_crypt, es_admin) VALUES (UUID(), ?, ?, ?, ?)";
        $rowsAffected = 0;

        try {
            $con = $this->conexion->open();
            $query = mysqli_prepare($con, $sql);
            
            // 3. Enlazar el hash BCrypt
            mysqli_stmt_bind_param(
                $query, 
                "sssi", 
                $nombre, 
                $email, 
                $hashed_password, // <-- Usamos la contraseña hasheada
                $es_admin
            );

            // 4. Ejecuta la query y guarda el número de filas afectadas
            $rowsAffected = mysqli_stmt_execute($query);
            
            $this->conexion->close($con); // Cerrar la conexión si la ejecución fue exitosa
            
        } catch (\Throwable $th) { // <-- Bloque catch requerido
            error_log("Error al agregar usuario: " . $th->getMessage());
            // Aquí no se cierra la conexión si falló la apertura, 
            // pero sí se captura el error para evitar el fallo fatal.
        }

        return $rowsAffected; // <-- Retorno del resultado
    }


public function getUsuarioPorNombre($nombre) {
    // CAMBIO CLAVE: Aseguramos que 'password_crypt' sea seleccionado
    $sql = "SELECT id_usuario, nombre, email, password_crypt, es_admin FROM usuarios WHERE nombre = ?";
    
    $results = array();

    try {
        $con = $this->conexion->open();
        $query = mysqli_prepare($con, $sql);
        mysqli_stmt_bind_param($query, "s", $nombre);

        mysqli_stmt_execute($query);
        $resultSet = mysqli_stmt_get_result($query);

        while ($row = mysqli_fetch_assoc($resultSet)) {
            $results[] = $row;
        }

        $this->conexion->close($con);
    } catch (\Throwable $th) {
        error_log("Error al buscar usuario por nombre: " . $th->getMessage());
    }

    return $results;
}

/**
 * Busca un usuario por su email.
 */
public function getUsuarioPorEmail($email) {
    $sql = "SELECT id_usuario, nombre, email, es_admin FROM usuarios WHERE email = ?";
    $results = array();

    try {
        $con = $this->conexion->open();
        $query = mysqli_prepare($con, $sql);
        mysqli_stmt_bind_param($query, "s", $email);

        mysqli_stmt_execute($query);
        $resultSet = mysqli_stmt_get_result($query);

        while ($row = mysqli_fetch_assoc($resultSet)) {
            $results[] = $row;
        }

        $this->conexion->close($con);
    } catch (\Throwable $th) {
        error_log("Error al buscar usuario por email: " . $th->getMessage());
    }

    return $results;
}

public function getAllUsers() {
    // Seleccionamos las columnas relevantes, excluyendo la contraseña encriptada
    $sql = "SELECT id_usuario, nombre, email, es_admin FROM usuarios ORDER BY nombre ASC";
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
        error_log("Error al obtener todos los usuarios: " . $th->getMessage());
    }

    return $results;
}

public function findUsrByUsernameAndPass($username, $password) {
    
    // CAMBIO CLAVE: Cambia la búsqueda a la columna 'nombre'
    $sql = "SELECT id_usuario, nombre, email, password_crypt, es_admin FROM usuarios WHERE nombre = ?";
    $user_data = array();

    try {
        $con = $this->conexion->open();

        // Prepara y ejecuta la consulta buscando por nombre
        $query = mysqli_prepare($con, $sql);
        mysqli_stmt_bind_param($query, "s", $username); // <-- Bind con el nombre
        mysqli_stmt_execute($query);
        $resultSet = mysqli_stmt_get_result($query);

        if ($row = mysqli_fetch_assoc($resultSet)) {
            $stored_hash = $row['password_crypt']; 

            // Usa password_verify para validar el hash BCrypt
            if (password_verify($password, $stored_hash)) {
                unset($row['password_crypt']); 
                $user_data[] = $row;
            }
        }
        $this->conexion->close($con);
    } catch (\Throwable $th) {
        error_log("Error al buscar usuario: " . $th->getMessage());
    }
    return $user_data;
}

}

?>