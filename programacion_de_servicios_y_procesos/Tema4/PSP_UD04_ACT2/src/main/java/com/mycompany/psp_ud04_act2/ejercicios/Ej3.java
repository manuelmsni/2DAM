/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act2.ejercicios;

import com.mycompany.psp_ud04_act2.view.VistaEj2;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.List;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author manuelmsni
 */
public class Ej3 {
    public static void main(String[] args){
        Thread servidorThread = new Thread(new Servidor(5000));
        servidorThread.start();
        
        Thread clienteThread1 = new Thread(new Cliente("127.0.0.1", 5000, "ClienteNum1"));
        clienteThread1.start();
        
        Thread clienteThread2 = new Thread(new Cliente("127.0.0.1", 5000, "ClienteNum2"));
        clienteThread2.start();
    }
    
    public static class Servidor implements Runnable {
        private DataInputStream in;
        private DataOutputStream out;
        private ServerSocket servidor;
        private Socket sc = null;
        private final int PORT;
        private List<Socket> clients;
        private List<Thread> hilos;

        public Servidor(int puerto) {
            clients = new ArrayList<>();
            hilos = new ArrayList<>();
            this.PORT = puerto;
        }

        @Override
        public void run() {
            try {
                servidor = new ServerSocket(PORT);
                while (true) {
                    Socket sc = servidor.accept();
                    ClienteHandler clienteHandler = new ClienteHandler(sc);
                    Thread thread = new Thread(clienteHandler);
                    hilos.add(thread);
                    thread.start();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        private class ClienteHandler implements Runnable {
            private Socket sc;
            private DataInputStream in;
            private DataOutputStream out;

            public ClienteHandler(Socket socket) {
                this.sc = socket;
            }

            @Override
            public void run() {
                try {
                    in = new DataInputStream(sc.getInputStream());
                    out = new DataOutputStream(sc.getOutputStream());

                    // Procesamiento específico del cliente
                    String nombreCliente = in.readUTF();
                    System.out.println("Recibida solicitud de cliente nombre: " + nombreCliente);

                    synchronized (clients) {
                        clients.add(sc);
                        out.writeUTF(String.valueOf(clients.size()));
                    }

                    sc.close();
                    System.out.println("Cliente " + nombreCliente + " desconectado.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
    public static class Cliente implements Runnable {
        private DataInputStream in;
        private DataOutputStream out;
        private Socket sc;
        private final String HOST;
        private final int PUERTO;
        private final String NOMBRE;
        
        public Cliente(String host, int puerto, String nombre) {
            HOST = host;
            PUERTO = puerto;
            NOMBRE = nombre;
        }

        @Override
        public void run() {
            try {
                System.out.println("Conectando con servidor IP:" + HOST + ", Puerto: " + PUERTO);
                sc = new Socket(HOST, PUERTO);
                System.out.println("Conectado!");
                
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                System.out.println("Enviando nombre...");
                out.writeUTF(NOMBRE);
                System.out.println("OK!");

                System.out.println("Recibiendo N de cliente…");
                System.out.println("Cliente conectado Nº: " + in.readUTF());
                
                System.out.println("fin conexión.");

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
