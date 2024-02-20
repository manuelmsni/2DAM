/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act2.ejercicios;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author manuelmsni
 */
public class Ej5 {
    public static void main(String[] args) {
        String message = "Paquete de prueba 1";
        int destPort = 12345;
        String destIp = "192.168.1.5";
        try {
            byte[] messageBytes = message.getBytes();
            InetAddress destAddress = InetAddress.getByName(destIp);
            DatagramPacket packet = new DatagramPacket(messageBytes, messageBytes.length, destAddress, destPort);
            try (DatagramSocket socket = new DatagramSocket()) {
                System.out.println("Enviando un Paquete UDP..");
                socket.send(packet);
                System.out.println("Paquete enviado !!");
                System.out.println("Puerto origen del mensaje: " + socket.getLocalPort());
                System.out.println("IP de origen: " + InetAddress.getLocalHost().getHostAddress());
                System.out.println("Puerto destino del mensaje: " + destPort);
                // System.out.println("IP destino del mensaje: " + destAddress.getHostAddress());
            }
        }catch(UnknownHostException e){
            System.out.println("IP de origen no pudo ser determinada.");
        }catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }
}
