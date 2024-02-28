/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act3.ej3;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuelmsni
 */
public class Servidor{
    private DatagramSocket socketServidor;
    private MulticastSocket socketMulticast;
    private byte[] buffer;
    
    private int puertoServidor;
    private int puertoMulticast;
    private InetAddress direccionMulticast;
    
    
    public Servidor(int puertoServidor, int puertoMulticast, String direccionMulticast) {
        this.puertoServidor = puertoServidor;
        this.puertoMulticast = puertoMulticast;
        try {
            
            print("Iniciando servidor...");
            socketServidor = new DatagramSocket(puertoServidor);
            print("Puerto " + puertoServidor + " a la escucha...");
            
            print("Iniciando chat...");
            socketMulticast = new MulticastSocket();
            this.direccionMulticast = InetAddress.getByName(direccionMulticast);
            socketMulticast.joinGroup(this.direccionMulticast);
            print("Grupo de difusión abierto en " + direccionMulticast + ":" + puertoMulticast + ".");
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void print(String msg){
        System.out.println("Servidor: " + msg);
    }
    
    String[] banedWords = {"caca", "feo"};
    
    // Comprueba si el mensaje tiene palabras malsonantes
    // Lo del filtro no lo pedías pero era una prueba que quería hacer
    private boolean containsBadWords(String msg){
        for(String s : banedWords){
            if(msg.contains(s)) return true;
        }
        return false;
    }
    
    public void run() {
        try {
            print("Ready!");
            countdown();
            while(!socketServidor.isClosed()){
                String msg = reciveMessaje();
                if(!containsBadWords(msg)) sendMessaje(msg);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public String reciveMessaje() throws IOException{
        buffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
        socketServidor.receive(receivePacket);
        return new String(receivePacket.getData(), 0, receivePacket.getLength());
    }
    
    public void sendMessaje(String msg) throws IOException{
        String hourMsg = "[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] " + msg;
        DatagramPacket packet = new DatagramPacket(hourMsg.getBytes(), hourMsg.length(), direccionMulticast, puertoMulticast);
        socketMulticast.send(packet);
    }
    
    private void countdown(){
        new Thread(() -> {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
                close();
        }).start();
    }
    
    public void close(){
        if(socketMulticast != null && !socketMulticast.isClosed()){
            socketMulticast.close();
            print("Socket del grupo de difusión cerrado.");
        }
        if(socketServidor != null && !socketServidor.isClosed()){
            socketServidor.close();
            print("Socket del servidor cerrado.");
        }
    }
    
    public static void main(String[] args){
        Servidor s = new Servidor(Integer.valueOf(args[0]), Integer.valueOf(args[1]), args[2]);
        s.run();
    }

    private Object SimpleDateFormat(String hHmmss) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
