/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.repository;

import com.mycompany.api.model.User;

/**
 *
 * @author manuelmsni
 */
public interface UserRepository {
    /**
     * Devuelve un usuario por su id
     * @param id El id de usuario
     * @return El usuario con dicha id
     */
    public User getUser(int id);
}
