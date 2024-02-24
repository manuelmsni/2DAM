/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act3.ej3;

import java.io.IOException;

/**
 *
 * @author manuelmsni
 */
public class Ej3 {
    public static void main(String[] args){
        int serverPort = 60014;
        String serverAddress = "localhost";
        int multicastPort = 60015;
        String multicastAddress = "225.0.0.1";
        System.out.println("Ej2");
        activateServer(serverPort, multicastPort, multicastAddress);
        activateClient(serverPort, serverAddress,multicastPort, multicastAddress, "Juan");
        activateClient(serverPort, serverAddress,multicastPort, multicastAddress, "Pepe");
    }
    
    public static void activateClient(int serverPort, String serverAddress, int multicastPort, String multicastAddress, String name){
        ChatClient c1 = new ChatClient(serverAddress, serverPort, multicastAddress, multicastPort, name);
        c1.setVisible(true);
    }
    
    public static void activateServer(int serverPort, int multicastPort, String multicastAddress){
        String classpath = System.getProperty("java.class.path");
        String className = "com.mycompany.psp_ud04_act3.ej3.Servidor";
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, className,  String.valueOf(serverPort),String.valueOf(multicastPort), multicastAddress);
        pb.inheritIO();
        try {
            Process p = pb.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
