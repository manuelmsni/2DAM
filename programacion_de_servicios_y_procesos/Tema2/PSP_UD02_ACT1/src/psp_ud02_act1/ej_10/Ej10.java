/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_ud02_act1.ej_10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuelmsni
 */
public class Ej10 {
    public static void main(String[] args) {
        try {
            // Comando para obtener los servicios bajo svchost.exe en Windows
            String comando = "tasklist /FI \"IMAGENAME eq svchost.exe\" /SVC | findstr /i \"svchost.exe\" > SVCHOST.TXT";
            
            // Crear un proceso para ejecutar el comando
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", comando);
            
            // Redirigir la salida a un archivo
            processBuilder.redirectErrorStream(true);
            
            // Ejecutar el proceso
            Process process = processBuilder.start();
            
            // Esperar a que el proceso termine
            process.waitFor();
            
            System.out.println("Servicios de svchost.exe guardados en SVCHOST.TXT");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
