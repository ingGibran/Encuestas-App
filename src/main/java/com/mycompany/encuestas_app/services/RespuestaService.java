package com.mycompany.encuestas_app.services;

import modelos.Respuesta;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.apache.hc.client5.http.fluent.Form;
import org.apache.hc.client5.http.fluent.Request;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

// ELIMINAR: import com.mycompany.encuestas_app.DatabaseConnection;
// ELIMINAR: import java.sql.*;

public class RespuestaService {
        
    private final String urlBase = "http://localhost/tap/encuestas_app/end_point_respuestas.php?option="; 
        
    // ELIMINAR: private DatabaseConnection db = new DatabaseConnection();
        
    public Respuesta getRespuestaPorPreguntaYUsuario(String id_pregunta, String id_usuario) throws Exception {
        Respuesta respuesta = null;

        Form form = Form.form();
        form.add("id_pregunta", id_pregunta);
        form.add("id_usuario", id_usuario);
        
        String results = Request.post(urlBase + "readByQuestionAndUser")
            .bodyForm(form.build()).execute()
            .returnContent().asString();
        
        System.out.println("Respuesta servidor (getRespuestaPorPreguntaYUsuario): " + results);

        if (results.contains("\"error\"")) {
            System.err.println("Error al encontrar respuesta: " + results);
            return null;
        }
        
        // El endpoint devuelve un solo objeto JSON
        Gson gson = new Gson();
        respuesta = gson.fromJson(results, Respuesta.class);

        return respuesta;
    }
       
    public List<Respuesta> getRespuestasPorEncuestaYUsuario(String id_encuesta, String id_usuario) throws Exception {
        List<Respuesta> respuestas = new ArrayList<>();
        
        Form form = Form.form();
        form.add("id_encuesta", id_encuesta);
        form.add("id_usuario", id_usuario);
        
        String results = Request.post(urlBase + "readBySurveyAndUser")
            .bodyForm(form.build()).execute()
            .returnContent().asString();
        
        System.out.println("Respuesta servidor (getRespuestasPorEncuestaYUsuario): " + results);
        
        if (results.contains("\"error\"")) {
            System.err.println("Error al leer respuestas: " + results);
            return respuestas;
        }

        JSONParser parser = new JSONParser();
        JSONArray jArray = (JSONArray) parser.parse(results);
        
        Gson gson = new Gson();
        for (int i = 0; i < jArray.size(); i++) {
            Respuesta r = gson.fromJson(jArray.get(i).toString(), Respuesta.class);
            respuestas.add(r);
        }
        
        return respuestas;
    }
       
    public boolean agregarRespuesta(Respuesta respuesta) throws Exception {
        
        // El modelo Respuesta.java en tu proyecto contiene la lógica de validación (valor 1-5)
        // La validación también se agregó al servicio PHP como respaldo.
        if (respuesta.getValor() < 1 || respuesta.getValor() > 5) {
            throw new IllegalArgumentException("El valor de la respuesta debe estar entre 1 y 5");
        }
        
        Form form = Form.form();
        form.add("id_pregunta", respuesta.getId_pregunta());
        form.add("id_usuario", respuesta.getId_usuario());
        form.add("valor", String.valueOf(respuesta.getValor()));
        form.add("orden", String.valueOf(respuesta.getOrden()));
        
        String results = Request.post(urlBase + "create")
            .bodyForm(form.build()).execute()
            .returnContent().asString();
        
        System.out.println("Respuesta servidor (agregarRespuesta): " + results);

        return results.contains("success");
    }

    public boolean eliminarRespuesta(String id_respuesta) throws Exception {
        Form form = Form.form();
        form.add("id_respuesta", id_respuesta);
        
        String results = Request.post(urlBase + "delete")
            .bodyForm(form.build()).execute()
            .returnContent().asString();
        
        System.out.println("Respuesta servidor (eliminarRespuesta): " + results);

        return results.contains("success");
    }
    
    
    public List<Respuesta> getRespuestasPorPregunta(String id_pregunta) throws Exception {
        
        List<Respuesta> respuestas = new ArrayList<>();
        
        Form form = Form.form();
        form.add("id_pregunta", id_pregunta);
        
        String results = Request.post(urlBase + "readByQuestion")
            .bodyForm(form.build()).execute()
            .returnContent().asString();
        
        System.out.println("Respuesta servidor (getRespuestasPorPregunta): " + results);
        
        if (results.contains("\"error\"")) {
            System.err.println("Error al leer respuestas: " + results);
            return respuestas;
        }

        JSONParser parser = new JSONParser();
        JSONArray jArray = (JSONArray) parser.parse(results);
        
        Gson gson = new Gson();
        for (int i = 0; i < jArray.size(); i++) {
            Respuesta r = gson.fromJson(jArray.get(i).toString(), Respuesta.class);
            respuestas.add(r);
        }
        
        return respuestas;
    }
        
}