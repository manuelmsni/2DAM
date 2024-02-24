/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act3.Ej4;

import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author manuelmsni
 */
public class Cliente {
    private String host;
    private int puerto;

    public Cliente(String host, int puerto) {
        this.host = host;
        this.puerto = puerto;
    }

    public void enviarDatos(Persona persona) {
        try (Socket socket = new Socket(host, puerto);
             ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {
            oos.writeObject(persona);
            System.out.println("Datos enviados al servidor.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
