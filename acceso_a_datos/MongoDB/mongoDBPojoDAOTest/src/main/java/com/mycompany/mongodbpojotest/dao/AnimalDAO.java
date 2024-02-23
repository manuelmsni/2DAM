/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mongodbpojotest.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.mycompany.mongodbpojotest.model.Animal;
import com.mycompany.mongodbpojotest.persistence.MongoClientManager;
import com.mycompany.mongodbpojotest.util.Constants;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author manuelmsni
 */
public class AnimalDAO implements DAO<Animal> {
    
    private static AnimalDAO instance;
    
    private final MongoDatabase database;
    private final MongoCollection<Animal> animalesCollection;
    
    public AnimalDAO(){
        database = MongoClientManager.getInstance().getDatabase(Constants.DATABASE);
        animalesCollection = database.getCollection(Constants.ANIMAL_TABLE, Animal.class);
    }
    
    public static AnimalDAO getInstance(){
        if(instance == null) instance = new AnimalDAO();
        return instance;
    }
    
    @Override
    public List<Animal> obtenerTodos(){
        List<Animal> animales = new ArrayList<>();
        animalesCollection.find().forEach(animales::add);
        return animales;
    }
    
    @Override
    public void crear(Animal animal) {
        animalesCollection.insertOne(animal);
    }

    @Override
    public void borrar(ObjectId animalId) {
        animalesCollection.deleteOne(Filters.eq("_id", animalId));
    }
    
    @Override
    public void actualizar(Animal animal) {
        animalesCollection.replaceOne(eq("_id", animal.getId()), animal);
    }

    @Override
    public Animal obtener(ObjectId id) {
        return animalesCollection.find(Filters.eq("_id", id)).first();
    }
}
