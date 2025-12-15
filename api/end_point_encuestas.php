<?php

require "model_layer/EncuestaService.php"; // Ajusta la ruta si es necesario

$encuestaService = new EncuestaService();

$option = $_GET["option"] ?? die(json_encode(["error" => "Falta la opción de la API"]));

if ($option == "readAll") {
    // Leer todas las encuestas
    $result = $encuestaService->getAllEncuestas();
    
    if (count($result) > 0) {
        echo json_encode($result);
    } else {
        echo json_encode(["error" => "No se encontraron encuestas"]);
    }

} else if ($option == "findByName") {
    // Buscar por nombre
    $nombre = $_POST["nombre"] ?? die(json_encode(["error" => "Falta el nombre de la encuesta"]));
    
    $result = $encuestaService->getEncuestaPorNombre($nombre);
    if (count($result) > 0) {
        echo json_encode($result);
    } else {
        echo json_encode(["error" => "Encuesta no encontrada"]);
    }

} else if ($option == "create") {
    // Agregar encuesta
    $nombre = $_POST["nombre"] ?? die(json_encode(["error" => "Falta el nombre de la encuesta"]));
    // PHP maneja booleanos de POST como '1' o '0'
    $compleja = (int)($_POST["compleja"] ?? 0); 

    $result = $encuestaService->addEncuesta($nombre, $compleja);
    
    if ($result > 0) {
        echo json_encode(["success" => "Encuesta agregada correctamente"]);
    } else {
        echo json_encode(["error" => "Error al agregar encuesta"]);
    }
} else if ($option == "delete") {
    // 1. Obtiene el ID de POST
    $id_encuesta = $_POST["id_encuesta"] ?? die(json_encode(["error" => "Falta el ID de la encuesta"]));

    // 2. Llama al servicio
    $result = $encuestaService->deleteEncuesta($id_encuesta);
    
    // 3. Devuelve la respuesta
    if ($result > 0) {
        echo json_encode(["success" => "Encuesta eliminada correctamente"]);
    } else {
        echo json_encode(["error" => "Error al eliminar encuesta o no existe"]);
    }
}

?>