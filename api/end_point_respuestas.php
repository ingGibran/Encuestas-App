<?php

require "model_layer/RespuestaService.php"; // Ajusta la ruta

$respuestaService = new RespuestaService();

$option = $_GET["option"] ?? die(json_encode(["error" => "Falta la opción de la API"]));

if ($option == "readByQuestionAndUser") {
    // Obtener una respuesta específica
    $id_pregunta = $_POST["id_pregunta"] ?? die(json_encode(["error" => "Falta el ID de la pregunta"]));
    $id_usuario = $_POST["id_usuario"] ?? die(json_encode(["error" => "Falta el ID del usuario"]));
    
    $result = $respuestaService->getRespuestaPorPreguntaYUsuario($id_pregunta, $id_usuario);
    
    if (count($result) > 0) {
        echo json_encode($result[0]); // Devuelve el objeto, no el array
    } else {
        echo json_encode(["error" => "Respuesta no encontrada"]);
    }

} else if ($option == "readBySurveyAndUser") {
    // Obtener todas las respuestas de un usuario para una encuesta
    $id_encuesta = $_POST["id_encuesta"] ?? die(json_encode(["error" => "Falta el ID de la encuesta"]));
    $id_usuario = $_POST["id_usuario"] ?? die(json_encode(["error" => "Falta el ID del usuario"]));
    
    $result = $respuestaService->getRespuestasPorEncuestaYUsuario($id_encuesta, $id_usuario);
    
    if (count($result) > 0) {
        echo json_encode($result);
    } else {
        echo json_encode(["error" => "No se encontraron respuestas para la encuesta"]);
    }

} else if ($option == "readByQuestion") {
    // Obtener todas las respuestas para una pregunta
    $id_pregunta = $_POST["id_pregunta"] ?? die(json_encode(["error" => "Falta el ID de la pregunta"]));
    
    $result = $respuestaService->getRespuestasPorPregunta($id_pregunta);
    
    if (count($result) > 0) {
        echo json_encode($result);
    } else {
        echo json_encode(["error" => "No se encontraron respuestas para la pregunta"]);
    }
    
} else if ($option == "create") {
    // Agregar respuesta
    $id_pregunta = $_POST["id_pregunta"] ?? die(json_encode(["error" => "Falta el ID de la pregunta"]));
    $id_usuario = $_POST["id_usuario"] ?? die(json_encode(["error" => "Falta el ID del usuario"]));
    $valor = (int)($_POST["valor"] ?? 0); 
    $orden = (int)($_POST["orden"] ?? 0); 

    try {
        $result = $respuestaService->agregarRespuesta($id_pregunta, $id_usuario, $valor, $orden);
        
        if ($result > 0) {
            echo json_encode(["success" => "Respuesta agregada correctamente"]);
        } else {
            echo json_encode(["error" => "Error al agregar respuesta"]);
        }
    } catch (Exception $e) {
        echo json_encode(["error" => $e->getMessage()]);
    }
    
} else if ($option == "delete") {
    // Eliminar respuesta
    $id_respuesta = $_POST["id_respuesta"] ?? die(json_encode(["error" => "Falta el ID de la respuesta"]));

    $result = $respuestaService->eliminarRespuesta($id_respuesta);
    
    if ($result > 0) {
        echo json_encode(["success" => "Respuesta eliminada correctamente"]);
    } else {
        echo json_encode(["error" => "Error al eliminar respuesta"]);
    }
}
?>