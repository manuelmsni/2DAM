/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mongodbfirsttest.dao;

import com.mycompany.mongodbfirsttest.model.Usuario;
import com.mycompany.mongodbfirsttest.persistence.PersistenceMongoDB;
import com.mycompany.mongodbfirsttest.util.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author manuelmsni
 */
public class UsuarioDAO implements DAO<Usuario> {
    
    private static UsuarioDAO instance;
    
    public static UsuarioDAO getInstance(){
        if(instance == null) instance = new UsuarioDAO();
        return instance;
    }
    
    private String uri;
    private String database;
    private String table;
    PersistenceMongoDB persistence;
    
    private UsuarioDAO(){
        uri = Constants.DB_URI;
        database = Constants.USER_DATABASE;
        table = Constants.USER_TABLE;
        persistence = new PersistenceMongoDB(uri, database, table);
    }
    
    private String[] toArray(String... values){
        return values;
    }

    @Override
    public void crear(Usuario u) {
        try {
            String id = persistence.inserta(
                toArray("name",u.getNombre()),
                toArray("email",u.getCorreo())
            );
            u.setId(id);
        } catch (PersistenceMongoDB.CantInsertDocumentException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Usuario> obtenerTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            persistence.obtenTodosLosDocumentos().forEach(doc ->{
                usuarios.add(new Usuario()
                    .setId(doc.get("_id").toString())
                    .setNombre(doc.getString("name"))
                    .setCorreo(doc.getString("email")));
            });
        } catch (PersistenceMongoDB.CantGetDocumentsException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    @Override
    public void actualizar(Usuario u) {
        try {
            persistence.actualizaPorId(u.getId(),
                toArray("name", u.getNombre()),
                toArray("email", u.getCorreo()));
        } catch (PersistenceMongoDB.CantUpdateDocumentException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void borrar(String id) {
        try {
            persistence.eliminaPorId(id);
        } catch (PersistenceMongoDB.CantDeleteDocumentException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Usuario obtener(String id) {
        try {
            Document doc = persistence.obtenDocumentoPorId(id);
            return new Usuario(doc.get("_id").toString(), doc.getString("name"),doc.getString("email"));
        } catch (PersistenceMongoDB.CantGetDocumentFilteringException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Usuario obtenerPorNombre(String nombre) {
        try {
            Document doc = persistence.obtenDocumentoPorCampo("name",nombre);
            return new Usuario(doc.get("_id").toString(), doc.getString("name"),doc.getString("email"));
        } catch (PersistenceMongoDB.CantGetDocumentFilteringException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Usuario obtenerPorCorreo(String correo) {
        try {
            Document doc = persistence.obtenDocumentoPorCampo("email",correo);
            return new Usuario(doc.get("_id").toString(), doc.getString("name"),doc.getString("email"));
        } catch (PersistenceMongoDB.CantGetDocumentFilteringException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
