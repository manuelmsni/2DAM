/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mongodbpojotest.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mycompany.mongodbpojotest.db.DBManager;
import com.mycompany.mongodbpojotest.model.Especie;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author manuelmsni
 */
public class EspecieDAO implements DAO<Especie> {
    
    private static EspecieDAO instance;
    
    private final MongoCollection<Especie> especiesCollection;
    
    public EspecieDAO(){
        especiesCollection = DBManager.getInstance().getEspeciesCollection();
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
    public void borrar(Especie especie) {
        especiesCollection.deleteOne(Filters.eq("_id", especie.getId()));
    }
    
    @Override
    public void actualizar(Especie especie) {
        especiesCollection.replaceOne(Filters.eq("_id", especie.getId()), especie);
    }

    @Override
    public Especie obtener(ObjectId id) {
        return especiesCollection.find(Filters.eq("_id", id)).first();
    }

}