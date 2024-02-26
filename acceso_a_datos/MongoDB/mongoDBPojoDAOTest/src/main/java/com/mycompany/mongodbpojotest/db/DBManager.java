/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mongodbpojotest.db;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mycompany.mongodbpojotest.model.Animal;
import com.mycompany.mongodbpojotest.model.Especie;
import com.mycompany.mongodbpojotest.persistence.MongoClientManager;
import com.mycompany.mongodbpojotest.util.Constants;

/**
 *
 * @author manuelmsni
 */
public class DBManager {
    private static DBManager instance;
    
    private MongoDatabase database;
    private MongoCollection<Animal> animalesCollection;
    private MongoCollection<Especie> especiesCollection;
    
    private DBManager(){
        database = MongoClientManager.getInstance().getDatabase(Constants.DATABASE);
    }

    public static DBManager getInstance(){
        if(instance == null) instance = new DBManager();
        return instance;
    }
    
    public MongoCollection getAnimalesCollection(){
        if(animalesCollection == null) animalesCollection = database.getCollection(Constants.ANIMAL_TABLE, Animal.class);
        return animalesCollection;
    }
    
    public MongoCollection getEspeciesCollection(){
        if(especiesCollection == null) especiesCollection = database.getCollection(Constants.ESPECIE_TABLE, Especie.class);
        return especiesCollection;
    }
    
}
