/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mongodbpojotest.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.mycompany.mongodbpojotest.model.Especie;
import com.mycompany.mongodbpojotest.persistence.MongoClientManager;
import com.mycompany.mongodbpojotest.util.Constants;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author manuelmsni
 */
public class EspecieDAO implements DAO<Especie> {
    
    private static EspecieDAO instance;
    
    private final MongoDatabase database;
    private final MongoCollection<Especie> especiesCollection;
    
    public EspecieDAO(){
        database = MongoClientManager.getInstance().getDatabase(Constants.DATABASE);
        especiesCollection = database.getCollection(Constants.ESPECIE_TABLE, Especie.class);
    }
    
    public static EspecieDAO getInstance(){
        if(instance == null) instance = new EspecieDAO();
        return instance;
    }

    @Override
    public List<Especie> obtenerTodos(){
        List<Especie> especies = new ArrayList<>();
        especiesCollection.find().forEach(especies::add);
        return especies;
    }
    
    @Override
    public void crear(Especie especie) {
        especiesCollection.insertOne(especie);
    }

    @Override
    public void borrar(ObjectId especieId) {
        especiesCollection.deleteOne(Filters.eq("_id", especieId));
    }
    
    @Override
    public void actualizar(Especie especie) {
        especiesCollection.replaceOne(eq("_id", especie.getId()), especie);
    }

    @Override
    public Especie obtener(ObjectId id) {
        return especiesCollection.find(Filters.eq("_id", id)).first();
    }

 
}
