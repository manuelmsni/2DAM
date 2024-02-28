/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act3.ej2;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author manuelmsni
 */
public class Servidor{
    private MulticastSocket servidor;
    private byte[] buffer;
    private int puerto;
    private InetAddress grupo;
    
    
    public Servidor(int puerto, String groupAddress) {
        this.puerto = puerto;
        try {
            print("Iniciando servidor...");
            servidor = new MulticastSocket();
            grupo = InetAddress.getByName(groupAddress);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void print(String msg){
        System.out.println("Servidor: " + msg);
    }
    
    public void run() {
        try {
            print("Ready!");
            sendMessaje("Hola");
            close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void sendMessaje(String msg) throws IOException{
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.length(), grupo, puerto);
        servidor.send(packet);
    }
    
    public void close(){
        if(servidor != null && !servidor.isClosed()){
            servidor.close();
            print("Socket del servidor cerrado.");
        }
    }
    
    public static void main(String[] args){
        Servidor s = new Servidor(Integer.valueOf(args[0]), args[1]);
        s.run();
    }
}
