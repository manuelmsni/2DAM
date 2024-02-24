/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act3.ej2;

import java.io.IOException;

/**
 *
 * @author Vespertino
 */
public class Ej2 {
    public static void main(String[] args){
        int puerto = 6001;
        String groupAddress = "225.0.0.1";
        System.out.println("Ej2");
        activateClient(puerto, groupAddress);
        activateServer(puerto, groupAddress);
    }
    
    public static void activateServer(int portNumber, String groupAddress){
        String classpath = System.getProperty("java.class.path");
        String className = "com.mycompany.psp_ud04_act3.ej2.Servidor";
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, className, String.valueOf(portNumber), groupAddress);
        pb.inheritIO();
        try {
            Process p = pb.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void activateClient(int portNumber, String groupAddress){
        String classpath = System.getProperty("java.class.path");
        String className = "com.mycompany.psp_ud04_act3.ej2.Cliente";
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, className,  String.valueOf(portNumber), groupAddress);
        pb.inheritIO();
        try {
            Process p = pb.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
