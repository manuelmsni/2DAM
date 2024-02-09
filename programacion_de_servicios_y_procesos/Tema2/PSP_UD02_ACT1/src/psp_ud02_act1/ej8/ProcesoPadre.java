/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_ud02_act1.ej8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vespertino
 */
public class ProcesoPadre {
    
    public static void main(String[] args){
        
        String abueloPid = args[0];
        
        long miPid = ProcessHandle.current().pid();
        long nietoPid;

        System.out.println("Soy el proceso PADRE " + miPid + "; Mi padre es = " + abueloPid);
  
        Process nieto = iniciarNieto(miPid);
        
        // Obtener la salida del proceso
        InputStream inputStream = nieto.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        
        nietoPid = nieto.pid();
        
        try {
            nieto.waitFor(); // Esperar a que el proceso hijo termine
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
        }
        
        System.out.println("Soy el proceso PADRE " + miPid + "; Mi hijo: " + nietoPid + " terminó.");
    }
    
    private static Process iniciarNieto(long miPid){
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-jar", "ProcesoNieto.jar", String.valueOf(miPid));
            return pb.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
