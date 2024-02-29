/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mongodbpojotest.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.mycompany.mongodbpojotest.db.DBManager;
import com.mycompany.mongodbpojotest.model.Animal;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author manuelmsni
 */
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mycompany.mongodbpojotest.db.DBManager;
import com.mycompany.mongodbpojotest.model.Animal;
import com.mycompany.mongodbpojotest.model.Especie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author manuelmsni
 */
public class AnimalDAO implements DAO<Animal> {
    
    private static AnimalDAO instance;
    
    private final MongoCollection<Especie> especiesCollection;
    
    public AnimalDAO(){
        especiesCollection = DBManager.getInstance().getEspeciesCollection();
    }
    
    public static AnimalDAO getInstance(){
        if(instance == null) instance = new AnimalDAO();
        return instance;
    }
    
    @Override
    public List<Animal> obtenerTodos(){
        return especiesCollection.aggregate(
            Arrays.asList(
                Aggregates.unwind("$animales"),
                Aggregates.replaceRoot("$animales")
                ),
                Animal.class
        ).into(new ArrayList<>());
    }
    
    @Override
    public void crear(Animal animal) {
        animal.setId(new ObjectId());
        especiesCollection.updateOne(
                Filters.eq("_id", animal.getEspecie().getId()),
                Updates.push("animales", animal)
        );
    }
    
    @Override
    public Animal obtener(ObjectId id) {
        return especiesCollection.aggregate(
            Arrays.asList(
                Aggregates.match(Filters.eq("animales._id", id)),
                Aggregates.unwind("$animales"),
                Aggregates.match(Filters.eq("animales._id", id)),
                Aggregates.replaceRoot("$animales")
            ),
            Animal.class
        ).first();
    }
    
    @Override
    public void actualizar(Animal animal) {
        especiesCollection.updateOne(
            Filters.eq("animales._id", animal.getId()), 
            Updates.set("animales.$[elem]", animal),
            new UpdateOptions().arrayFilters(List.of(Filters.eq("elem._id", animal.getId())))
        );
    }

    @Override
    public void borrar(Animal animal) {
        especiesCollection.updateOne(
                Filters.eq("animales._id", animal.getId()), 
                Updates.pull("animales", new Document("_id", animal.getId()))
        );
    }

}