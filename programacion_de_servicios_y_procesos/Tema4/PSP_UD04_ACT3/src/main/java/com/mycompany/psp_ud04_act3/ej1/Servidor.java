/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act3.ej1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author manuelmsni
 */
public class Servidor extends Thread {
    private DatagramSocket servidor;
    private byte[] buffer;
    public Servidor(int puerto) {
        try {
            buffer = new byte[256];
            servidor = new DatagramSocket(puerto);
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
    }
    
    private void print(String msg){
        System.out.println(msg);
    }
    
    @Override
    public void run() {
        try {
            print("Iniciando servidor...");
            print("Ready!");
            print("Puerto " + servidor.getLocalPort() + " en escucha");
            while (servidor != null && !servidor.isClosed()){
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                servidor.receive(packet);
                attend(packet);
            }
            close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private String processCommand(String command) {
        switch (command) {
            case "getdate":
                return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            case "gethour":
                return new SimpleDateFormat("HH:mm:ss").format(new Date());
            default:
                if (command.startsWith("getmayus(\"") && command.endsWith("\")")) {
                    return command.substring(10, command.length() - 2).toUpperCase();
                }
                return "Comando no reconocido";
        }
    }
    
    private void attend(DatagramPacket packet){
        new Thread(() -> {
            try {
                String received = new String(packet.getData(), 0, packet.getLength());
                print("Recibido mensaje de \"" + packet.getAddress().getHostAddress() + "\": \"" + received + "\"");
                String response = processCommand(received);
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                byte[] responseData = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, address, port);
                servidor.send(responsePacket);
                print("Enviando respuesta: \"" + response + "\"");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }
    
    public void close(){
        if(servidor != null && !servidor.isClosed()){
            servidor.close();
            print("Socket del servidor cerrado.");
        }
    }
    
    public static void main(String[] args){
        Servidor s = new Servidor(Integer.valueOf(args[2]));
        s.start();
    }
}
