/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act2.ejercicios;

import com.mycompany.psp_ud04_act2.view.Ej4VistaSevidor;
import java.util.List;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuelmsni
 */
public class Ej4 {
    public static void main(String[] args){
        Ej4VistaSevidor v = new Ej4VistaSevidor();
        v.setVisible(true);
    }
    
    public static class Servidor implements Runnable {
        private ServerSocket servidor = null;
        private Socket sc = null;
        private int port;
        private String initMsg;
        private int maxClients;
        private List<Socket> clients;
        private OutputStream out;

        public Servidor(int puerto, String initMsg, int maxClients, OutputStream out) {
            clients = new ArrayList<>();
            this.port = puerto;
            this.initMsg = initMsg;
            this.maxClients = maxClients;
            print("Init msg: " + this.initMsg);
            print("Max clients: " + this.maxClients);
            print("Port Number: " + port);
        }
        
        private void print(String msg){
            for(Byte b :msg.getBytes()){
                try {
                    out.write(b);
                } catch (IOException ex) {
                    Logger.getLogger(Ej4.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        @Override
        public void run() {
            try {
                print("Creating Server Socket...");
                servidor = new ServerSocket(port);
                print("Server Socket OK!");
                print("Waiting for clients... ");
                while (servidor != null && !servidor.isClosed()) {
                    if(clients.size() < maxClients){
                        sc = servidor.accept();
                        clients.add(sc);
                        print("Client connected");
                        print("Client HOST: " + sc.getInetAddress().getHostAddress());
                    } else {
                        print("Client limit reached!");
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    public static class Cliente implements Runnable {
        private Socket sc = null;
        private String host;
        private int puerto;
        private String messaje;
        private OutputStream out;

        public Cliente(String host, int puerto, String messaje, OutputStream out) {
            this.host = host;
            this.puerto = puerto;
            this.messaje = messaje;
            this.out = out;
        }
        
        private void print(String msg){
            for(Byte b :msg.getBytes()){
                try {
                    out.write(b);
                    
                } catch (IOException ex) {
                    Logger.getLogger(Ej4.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        @Override
        public void run() {
            try {
                sc = new Socket(host, puerto);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
