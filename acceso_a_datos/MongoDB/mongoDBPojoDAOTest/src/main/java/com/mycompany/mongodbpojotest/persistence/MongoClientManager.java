/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mongodbpojotest.persistence;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mycompany.mongodbpojotest.util.Constants;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author Vespertino
 */
public class MongoClientManager {
    
    public static MongoClientManager instance;
    
    private MongoClient mongoClient;
    private CodecRegistry pojoCodecRegistry;
    
    public MongoClientManager(){
        ConnectionString connectionString = new ConnectionString(Constants.DB_URI);
        PojoCodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        pojoCodecRegistry = CodecRegistries.fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(), CodecRegistries.fromProviders(pojoCodecProvider)
        );
        mongoClient = MongoClients.create(connectionString);
    }
    
    public static MongoClientManager getInstance(){
        if(instance == null) instance = new MongoClientManager();
        return instance;
    }
    
    public MongoClient getClient(){
        return mongoClient;
    }
    
    public MongoDatabase getDatabase(String dbname){
        return mongoClient.getDatabase(dbname).withCodecRegistry(pojoCodecRegistry);
    }
    
}
