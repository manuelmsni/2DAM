/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act3.ej1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author manuelmsni
 */
public class Cliente extends Thread {
    private DatagramSocket socket;
    private InetAddress address;
    private int port;
    private byte[] buf;
    private String command;

    public Cliente(String address, int port, String command) {
        try {
            this.socket = new DatagramSocket();
            this.address = InetAddress.getByName(address);
            this.port = port;
            this.command = command;
        } catch (Exception e) {
            print("Error al inicializar el cliente: " + e.getMessage());
        }
    }
    
    private void print(String msg){
        System.out.println(msg);
    }
    
    @Override
    public void run() {
        sendCommand(command);
    }

    public String sendCommand(String command) {
        try {
            buf = command.getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
            socket.send(packet);
            print("Comando enviado: " + command);
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            String received = new String(packet.getData(), 0, packet.getLength());
            return received;
        } catch (IOException e) {
            return "Error al enviar o recibir el paquete: " + e.getMessage();
        }
    }

    public void close() {
        if(socket != null){
            socket.close();
            print("Socket del cliente cerrado.");
        }
    }
    
    public static void main(String[] args){
        Cliente c = new Cliente(args[0], Integer.valueOf(args[1]), args[2]);
        c.start();
    }
}
