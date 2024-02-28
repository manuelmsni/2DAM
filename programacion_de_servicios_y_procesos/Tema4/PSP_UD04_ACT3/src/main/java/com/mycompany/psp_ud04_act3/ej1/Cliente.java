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

    public Cliente(String address, int port) {
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
        System.out.println("Cliente: " + msg);
    }
    String[] commands = {"getdate", "gethour","getmayus()", "stop"};
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while(!socket.isClosed()){
            print("Introduce el comando: ");
            for(String s : commands){
                print(" - " + s);
            }
            command = sc.nextLine();
            print("Respuesta obtenida: " + sendCommand(command));
            if(command.equals("stop")){
                close();
            }
        }
    }

    public String sendCommand(String command) {
        try {
            buf = command.getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
            socket.send(packet);
            print("Comando enviado: " + command);
            buf = new byte[256];
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
}
