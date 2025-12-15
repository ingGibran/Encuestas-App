<?php

require "model_layer/PreguntaService.php"; // Ajusta la ruta

$preguntaService = new PreguntaService();

$option = $_GET["option"] ?? die(json_encode(["error" => "Falta la opción de la API"]));

if ($option == "readByEncuesta") {
    // Obtener preguntas por ID de Encuesta
    $id_encuesta = $_POST["id_encuesta"] ?? die(json_encode(["error" => "Falta el ID de la encuesta"]));
    
    $result = $preguntaService->getPreguntasPorEncuesta($id_encuesta);
    
    if (count($result) > 0) {
        echo json_encode($result);
    } else {
        echo json_encode(["error" => "No se encontraron preguntas para esta encuesta"]);
    }

} else if ($option == "findById") {
    // Obtener pregunta por ID
    $id_pregunta = $_POST["id_pregunta"] ?? die(json_encode(["error" => "Falta el ID de la pregunta"]));
    
    $result = $preguntaService->getPreguntaPorId($id_pregunta);
    if (count($result) > 0) {
        echo json_encode($result[0]); // Devuelve el objeto, no el array
    } else {
        echo json_encode(["error" => "Pregunta no encontrada"]);
    }

} else if ($option == "create") {
    // Agregar pregunta
    $texto = $_POST["texto"] ?? die(json_encode(["error" => "Falta el texto de la pregunta"]));
    $id_encuesta = $_POST["id_encuesta"] ?? die(json_encode(["error" => "Falta el ID de la encuesta"]));
    $es_principal = (int)($_POST["es_principal"] ?? 0); 
    $orden = (int)($_POST["orden"] ?? 0); 

    $result = $preguntaService->agregarPregunta($texto, $id_encuesta, $es_principal, $orden);
    
    if ($result > 0) {
        echo json_encode(["success" => "Pregunta agregada correctamente"]);
    } else {
        echo json_encode(["error" => "Error al agregar pregunta"]);
    }
} else if ($option == "delete") {
    // Eliminar pregunta
    $id_pregunta = $_POST["id_pregunta"] ?? die(json_encode(["error" => "Falta el ID de la pregunta"]));

    $result = $preguntaService->eliminarPregunta($id_pregunta);
    
    if ($result > 0) {
        echo json_encode(["success" => "Pregunta eliminada correctamente"]);
    } else {
        echo json_encode(["error" => "Error al eliminar pregunta"]);
    }
}

?>