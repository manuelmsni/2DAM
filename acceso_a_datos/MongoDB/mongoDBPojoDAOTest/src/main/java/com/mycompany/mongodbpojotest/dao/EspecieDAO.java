/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mongodbfirsttest.dao;

import com.mycompany.mongodbfirsttest.model.Animal;
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
public class AnimalDAO implements DAO<Animal> {
    
    private static AnimalDAO instance;
    
    public static AnimalDAO getInstance(){
        if(instance == null) instance = new AnimalDAO();
        return instance;
    }
    
    private String uri;
    private String database;
    private String table;
    PersistenceMongoDB persistence;
    
    private AnimalDAO(){
        uri = Constants.DB_URI;
        database = Constants.USER_DATABASE;
        table = Constants.USER_TABLE;
        persistence = new PersistenceMongoDB(uri, database, table);
    }
    
    private String[] toArray(String... values){
        return values;
    }

    @Override
    public void crear(Animal u) {
        try {
            String id = persistence.inserta(
                toArray("name",u.getNombre()),
                toArray("especie",u.getEspecie())
            );
            u.setId(id);
        } catch (PersistenceMongoDB.CantInsertDocumentException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Animal> obtenerTodos() {
        List<Animal> usuarios = new ArrayList<>();
        try {
            persistence.obtenTodosLosDocumentos().forEach(doc ->{
                usuarios.add(new Animal()
                    .setId(doc.get("_id").toString())
                    .setNombre(doc.getString("name"))
                    .setEspecie(doc.getString("especie")));
            });
        } catch (PersistenceMongoDB.CantGetDocumentsException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    @Override
    public void actualizar(Animal u) {
        try {
            persistence.actualizaPorId(u.getId(),
                toArray("name", u.getNombre()),
                toArray("especie", u.getEspecie()));
        } catch (PersistenceMongoDB.CantUpdateDocumentException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void borrar(String id) {
        try {
            persistence.eliminaPorId(id);
        } catch (PersistenceMongoDB.CantDeleteDocumentException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Animal obtener(String id) {
        try {
            Document doc = persistence.obtenDocumentoPorId(id);
            return new Animal(doc.get("_id").toString(), doc.getString("name"),doc.getString("especie"));
        } catch (PersistenceMongoDB.CantGetDocumentFilteringException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Animal obtenerPorNombre(String nombre) {
        try {
            Document doc = persistence.obtenDocumentoPorCampo("name",nombre);
            return new Animal(doc.get("_id").toString(), doc.getString("name"),doc.getString("especie"));
        } catch (PersistenceMongoDB.CantGetDocumentFilteringException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Animal obtenerPorEspecie(String especie) {
        try {
            Document doc = persistence.obtenDocumentoPorCampo("especie",especie);
            return new Animal(doc.get("_id").toString(), doc.getString("name"),doc.getString("especie"));
        } catch (PersistenceMongoDB.CantGetDocumentFilteringException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
