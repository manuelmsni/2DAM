/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act2.ejercicios;

import com.mycompany.psp_ud04_act2.view.VistaEj2;
import java.util.List;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author manuelmsni
 */
public class Ej2 {
    public static void main(String[] args){
        VistaEj2 v = new VistaEj2();
        v.setVisible(true);
    }
    
    public static class Servidor implements Runnable {
        private ServerSocket servidor = null;
        private Socket sc = null;
        private final int PORT;
        private final String INIT_MSG;
        private final int MAX_CLIENTS;
        private final List<Socket> CLIENTS;

        public Servidor(int puerto, String initMsg, int maxClients) {
            CLIENTS = new ArrayList<>();
            this.PORT = puerto;
            this.INIT_MSG = initMsg;
            this.MAX_CLIENTS = maxClients;
            System.out.println("Init msg: " + initMsg);
            System.out.println("Max clients: " + initMsg);
            System.out.println("Port Number: " + PORT);
        }

        @Override
        public void run() {
            try {
                System.out.println("Creating Server Socket...");
                servidor = new ServerSocket(PORT);
                System.out.println("Server Socket OK!");
                System.out.println("Waiting for clients... ");
                while (servidor != null && !servidor.isClosed()) {
                    if(CLIENTS.size() < MAX_CLIENTS){
                        sc = servidor.accept();
                        CLIENTS.add(sc);
                        System.out.println("Client connected");
                        System.out.println("Client HOST: " + sc.getInetAddress().getHostAddress());
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    public static class Cliente implements Runnable {
        private Socket sc = null;
        private final String HOST;
        private final int PUERTO;

        public Cliente(String host, int puerto) {
            this.HOST = host;
            this.PUERTO = puerto;
        }

        @Override
        public void run() {
            try {
                sc = new Socket(HOST, PUERTO);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
