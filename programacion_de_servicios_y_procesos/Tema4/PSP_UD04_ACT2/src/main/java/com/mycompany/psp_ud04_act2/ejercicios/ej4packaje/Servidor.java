/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act2.ejercicios.ej4packaje;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuelmsni
 */
public class Servidor extends Thread {
    
    public static void main(String[] args){
        Servidor s = new Servidor(Integer.valueOf(args[0]), args[1], Integer.valueOf(args[2]));
        s.start();
    }
    
    private ServerSocket servidor = null;
    private Socket sc = null;
    private int port;
    private String initMsg;
    private int maxClients;
    private List<Socket> clients;
    private DataInputStream inS;
    private DataOutputStream outS;
    
    public Servidor(int puerto, String initMsg, int maxClients) {
        clients = new ArrayList<>();
        this.port = puerto;
        this.initMsg = initMsg;
        this.maxClients = maxClients;
        print("Init msg: " + this.initMsg);
        print("Max clients: " + this.maxClients);
        print("Port Number: " + port);
    }

    private void print(String msg){
        System.out.println(msg);
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

                    inS = new DataInputStream(sc.getInputStream());
                    outS = new DataOutputStream(sc.getOutputStream());

                    print("Client name: " + inS.readUTF());

                    outS.writeUTF(String.valueOf(clients.size()));

                } else {
                    print("Client limit reached!");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}