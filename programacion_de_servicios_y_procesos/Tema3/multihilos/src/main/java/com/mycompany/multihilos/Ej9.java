/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.multihilos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuelmsni
 */
public class Ej9 {

    private static List<File> files;
    
    public static void main(String[] args){
        files = new ArrayList();
        
        files.add(new File("assets/la_celestina"));
        files.add(new File("assets/el_quijote"));
        files.add(new File("assets/el_lazarillo_de_tormes"));
        
        new LectorSecuencial().run();
        new LectorAsincrono().start();
    }
    
    public static class LectorSecuencial extends Thread{
        private long timeStart;
        
        public LectorSecuencial(){}
        
        public void run(){
            timeStart = System.currentTimeMillis();

            files.forEach(f -> {
                new Lector(f).run();
            });
            
            long timeEnd = System.currentTimeMillis() - timeStart;
            
            System.out.println("La lectura secuencial tarda " + timeEnd + "ms");
        }
    }
    
    public static class LectorAsincrono extends Thread{
        private long timeStart;
        
        public LectorAsincrono(){}
        
        public void run(){
            timeStart = System.currentTimeMillis();
            
            List<Lector> hilos = new ArrayList<>();

            files.forEach(f -> {
                Lector lector = new Lector(f);
                hilos.add(lector);
                lector.start();
            });
            
            hilos.forEach( h -> {
                try {
                    h.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            
            long timeEnd = System.currentTimeMillis() - timeStart;
            System.out.println("La lectura asincrona tarda " + timeEnd + "ms");
        }
    }
    
    public static class Lector extends Thread{
        
        private int lines;
        public Lector(File f){
            lines = 0;
        }
        
        public void run(File f){
            FileReader fr = null;
            try {
                fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                do{
                    line = br.readLine();
                    if(line!=null)lines++;
                }
                while(line!=null);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    fr.close();
                } catch (IOException ex) {
                    Logger.getLogger(Ej9.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
