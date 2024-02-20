package com.mycompany.psp_ud04_act2.ejercicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ej1 {
    
    public static void main(String[] args) {
        Thread servidorThread = new Thread(new Servidor(5000));
        servidorThread.start();
        
        Thread clienteThread = new Thread(new Cliente("127.0.0.1", 5000));
        clienteThread.start();
    }
    
    public static class Servidor implements Runnable {
        private ServerSocket servidor = null;
        private Socket sc = null;
        private DataInputStream in;
        private DataOutputStream out;
        private final int PUERTO;

        public Servidor(int puerto) {
            this.PUERTO = puerto;
        }

        @Override
        public void run() {
            try {
                servidor = new ServerSocket(PUERTO);
                System.out.println("Servidor iniciado");

                while (servidor != null && !servidor.isClosed()) {
                    sc = servidor.accept();
                    System.out.println("Cliente conectado");

                    in = new DataInputStream(sc.getInputStream());
                    out = new DataOutputStream(sc.getOutputStream());

                    String mensaje = in.readUTF();
                    
                    imprime(mensaje);
                    
                    out.writeUTF("SERVER ECHO: " + mensaje);

                    sc.close();
                    
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        public void imprime(String mensaje){
            System.out.println("Servidor: ");
            System.out.println("\t" + mensaje);
        }

        public void stop() {
            try {
                if (servidor != null && !servidor.isClosed()) {
                    servidor.close();
                    System.out.println("Servidor detenido");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static class Cliente implements Runnable {
        private Socket sc = null;
        private DataInputStream in;
        private DataOutputStream out;
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

                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                Scanner scanner = new Scanner(System.in);
                System.out.println("Introduce un mensaje: ");
                String mensaje = scanner.nextLine();

                out.writeUTF(mensaje);

                String mensajeDelServidor = in.readUTF();
                imprime(mensajeDelServidor);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        public void imprime(String mensaje){
            System.out.println("Cliente: ");
            System.out.println("\t" + mensaje);
        }

        public void stop() {
            try {
                if (sc != null && !sc.isClosed()) {
                    sc.close();
                    System.out.println("Cliente desconectado");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}