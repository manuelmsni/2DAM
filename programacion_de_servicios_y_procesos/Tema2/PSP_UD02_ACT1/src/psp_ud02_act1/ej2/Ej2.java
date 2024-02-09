/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_ud02_act1.ej2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author manuelmsni
 */
public class Ej2 {
        public static void main(String[] args){
        BufferedReader reader = null;
        try {
            
            String[] input = {"ipconfig"};
            Process process = Runtime.getRuntime().exec(input); // Lanza el proceso para obtener la información de IP

            
            InputStream inputStream = process.getInputStream(); // Obtiene el flujo de salida del proceso
            reader = new BufferedReader(new InputStreamReader(inputStream)); // 

            String line;
            while ((line = reader.readLine()) != null) { // Lee y muestra la salida del proceso
                System.out.println(line);
            }

            process.waitFor(); // Espera a que termine el proceso
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
