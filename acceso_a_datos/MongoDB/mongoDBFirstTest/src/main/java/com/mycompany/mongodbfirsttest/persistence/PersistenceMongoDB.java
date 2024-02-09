/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mongodbfirsttest.persistence;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.model.Filters;
import com.mycompany.mongodbfirsttest.MongoDBFirstTest;
import com.mycompany.mongodbfirsttest.util.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Vespertino
 */
public class PersistenceMongoDB {
    
    private static final Logger log = Logger.getLogger(MongoDBFirstTest.class.getName());
    
    private class CantCountUsersException extends Exception{
    
    }
    private class CantInsertUserException extends Exception{
    
    }
    private class CantGetUsersException extends Exception{
    
    }
    private class CantGetUserException extends Exception{
    
    }
    private class CantGetUsersFilteringException extends Exception{
    
    }
    
    
    
    public long cuentaUsuarios() throws CantCountUsersException{
        try(MongoClient mc = MongoClients.create(Constants.DB_URI)){
            var db = mc.getDatabase("test");
            var col = db.getCollection("usuarios");
            return col.countDocuments();
        } catch(Exception e){
            log.warning("Ha habido un error estableciendo la conexión: " + e.getMessage());
            throw new CantCountUsersException();
        }
    }
    
    public String insertaUsuario(Document user) throws CantInsertUserException{
        try(MongoClient mc = MongoClients.create(Constants.DB_URI)){
            var db = mc.getDatabase("test");
            var col = db.getCollection("usuarios");
            var result =  col.insertOne(user);
            return result.getInsertedId().asBinary().toString();
        } catch(Exception e){
            log.warning("Ha habido un error estableciendo la conexión: " + e.getMessage());
            throw new CantInsertUserException();
        }
    }
    
    public List<Document> obtenUsuarios() throws CantGetUsersException{
        List<Document> usuarios = new ArrayList<>();
        try(MongoClient mc = MongoClients.create(Constants.DB_URI)){
            mc.getDatabase("test")
              .getCollection("usuarios")
              .find()
              .forEach(doc -> {usuarios.add(doc);});
            return usuarios;
        } catch(Exception e){
            log.warning("Ha habido un error estableciendo la conexión: " + e.getMessage());
            throw new CantGetUsersException();
        }
    }
    
    public Document obtenUsuarioPorId(String id) throws CantGetUserException{
        try(MongoClient mc = MongoClients.create(Constants.DB_URI)){
            return mc.getDatabase("test")
                     .getCollection("usuarios")
                     .find(Filters.eq("_id",id)).first();
        } catch(Exception e){
            log.warning("Ha habido un error estableciendo la conexión: " + e.getMessage());
            throw new CantGetUserException();
        }
    }
    
    public List<Document> obtenUsuariosFiltrando(Bson filter) throws CantGetUsersFilteringException{
        List<Document> usuarios = new ArrayList<>();
        try(MongoClient mc = MongoClients.create(Constants.DB_URI)){
            mc.getDatabase("test")
                .getCollection("usuarios")
                .find(filter).forEach(doc -> {usuarios.add(doc);});
            return usuarios;
        } catch(Exception e){
            log.warning("Ha habido un error estableciendo la conexión: " + e.getMessage());
            throw new CantGetUsersFilteringException();
        }
    }
    
    public List<Document> obtenUsuariosPorNombre(String nombre) throws CantGetUsersFilteringException{
        Bson filtro = Filters.eq("nombre", nombre);
        return obtenUsuariosFiltrando(filtro);
    }
    
}
