/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mongodbpojotest.model;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Vespertino
 */
public class Especie {
    ObjectId id;
    String nombre;
    List<Animal> animales;
    
    public Especie(){}

    public Especie(String nombre) {
        this.nombre = nombre;
        this.animales = new ArrayList<Animal>();
    }
    
    public Especie(String nombre, List<Animal> animales) {
        this.nombre = nombre;
        this.animales = animales;
    }

    public Especie(ObjectId id, String nombre, List<Animal> animales) {
        this.id = id;
        this.nombre = nombre;
        this.animales = animales;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(List<Animal> animales) {
        this.animales = animales;
    }
    
    @Override
    public String toString() {
        return "{\"_id\":\"" + id.toString() + "\", \"nombre\":\"" + nombre + "\", \"animales\":[" + formateaAnimales() + "]}";
    }
    
    private String formateaAnimales(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < animales.size(); i++){
            Animal a = animales.get(i);
            sb.append("{\"_id\":\"");
            sb.append(a.getId());
            sb.append("\", \"nombre\":\"");
            sb.append(a.getNombre());
            sb.append("\"}");
            if(i != animales.size() - 1);
        }
        return sb.toString();
    }
    
    public static String formatearEspecies(List<Especie> especies){
        String ls = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(ls);
        sb.append("\t\"especies\" : [");
        for(int i = 0; i < especies.size(); i++){
            sb.append(ls);
            sb.append("\t\t");
            sb.append(especies.get(i).toString());
            if(i!=especies.size()-1){
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
