<?php
// Asegúrate de ajustar la ruta al archivo de servicio
require "model_layer/UsuarioService.php"; 

$usuarioService = new UsuarioService();

// Verifica que la opción GET exista, si no, devuelve un error JSON
$option = $_GET["option"] ?? die(json_encode(["error" => "Falta la opción de la API"]));


if ($option == "login") {
    // 1. Obtiene los datos POST, si faltan, devuelve error JSON
    $email = $_POST["email"] ?? die(json_encode(["error" => "Falta el email"]));
    $pass = $_POST["password"] ?? die(json_encode(["error" => "Falta la contraseña"]));

    // 2. Llama al servicio
    $result = $usuarioService->findUsrByEmailAndPass($email, $pass);
    
    // 3. Devuelve la respuesta en JSON
    if (count($result) > 0) {
        $user_data = $result[0];
        
        $user_data['es_admin'] = (bool)$user_data['es_admin']; 

        echo json_encode($user_data); // Devuelve el objeto con el booleano correcto
    } else {
        echo json_encode(["error" => "Usuario o contraseña incorrectos"]);
    }
} else if ($option == "register") {
    // 1. Obtiene los datos POST
    $nombre = $_POST["nombre"] ?? die(json_encode(["error" => "Falta el nombre"]));
    $email = $_POST["email"] ?? die(json_encode(["error" => "Falta el email"]));
    $pass = $_POST["password"] ?? die(json_encode(["error" => "Falta la contraseña"]));
    // Convierte 'true'/'false' de Java/JS/POST en 1/0 para el service PHP
    $es_admin = (int)($_POST["es_admin"] ?? 0); 

    // 2. Llama al servicio
    $result = $usuarioService->addUsr($nombre, $email, $pass, $es_admin);

    // 3. Devuelve la respuesta en JSON
    if ($result > 0) {
        echo json_encode(["success" => "Usuario registrado correctamente"]);
    } else {
        echo json_encode(["error" => "Error al registrar usuario"]);
    }
} else if ($option == "findByName") {
    $nombre = $_POST["nombre"] ?? die(json_encode(["error" => "Falta el nombre de usuario"]));
    
    $result = $usuarioService->getUsuarioPorNombre($nombre);
    
    if (count($result) > 0) {
        // Encontrado, devuelve el objeto
        echo json_encode($result[0]); 
    } else {
        // No encontrado
        echo json_encode(["error" => "Usuario no encontrado"]);
    }
} else if ($option == "findByEmail") {
    $email = $_POST["email"] ?? die(json_encode(["error" => "Falta el email"]));
    
    $result = $usuarioService->getUsuarioPorEmail($email);
    
    if (count($result) > 0) {
        // Encontrado, devuelve el objeto
        echo json_encode($result[0]); 
    } else {
        // No encontrado
        echo json_encode(["error" => "Email no encontrado"]);
    }
} else if ($option == "readAll") {
    // Llama al servicio para obtener todos los usuarios
    $result = $usuarioService->getAllUsers();
    
    // Devuelve la respuesta en JSON
    if (count($result) > 0) {
        echo json_encode($result); // Devuelve el array completo
    } else {
        echo json_encode(["error" => "No se encontraron usuarios"]);
    }
}

?>