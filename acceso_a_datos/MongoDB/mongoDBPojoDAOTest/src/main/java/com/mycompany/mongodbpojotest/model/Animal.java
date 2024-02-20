/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mongodbfirsttest.model;

import com.mycompany.mongodbfirsttest.dao.AnimalDAO;
import java.util.List;

/**
 *
 * @author manuelmsni
 */
public class Animal {
    String id;
    String nombre;
    String especie;

    public Animal() {
    }

    public Animal(String nombre, String especie) {
        this.nombre = nombre;
        this.especie = especie;
    }

    public Animal(String id, String nombre, String especie) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
    }

    public String getId() {
        return id;
    }

    public Animal setId(String id) {
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

    public String getEspecie() {
        return especie;
    }

    public Animal setEspecie(String especie) {
        this.especie = especie;
        return this;
    }

    @Override
    public String toString() {
        return "{\"id\":\"" + id + "\", \"nombre\":\"" + nombre + "\", \"especie\":\"" + especie + "\"}";
    }
    
    public static String formatearUsuarios(List<Animal> animales){
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
