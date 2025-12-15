package com.mycompany.encuestas_app.services;

import modelos.Usuario;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.apache.hc.client5.http.fluent.Form; // Necesitas la librería Apache HttpClient Fluent
import org.apache.hc.client5.http.fluent.Request; // Necesitas la librería Apache HttpClient Fluent
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
// ELIMINAR: import com.mycompany.encuestas_app.DatabaseConnection; 
// ELIMINAR: import java.sql.*; 
// ELIMINAR O AJUSTAR: El resto de tus imports de SQL

public class UsuarioService {
    
    // CAMBIAR: Ahora apunta al endpoint PHP
    private final String urlBase = "http://localhost/tap/encuestas_app/end_point_usuarios.php?option="; 
    
    // ELIMINAR: private DatabaseConnection db = new DatabaseConnection();
    
     public Usuario login(String email, String password) throws Exception {
        Usuario usuario = null;
        
        // 1. Prepara los datos para la petición POST
        Form form = Form.form();
        form.add("email", email);
        form.add("password", password);
        
        // 2. Ejecuta la petición y obtiene la respuesta JSON como String
        String results = Request.post(urlBase + "login")
            .bodyForm(form.build())
            .execute()
            .returnContent().asString();
        
        System.out.println("Respuesta del servidor (login): " + results);
        
        // 3. Verifica si hay un error en la respuesta JSON
        if (results.contains("\"error\"")) {
            // Manejar el error de login
            System.err.println("Error de login: " + results);
            return null; 
        }
        
        // 4. Deserializa el JSON a un objeto Usuario
        // Nota: El endpoint PHP devuelve un solo objeto Usuario, no un array (a diferencia del ejemplo de la práctica).
        Gson gson = new Gson();
        usuario = gson.fromJson(results, Usuario.class);

        return usuario;
    }
    
    public boolean addUsr(Usuario user, String password) throws Exception {
        // 1. Prepara los datos para la petición POST
        Form form = Form.form();
        form.add("nombre", user.getNombre());
        form.add("email", user.getEmail());
        // Pasamos la contraseña en texto plano para que PHP la encripte
        form.add("password", password); 
        // Pasamos el booleano como 1 o 0
        form.add("es_admin", user.isAdmin() ? "1" : "0"); 
        
        // 2. Ejecuta la petición y obtiene la respuesta JSON como String
        String results = Request.post(urlBase + "register")
            .bodyForm(form.build())
            .execute()
            .returnContent().asString();
        
        System.out.println("Respuesta del servidor (registro): " + results);
        
        // 3. Verifica si la respuesta contiene "success"
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

        // Si la respuesta contiene "error", significa que PHP no encontró el usuario
        if (results.contains("\"error\"")) {
            return null;
        }
        
        // Deserializa el objeto Usuario encontrado
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

        // Si la respuesta contiene "error", significa que PHP no encontró el email
        if (results.contains("\"error\"")) {
            return null;
        }
        
        // Deserializa el objeto Usuario encontrado
        Gson gson = new Gson();
        usuario = gson.fromJson(results, Usuario.class);

        return usuario;
    }
    
    public String getIdUsuarioPorNombre(String nombre) throws Exception {
        Usuario usuario = null;

        Form form = Form.form();
        form.add("nombre", nombre);
        
        // Hacemos la llamada al endpoint PHP que busca por nombre
        String results = Request.post(urlBase + "findByName")
            .bodyForm(form.build())
            .execute()
            .returnContent().asString();
        
        System.out.println("Respuesta servidor (getIdUsuarioPorNombre): " + results);

        // Si la respuesta contiene "error", significa que PHP no encontró el usuario
        if (results.contains("\"error\"")) {
            return null;
        }
        
        // Deserializa el objeto Usuario encontrado
        try {
            Gson gson = new Gson();
            usuario = gson.fromJson(results, Usuario.class);
            
            // Retorna el ID del objeto Usuario
            return usuario.getId();
            
        } catch (Exception e) {
            // Manejar un posible error de deserialización si el JSON no es el esperado
            System.err.println("Error al parsear el usuario: " + e.getMessage());
            return null;
        }
    }
    
    public boolean createUsuario(Usuario user, String password) throws Exception {
        // 1. Prepara los datos para la petición POST
        Form form = Form.form();
        form.add("nombre", user.getNombre());
        form.add("email", user.getEmail());
        // Se envía la contraseña en texto plano para que PHP la encripte
        form.add("password", password); 
        // Se envía el booleano como 1 o 0
        form.add("es_admin", user.isAdmin() ? "1" : "0"); 
        
        // 2. Ejecuta la petición y obtiene la respuesta JSON como String
        String results = Request.post(urlBase + "register")
            .bodyForm(form.build())
            .execute()
            .returnContent().asString();
        
        System.out.println("Respuesta servidor (createUsuario/register): " + results);
        
        // 3. Verifica si la respuesta contiene "success"
        return results.contains("success");
    }
   
    public List<Usuario> getAllUsers() throws Exception {
        List<Usuario> usuarios = new ArrayList<>();
        
        // 1. Ejecuta la petición GET/POST simple al endpoint 'readAll'
        String results = Request.post(urlBase + "readAll")
            .execute()
            .returnContent().asString();
        
        System.out.println("Respuesta servidor (getAllUsers): " + results);
        
        if (results.contains("\"error\"")) {
            System.err.println("Error al obtener lista de usuarios: " + results);
            return usuarios; // Devuelve lista vacía en caso de error
        }
        
        // 2. Parsear el JSON Array de la respuesta
        JSONParser parser = new JSONParser();
        JSONArray jArray = (JSONArray) parser.parse(results);
        
        // 3. Convertir cada objeto JSON a un objeto Usuario Java
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