/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act2.ejercicios.ej4packaje;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

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
            servidor = new ServerSocket(port, maxClients);
            print("Server Socket OK!");
            print("Waiting for clients... ");
            
            do{
                sc = servidor.accept();
                if(clients.size() < maxClients) attend(sc);
                else print("Client limit reached!");
            }while (servidor != null && !servidor.isClosed() && clients.size() < maxClients);
            
            close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void attend(Socket sc){
        new Thread(() -> {
            try {
                if(!clients.contains(sc)) clients.add(sc);
                print("---------------------");
                print("Client num " + clients.size() + " connected");
                print("Client HOST: " + sc.getInetAddress().getHostAddress());

                inS = new DataInputStream(sc.getInputStream());
                outS = new DataOutputStream(sc.getOutputStream());
                
                outS.writeUTF(initMsg);
                outS.writeUTF(String.valueOf(clients.size()));
                
                print("Client name: " + inS.readUTF());
                
                String command = inS.readUTF();
                String response = procesarComandoHora(command);
                outS.writeUTF(response);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
        
    }
    
    private static String procesarComandoHora(String command) {
        if (command.equalsIgnoreCase("echo %time%")) {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date();
            return formatter.format(date);
        } else {
            return "Comando no reconocido";
        }
    }
    
    public void close(){
        if(servidor != null && !servidor.isClosed()){
            try {
                servidor.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}