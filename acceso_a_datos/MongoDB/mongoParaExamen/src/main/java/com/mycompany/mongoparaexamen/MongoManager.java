/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mongoparaexamen;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author manuelmsni
 */
public class MongoManager {
    
    private static final String HOST = "localhost";
    private static final String PORT = "57017";
    private static final  String DB_URI = "mongodb://" + HOST + ":" + PORT;
    
    private static MongoClient client;
    
    private static MongoClient getClient(){
        if(client != null) return client;
        ConnectionString connectionString = new ConnectionString(DB_URI);
        client = MongoClients.create(connectionString);
        return client;
    }
    
    private static MongoDatabase getDatabase(String dbname){
        return getClient().getDatabase(dbname);
    }
    
    private static MongoCollection getCollection(String database, String name){
        return getDatabase(database).getCollection(name);
    }
    
    public static MongoCollection getObjectCollection(){
        return getCollection("examen","objetos");
    }
    
    public static List<Document> getAll(MongoCollection collection){
        List<Document> documents = new ArrayList<>();
        collection.find().into(documents);
        return documents;
    }
    
    public static boolean insert(MongoCollection collection, Document doc){
        try {
            collection.insertOne(doc);
            return true;
        } catch (Exception e) {
            System.out.println("Error al insertar un nuevo documento en la colección:");
            e.printStackTrace();
        }
        return false;
    }
    
    // filter es un documento con los criterios de búsqueda
    // update es un documento con los campos a actualizar (los que no tenga no se actualizan)
    private static boolean update(MongoCollection collection, Document filter, Document update){
        try {
            collection.updateMany(filter, new Document("$set", update));
            return true;
        } catch (Exception e) {
            System.out.println("Error al actualizar documentos en la colección:");
            e.printStackTrace();
            return false;
        }
    }
    
    // Cerrar al final de la aplicación (con mongo no tiene sentido tras cada operación)
    public static void close(){
        if(client!=null) client.close();
    }
}
