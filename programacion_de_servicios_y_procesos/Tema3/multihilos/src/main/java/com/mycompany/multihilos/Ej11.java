/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.multihilos;

import static java.lang.Thread.sleep;
import java.util.Queue;
import java.util.LinkedList;

/**
 *
 * @author manuelmsni
 */
public class Ej11 {
    
    private static Object lock = new Object();
    
    private static Queue<String> colaDeStrings = new LinkedList<>();
    
    public static void main(String[] args){
        new ProducerTicTac("TIC", lock).start();
        synchronized (lock) {
            try {
                sleep(50);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        new ProducerTicTac("TAC", lock).start();
        synchronized (lock) {
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        new ConsumerTicTac(lock).start();
    }

    public static class ProducerTicTac extends Thread {
        
        private Object lock;
        
        public String name;
        public ProducerTicTac(String name, Object lock){
            this.name = name;
            this.lock = lock;
        }
        public void run(){
            while(!isInterrupted()){
                synchronized (lock) {
                    colaDeStrings.offer(name);
                    lock.notify(); // Notifica al objeto de sincronización
                    try {
                        lock.wait();
                    } catch (InterruptedException ex) {
                        System.out.println(name + " was interrupted!");
                    }
                }
            }
        }
    }
    
    public static class ConsumerTicTac extends Thread {
        private Object lock;
        public ConsumerTicTac(Object lock) {
            this.lock = lock;
        }
        public void run() {
            while (!isInterrupted()) {
                synchronized (lock) {
                    while (colaDeStrings.isEmpty()) {
                        try {
                            lock.notify();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Consumido: " + colaDeStrings.poll());
                }
            }
        }
    }
}
