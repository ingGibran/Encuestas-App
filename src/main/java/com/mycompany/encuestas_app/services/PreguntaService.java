package com.mycompany.encuestas_app.services;

import modelos.Pregunta;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.apache.hc.client5.http.fluent.Form;
import org.apache.hc.client5.http.fluent.Request;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

// ELIMINAR: import com.mycompany.encuestas_app.DatabaseConnection;
// ELIMINAR: import java.sql.*;

/**
 *
 * @author alexpy
 */
public class PreguntaService {
    
    private final String urlBase = "http://localhost/tap/encuestas_app/end_point_preguntas.php?option="; 
    
    // ELIMINAR: private DatabaseConnection db = new DatabaseConnection();

    
    public List<Pregunta> getPreguntasPorEncuesta(String id_encuesta) throws Exception {
        List<Pregunta> preguntas = new ArrayList<>();
        
        Form form = Form.form();
        form.add("id_encuesta", id_encuesta);
        
        String results = Request.post(urlBase + "readByEncuesta")
            .bodyForm(form.build()).execute()
            .returnContent().asString();
        
        System.out.println("Respuesta servidor (getPreguntasPorEncuesta): " + results);
        
        if (results.contains("\"error\"")) {
            System.err.println("Error al leer preguntas: " + results);
            return preguntas;
        }

        JSONParser parser = new JSONParser();
        JSONArray jArray = (JSONArray) parser.parse(results);
        
        Gson gson = new Gson();
        for (int i = 0; i < jArray.size(); i++) {
            Pregunta p = gson.fromJson(jArray.get(i).toString(), Pregunta.class);
            preguntas.add(p);
        }
        
        return preguntas;
    }

    public Pregunta getPreguntaPorId(String id_pregunta) throws Exception {
        Pregunta pregunta = null;

        Form form = Form.form();
        form.add("id_pregunta", id_pregunta);
        
        String results = Request.post(urlBase + "findById")
            .bodyForm(form.build()).execute()
            .returnContent().asString();
        
        System.out.println("Respuesta servidor (getPreguntaPorId): " + results);

        if (results.contains("\"error\"")) {
            System.err.println("Error al encontrar pregunta por ID: " + results);
            return null;
        }
        
        // El endpoint devuelve un solo objeto JSON
        Gson gson = new Gson();
        pregunta = gson.fromJson(results, Pregunta.class);

        return pregunta;
    }

    public boolean agregarPregunta(Pregunta pregunta) throws Exception {
        
        Form form = Form.form();
        form.add("texto", pregunta.getTexto());
        form.add("id_encuesta", pregunta.getId_encuesta());
        form.add("es_principal", pregunta.isEs_principal() ? "1" : "0");
        form.add("orden", String.valueOf(pregunta.getOrder()));
        
        String results = Request.post(urlBase + "create")
            .bodyForm(form.build()).execute()
            .returnContent().asString();
        
        System.out.println("Respuesta servidor (agregarPregunta): " + results);

        return results.contains("success");
    }
    
    public boolean eliminarPregunta(String id_pregunta) throws Exception {
        
        Form form = Form.form();
        form.add("id_pregunta", id_pregunta);
        
        String results = Request.post(urlBase + "delete")
            .bodyForm(form.build()).execute()
            .returnContent().asString();
        
        System.out.println("Respuesta servidor (eliminarPregunta): " + results);

        return results.contains("success");
    }
}