/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.multihilos;

/**
 *
 * @author manuelmsni
 */
public class Ej5 {

    public static void main(String[] args){
        HiloContador h1 = new HiloContador();
        h1.setPriority(1);
        
        HiloContador h2 = new HiloContador();
        h2.setPriority(5);
        
        HiloContador h3 = new HiloContador();
        h3.setPriority(10);
        
        h1.start();
        h2.start();
        h3.start();
        
        try {
            Thread.sleep(2000);
            h1.interrupt();
            h2.interrupt();
            h3.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Hilo 1: " + h1.getContador());
        System.out.println("Hilo 2: " + h2.getContador());
        System.out.println("Hilo 3: " + h3.getContador());
    }
    public static class HiloContador extends Thread{
        private int contador;
        public HiloContador(){
            contador = 0;
        }
        @Override
        public void run(){
            while(!isInterrupted()){
                contador++;
            }
        }
        public void stopHilo(){
            interrupt();
        }
        
        public int getContador(){
            return contador;
        }
    }
}
