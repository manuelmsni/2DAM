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
public class Cliente {
    private MulticastSocket socket;
    private InetAddress grupo;
    private int puerto;
    private static final int BUFFER_SIZE = 1024; // Tamaño del buffer para recibir el mensaje

    public Cliente(int puerto, String groupAddress) {
        this.puerto = puerto;
        try {
            grupo = InetAddress.getByName(groupAddress);
            socket = new MulticastSocket(puerto);
            socket.joinGroup(grupo); 
            System.out.println("Cliente unido al grupo " + groupAddress);
            receiveMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receiveMessage() {
        byte[] buffer = new byte[BUFFER_SIZE];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        try {
            socket.receive(packet); 
            String msg = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Mensaje recibido: " + msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            socket.leaveGroup(grupo);
            socket.close(); 
            System.out.println("Cliente cerrado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("Uso: java Cliente <dirección multicast> <puerto>");
            return;
        }
        Cliente cliente = new Cliente(Integer.parseInt(args[0]), args[1]);
        cliente.receiveMessage(); // Recibir un mensaje para el ejemplo
        cliente.close(); // Cerrar el cliente después de recibir un mensaje
    }
}
