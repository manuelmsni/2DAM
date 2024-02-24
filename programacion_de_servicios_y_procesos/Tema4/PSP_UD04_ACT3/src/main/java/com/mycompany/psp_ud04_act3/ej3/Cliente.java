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
import javax.swing.JTextArea;

/**
 *
 * @author manuelmsni
 */
public class Cliente extends Thread{
    private DatagramSocket socket;
    private InetAddress direccionServidor;
    private int puertoServidor;
    private InetAddress direccionMulticast;
    private int puertoMulticast;
    private MulticastSocket socketMulticast;
    private String nombreUsuario;
    private JTextArea output;

    public Cliente(String direccionServidor, int puertoServidor, String direccionMulticast, int puertoMulticast, String nombreUsuario, JTextArea output) {
        try {
            this.direccionServidor = InetAddress.getByName(direccionServidor);
            this.puertoServidor = puertoServidor;
            this.direccionMulticast = InetAddress.getByName(direccionMulticast);
            this.puertoMulticast = puertoMulticast;
            this.nombreUsuario = nombreUsuario;
            this.output = output;

            socket = new DatagramSocket();
            socketMulticast = new MulticastSocket(puertoMulticast);
            socketMulticast.joinGroup(this.direccionMulticast);

            new Thread(this::recibirMensajes).start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        recibirMensajes();
    }

    public void enviarMensaje(String mensaje) {
        try {
            String mensajeConUsuario = nombreUsuario + ": " + mensaje;
            byte[] buffer = mensajeConUsuario.getBytes();
            DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, direccionServidor, puertoServidor);
            socket.send(paquete);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void recibirMensajes() {
        byte[] buffer = new byte[1024];
        DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
        while (!socketMulticast.isClosed()) {
            try {
                socketMulticast.receive(paquete);
                String mensaje = new String(paquete.getData(), 0, paquete.getLength());
                output.append(mensaje + System.getProperty("line.separator"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void close(){
        if(socket != null && !socket.isClosed()){
            socket.close();
        }
        if(socketMulticast != null && !socketMulticast.isClosed()){
            socketMulticast.close();
        }
    }

}
