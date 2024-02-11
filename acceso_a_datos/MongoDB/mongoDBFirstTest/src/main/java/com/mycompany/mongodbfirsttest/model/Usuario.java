/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mongodbfirsttest.model;

import com.mycompany.mongodbfirsttest.dao.UsuarioDAO;
import java.util.List;

/**
 *
 * @author manuelmsni
 */
public class Usuario {
    String id;
    String nombre;
    String correo;

    public Usuario() {
    }

    public Usuario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public Usuario(String id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getId() {
        return id;
    }

    public Usuario setId(String id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Usuario setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getCorreo() {
        return correo;
    }

    public Usuario setCorreo(String correo) {
        this.correo = correo;
        return this;
    }

    @Override
    public String toString() {
        return "{\"id\":\"" + id + "\", \"nombre\":\"" + nombre + "\", \"correo\":\"" + correo + "\"}";
    }
    
    public static String formatearUsuarios(List<Usuario> usuarios){
        String ls = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(ls);
        sb.append("\t\"usuarios\" : [");
        for(int i = 0; i < usuarios.size(); i++){
            sb.append(ls);
            sb.append("\t\t");
            sb.append(usuarios.get(i).toString());
            if(i!=usuarios.size()-1){
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
