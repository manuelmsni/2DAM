/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_ud02_act1.ej9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author manuelmsni
 */
public class Ej9 {
    
    public static void main(String[] args){
        
        ProcessHandle abueloHandle = ProcessHandle.current();
        
        long miPid = abueloHandle.pid();
        long padrePid;

        System.out.println("Soy el proceso ABUELO " + miPid);
  
        Process padre = iniciarPadre(miPid);
        
        // Matar el proceso padre
        padre.destroy();
        
        // Obtener la salida del proceso
        InputStream inputStream = padre.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        
        padrePid = padre.pid();
        
        try {
            padre.waitFor();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        // Leer y mostrar la salida del proceso
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        System.out.println("Soy el proceso ABUELO " + miPid + "; Mi hijo: " + padrePid + " terminó.");
    }
    
    private static Process iniciarPadre(long miPid){
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-jar", "procesoPadre.jar", String.valueOf(miPid));
            return pb.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    } 
}
