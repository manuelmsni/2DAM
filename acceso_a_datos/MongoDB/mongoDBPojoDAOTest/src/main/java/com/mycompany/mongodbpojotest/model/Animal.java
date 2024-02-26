/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mongodbpojotest.model;

import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author manuelmsni
 */
public class Animal {
    ObjectId id;
    String nombre;
    Especie especie;

    public Animal() {}

    public Animal(String nombre, Especie especie) {
        this.nombre = nombre;
        this.especie = especie;
    }

    public Animal(ObjectId id, String nombre, Especie especie) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
    }

    public ObjectId getId() {
        return id;
    }

    public Animal setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Animal setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Especie getEspecie() {
        return especie;
    }

    public Animal setEspecie(Especie especie) {
        this.especie = especie;
        return this;
    }

    @Override
    public String toString() {
        return "{\"id\":\"" + id.toString() + "\", \"nombre\":\"" + nombre + "\", \"especie\":\"" + especie.toString() + "\"}";
    }
    
    public static String formatearAnimales(List<Animal> animales){
        String ls = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(ls);
        sb.append("\t\"animales\" : [");
        for(int i = 0; i < animales.size(); i++){
            sb.append(ls);
            sb.append("\t\t");
            sb.append(animales.get(i).toString());
            if(i!=animales.size()-1){
                sb.append(",");
            }else{
                sb.append(ls);
                sb.append("\t");
            }
        }
        sb.append("]");
        sb.append(ls);
        sb.append("}");
        return sb.toString();
    }
}
