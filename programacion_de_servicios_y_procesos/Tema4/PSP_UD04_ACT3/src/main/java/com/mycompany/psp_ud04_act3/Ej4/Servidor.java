/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act3.Ej4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuelmsni
 */
public class Servidor extends Thread {
    private int puerto;
    ServerSocket server;

    public Servidor(int puerto) {
        this.puerto = puerto;
    }

    public void iniciar() {
        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            server = serverSocket;
            start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void run(){
        System.out.println("Servidor iniciado en el puerto " + puerto);
        while (!server.isClosed()) {
            try {
                attend(server.accept());
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void attend(Socket client){
        new Thread(() -> {
            try (ObjectInputStream ois = new ObjectInputStream(client.getInputStream())) {
                Persona persona = (Persona) ois.readObject();
                System.out.println("Datos recibidos: " + persona);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }).start();
    }
}
