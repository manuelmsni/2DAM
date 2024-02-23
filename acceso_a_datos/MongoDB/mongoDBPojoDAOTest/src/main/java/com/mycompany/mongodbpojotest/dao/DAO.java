/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mongodbpojotest.dao;

import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author manuelmsni
 * @param <T>
 */
public interface DAO<T> {
    void crear(T objeto);
    List<T> obtenerTodos();
    void actualizar(T objeto);
    void borrar(ObjectId id);
    T obtener(ObjectId id);
}
