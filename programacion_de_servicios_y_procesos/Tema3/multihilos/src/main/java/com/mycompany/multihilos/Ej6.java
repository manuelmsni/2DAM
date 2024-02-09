/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.multihilos;

/**
 *
 * @author manuelmsni
 */
public class Ej6 {
    public static void main(String[] args) {
        MensajeContinuo h1= new MensajeContinuo();
        h1.start();
        try {
            Thread.sleep(5000);
            h1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static class MensajeContinuo extends Thread {
        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    System.out.println("Son las 4 am, quiero acabar ya T.T");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Se ha interrumpido");
            }
        }
    }
}
