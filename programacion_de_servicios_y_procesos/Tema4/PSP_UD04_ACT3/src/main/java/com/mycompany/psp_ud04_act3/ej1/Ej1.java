/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act3.ej1;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Vespertino
 */
public class Ej1 {
    
    public static void main(String[] args){
        int puerto = 5002;
        System.out.println("Ej1");
        activateServer(puerto);
        newClient(puerto);
    }
    
    public static void activateServer(int portNumber){
        String classpath = System.getProperty("java.class.path");
        String className = "com.mycompany.psp_ud04_act3.ej1.Servidor";
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, className, String.valueOf(portNumber));
        pb.inheritIO();
        try {
            Process p = pb.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void newClient(int puerto){
        Cliente c = new Cliente("localhost", puerto);
        
        c.start();
    }
}
