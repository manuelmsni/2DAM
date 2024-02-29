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
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class MongoPojoManager {
    
    private static final String HOST = "localhost";
    private static final String PORT = "57017";
    private static final  String DB_URI = "mongodb://" + HOST + ":" + PORT;
    
    private static CodecRegistry codec;
    private static MongoClient client;
    
    private static MongoClient getClient(){
        if(client != null) return client;
        ConnectionString connectionString = new ConnectionString(DB_URI);
        client = MongoClients.create(connectionString);
        return client;
    }
    
    private static CodecRegistry getCodec(){
        if(codec != null) return codec;
        PojoCodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        codec = CodecRegistries.fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(), 
            CodecRegistries.fromProviders(pojoCodecProvider)
        );
        return codec;
    }
    
    private static MongoDatabase getDatabase(String dbname){
        return getClient().getDatabase(dbname).withCodecRegistry(getCodec());
    }
    
    private static <T> MongoCollection<T> getCollection(String database, String name, Class<T> type){
        return getDatabase(database).getCollection(name, type);
    }
    
    
    // Métodos crud para tipos genéricos
    
    public static <T> List<T> getAll(MongoCollection collection){
        List<T> list = new ArrayList<>();
        collection.find().into(list);
        return list;
    }
    
    public static <T> void insert(MongoCollection collection, T obj) {
        collection.insertOne(obj);
    }

    public static <T> void delete(MongoCollection collection, ObjectId idToDelete) {
       collection.deleteOne(Filters.eq("_id", idToDelete));
    }
    
    public static <T> void update(MongoCollection collection, ObjectId idToUpdate, T objToUpdate) {
       collection.replaceOne(Filters.eq("_id", idToUpdate), objToUpdate);
    }

    public static <T> T get(MongoCollection<T> collection, ObjectId idToFind) {
        return collection.find(Filters.eq("_id", idToFind)).first();
    }
    
    // Métodos crud para clases anidadas para tipos genéricos
    
    public static <T> List<T> getAllNested(MongoCollection<T> collection, String fieldName, Class<T> type){
        return collection.aggregate(
            Arrays.asList(
                Aggregates.unwind("$" + fieldName),
                Aggregates.replaceRoot("$" + fieldName)
                ),
                type
        ).into(new ArrayList<>());
    }
    
    public static <T> void insertNested(MongoCollection<T> collection, ObjectId parentId, String fieldName, T obj) {
        // TODO: que no se me olvide añadir id a obj antes de llamar a este método cuando haga el DAO
        collection.updateOne(
            Filters.eq("_id", parentId),
            Updates.push(fieldName, obj)
        );
    }
    
    public static <T> void actualizar(MongoCollection<T> collection, String fieldName, ObjectId idObjToUpdate, T objToUpdate) {
        collection.updateOne(
            Filters.eq(fieldName + "._id", idObjToUpdate), 
            Updates.set(fieldName + ".$[elem]", objToUpdate),
            new UpdateOptions().arrayFilters(List.of(Filters.eq("elem._id", idObjToUpdate)))
        );
    }
    
    public static <T> void borrar(MongoCollection<T> collection, String fieldName, ObjectId idObjToDelete) {
        collection.updateOne(
            Filters.eq(fieldName + "._id", idObjToDelete), 
            Updates.pull(fieldName, new Document("_id", idObjToDelete))
        );
    }
    
    public static <T> T getNested(MongoCollection<Document> collection, String fieldName, ObjectId id, Class<T> type) {
        return collection.aggregate(
            Arrays.asList(
                Aggregates.match(Filters.eq(fieldName + "._id", id)),
                Aggregates.unwind("$" + fieldName),
                Aggregates.match(Filters.eq(fieldName + "._id", id)),
                Aggregates.replaceRoot("$" + fieldName)
            ),
            type
        ).first();
    }
    
}
