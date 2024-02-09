/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.multihilos;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author manuelmsni
 */
public class Ej3 {
    
    private static Object lock;
    
    public static void main(String[] args){
        lock = new Object();
        new TicTac("TIC", lock).start();
        new TicTac("TAC", lock).start();
    }

    public static class TicTac extends Thread {
        private Object lock;
        public String name;
        public TicTac(String name, Object lock){
            this.name = name;
            this.lock = lock;
        }
        public void run(){
            while(!isInterrupted()){
                synchronized (lock) {
                    System.out.println(name);
                    lock.notify(); // Notifica al objeto de sincronización para despertar al otro hilo
                    try {
                        lock.wait(); // Espera a ser notificado por el otro hilo para continuar
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}
