/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.multihilos;

/**
 *
 * @author manuelmsni
 */
public class Ej1 {

    private static Thread hilo1;
    private static Thread hilo2;
    private static Thread hilo3;
                
    public static void main(String[] args) {
        hilo1 = new HiloContador(1);
        hilo2 = new HiloContador(2);
        hilo3 = new HiloContador(3);
        ejecutaSecuencialmente();
    }
    
    // Ejecutar secuencialmente
    // Espera a que acabe uno para continuar con la ejecución del siguiente
    private static void ejecutaSecuencialmente(){
        try {
            hilo1.start();
            hilo1.join();

            hilo2.start();
            hilo2.join();

            hilo3.start();
            hilo3.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
    
    // Ejecutar en paralelismo o de forma concurrente
    // Se mezcla la salida
    private static void ejecutaConcurrenemente(){
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
    
    public static class HiloContador extends Thread{
        public int contador;
        public int id;
        public HiloContador(int id){
            contador = 0;
            this.id = id;
            System.out.println("Creando hilo " + id);
        }
        @Override
        public void run(){
            for(int i = 1; i <= 5; i++){
                System.out.println("Contador " + id + ": va por " + contador + ";");
                contador++;
            }
            System.out.println("El hilo " + id + " ha terminado.");
        }
    }
}
