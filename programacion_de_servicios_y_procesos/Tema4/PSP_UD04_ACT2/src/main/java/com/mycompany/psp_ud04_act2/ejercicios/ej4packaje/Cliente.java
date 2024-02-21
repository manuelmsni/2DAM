/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act2.ejercicios.ej4packaje;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author manuelmsni
 */
public class Cliente extends Thread {
    
    public static void main(String[] args){
        Cliente c = new Cliente(args[0], Integer.valueOf(args[1]), args[2]);
        c.start();
    }
    
    private Socket sc = null;
    private String host;
    private int puerto;
    private String messaje;
    private DataInputStream inS;
    private DataOutputStream outS;

    public Cliente(String host, int puerto, String messaje) {
        this.host = host;
        this.puerto = puerto;
        this.messaje = messaje;
    }

    private void print(String msg){
        System.out.println(msg);
    }

    @Override
    public void run() {
        try {
            sc = new Socket(host, puerto);

            inS = new DataInputStream(sc.getInputStream());
            outS = new DataOutputStream(sc.getOutputStream());

            print("SERVER MSG: " + inS.readUTF());
            outS.writeUTF(messaje);
            print("CLIENT Nº: " + inS.readUTF());
            
            enviarComando();
            
            imprimeRespuesta();
            
            sc.close();
        } catch (IOException ex) {
            print("El servidor está cerrado!");
        }
    }
    
    private void enviarComando() throws IOException {
        outS.writeUTF("echo %time%");
    }
    
    private void imprimeRespuesta() throws IOException {
        print(inS.readUTF());
    }
}