package com.mycompany.encuestas_app.services;

import modelos.Usuario;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.apache.hc.client5.http.fluent.Form; 
import org.apache.hc.client5.http.fluent.Request; 
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class UsuarioService {
    
    private final String urlBase = "http://localhost/tap/encuestas_app/end_point_usuarios.php?option="; 
    
    
     public Usuario login(String email, String password) throws Exception {
        Usuario usuario = null;
        
        Form form = Form.form();
        form.add("email", email);
        form.add("password", password);
        
        String results = Request.post(urlBase + "login")
            .bodyForm(form.build())
            .execute()
            .returnContent().asString();
        
        System.out.println("Respuesta del servidor (login): " + results);
        
        if (results.contains("\"error\"")) {
            System.err.println("Error de login: " + results);
            return null; 
        }
        
        Gson gson = new Gson();
        usuario = gson.fromJson(results, Usuario.class);

        return usuario;
    }
    
    public boolean addUsr(Usuario user, String password) throws Exception {
        Form form = Form.form();
        form.add("nombre", user.getNombre());
        form.add("email", user.getEmail());
        form.add("password", password); 
        form.add("es_admin", user.isAdmin() ? "1" : "0"); 
        
        String results = Request.post(urlBase + "register")
            .bodyForm(form.build())
            .execute()
            .returnContent().asString();
        
        System.out.println("Respuesta del servidor (registro): " + results);
        
        return results.contains("success");
    }
    
    public Usuario getUsuarioPorNombre(String nombre) throws Exception {
        Usuario usuario = null;

        Form form = Form.form();
        form.add("nombre", nombre);
        
        String results = Request.post(urlBase + "findByName")
            .bodyForm(form.build())
            .execute()
            .returnContent().asString();
        
        System.out.println("Respuesta servidor (getUsuarioPorNombre): " + results);

        if (results.contains("\"error\"")) {
            return null;
        }
        
        Gson gson = new Gson();
        usuario = gson.fromJson(results, Usuario.class);

        return usuario;
    }

    public Usuario getUsuarioPorEmail(String email) throws Exception {
        Usuario usuario = null;

        Form form = Form.form();
        form.add("email", email);
        
        String results = Request.post(urlBase + "findByEmail")
            .bodyForm(form.build())
            .execute()
            .returnContent().asString();
        
        System.out.println("Respuesta servidor (getUsuarioPorEmail): " + results);

        if (results.contains("\"error\"")) {
            return null;
        }
        
        Gson gson = new Gson();
        usuario = gson.fromJson(results, Usuario.class);

        return usuario;
    }
    
    public String getIdUsuarioPorNombre(String nombre) throws Exception {
        Usuario usuario = null;

        Form form = Form.form();
        form.add("nombre", nombre);
        
        String results = Request.post(urlBase + "findByName")
            .bodyForm(form.build())
            .execute()
            .returnContent().asString();
        
        System.out.println("Respuesta servidor (getIdUsuarioPorNombre): " + results);

        if (results.contains("\"error\"")) {
            return null;
        }
        
        try {
            Gson gson = new Gson();
            usuario = gson.fromJson(results, Usuario.class);
            
            return usuario.getId();
            
        } catch (Exception e) {
            System.err.println("Error al parsear el usuario: " + e.getMessage());
            return null;
        }
    }
    
    public boolean createUsuario(Usuario user, String password) throws Exception {
        Form form = Form.form();
        form.add("nombre", user.getNombre());
        form.add("email", user.getEmail());
        form.add("password", password); 
        form.add("es_admin", user.isAdmin() ? "1" : "0"); 
        
        String results = Request.post(urlBase + "register")
            .bodyForm(form.build())
            .execute()
            .returnContent().asString();
        
        System.out.println("Respuesta servidor (createUsuario/register): " + results);
        
        return results.contains("success");
    }
   
    public List<Usuario> getAllUsers() throws Exception {
        List<Usuario> usuarios = new ArrayList<>();
        
        String results = Request.post(urlBase + "readAll")
            .execute()
            .returnContent().asString();
        
        System.out.println("Respuesta servidor (getAllUsers): " + results);
        
        if (results.contains("\"error\"")) {
            System.err.println("Error al obtener lista de usuarios: " + results);
            return usuarios; 
        }
        
        JSONParser parser = new JSONParser();
        JSONArray jArray = (JSONArray) parser.parse(results);
        
        Gson gson = new Gson();
        for (int i = 0; i < jArray.size(); i++) {
            Usuario u = gson.fromJson(
                jArray.get(i).toString(), Usuario.class
            );
            usuarios.add(u);
        }
        
        return usuarios;
    }
    
}