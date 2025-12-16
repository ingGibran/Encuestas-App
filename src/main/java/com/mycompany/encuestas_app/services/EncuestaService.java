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

    private final String urlBase = "http://localhost/tap/encuestas_app/end_point_encuestas.php?option=";


    public List<Encuesta> getAllEncuestas() throws Exception {
        List<Encuesta> encuestas = new ArrayList<>();


        String results = Request.post(urlBase + "readAll")
                .execute()
                .returnContent().asString();

        System.out.println(results); 


        JSONParser parser = new JSONParser();
        JSONArray jArray = (JSONArray) parser.parse(results);


        for (int i = 0; i < jArray.size(); i++) {
            Encuesta e = new Gson().fromJson(
                    jArray.get(i).toString(), Encuesta.class);
            encuestas.add(e);
        }

        return encuestas;
    }


    public boolean addEncuesta(Encuesta encuesta) throws Exception {
        Form form = Form.form();
        form.add("nombre", encuesta.getNombre());

        form.add("compleja", encuesta.isCompleja() ? "1" : "0");

        String results = Request.post(urlBase + "create")
                .bodyForm(form.build()).execute()
                .returnContent().asString();

        System.out.println(results);

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

        if (results.contains("\"error\"")) {
            return null;
        }

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