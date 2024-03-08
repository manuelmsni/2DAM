/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.repository;

/**
 *
 * @author manuelmsni
 */
public abstract class UserRepository {
    /**
     * Devuelve un usuario por su id
     * @param id El id de usuario
     */
    public abstract void getUser(int id);
}
