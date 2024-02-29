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
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author manuelmsni
 */
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
    
    public static MongoCollection getObjectCollection(){
        Class type = Object.class; // Tipo explícito de la clase a parsear
        return getCollection("examen","objetos", type);
    }
}
