package com.mycompany.encuestas_app.services;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import modelos.Encuesta;
import org.apache.hc.client5.http.fluent.Form;
import org.apache.hc.client5.http.fluent.Request;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class EncuestaService {

    // URL BASE de tu nuevo endpoint PHP
    private final String urlBase = "http://localhost/tap/encuestas_app/end_point_encuestas.php?option=";

    // El método getAllEncuestas
    public List<Encuesta> getAllEncuestas() throws Exception {
        List<Encuesta> encuestas = new ArrayList<>();

        // 1. Realizar la petición POST al endpoint PHP
        String results = Request.post(urlBase + "readAll")
                .execute()
                .returnContent().asString();

        System.out.println(results); // Para debugging

        // 2. Parsear el JSON de la respuesta
        JSONParser parser = new JSONParser();
        JSONArray jArray = (JSONArray) parser.parse(results);

        // 3. Convertir cada objeto JSON a un objeto Encuesta Java
        for (int i = 0; i < jArray.size(); i++) {
            Encuesta e = new Gson().fromJson(
                    jArray.get(i).toString(), Encuesta.class);
            encuestas.add(e);
        }

        return encuestas;
    }

    // El método addEncuesta
    public boolean addEncuesta(Encuesta encuesta) throws Exception {
        Form form = Form.form();
        form.add("nombre", encuesta.getNombre());
        // Enviar el booleano como '1' o '0'
        form.add("compleja", encuesta.isCompleja() ? "1" : "0");

        String results = Request.post(urlBase + "create")
                .bodyForm(form.build()).execute()
                .returnContent().asString();

        System.out.println(results);

        // El endpoint PHP devolverá un JSON con 'error' o 'success'
        return !results.contains("Error") && results.contains("success");
    }

    public Encuesta getEncuestaPorNombre(String nombre) throws Exception {
        Encuesta encuesta = null;

        Form form = Form.form();
        form.add("nombre", nombre);

        String results = Request.post(urlBase + "findByName")
                .bodyForm(form.build())
                .execute()
                .returnContent().asString();

        System.out.println("Respuesta servidor (getEncuestaPorNombre): " + results);

        // Si la respuesta contiene "error", significa que PHP no encontró la encuesta
        if (results.contains("\"error\"")) {
            return null;
        }

        // PHP devuelve un array, necesitamos parsear y tomar el primer elemento
        JSONParser parser = new JSONParser();
        JSONArray jArray = (JSONArray) parser.parse(results);

        if (jArray.size() > 0) {
            Gson gson = new Gson();
            encuesta = gson.fromJson(jArray.get(0).toString(), Encuesta.class);
        }

        return encuesta;
    }

    public boolean deleteEncuesta(String id_encuesta) throws Exception {

        Form form = Form.form();
        form.add("id_encuesta", id_encuesta);

        String results = Request.post(urlBase + "delete")
                .bodyForm(form.build()).execute()
                .returnContent().asString();

        System.out.println("Respuesta servidor (deleteEncuesta): " + results);

        return results.contains("success");
    }
}