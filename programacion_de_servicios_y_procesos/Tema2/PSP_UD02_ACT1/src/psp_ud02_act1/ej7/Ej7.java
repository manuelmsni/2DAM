/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_ud02_act1.ej7;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author manuelmsni
 */
public class Ej7 {
    public static void main(String[] args) {
        try {
            ProcessBuilder processBuilder = null;
            // Obtener el sistema operativo
            String sistemaOperativo = System.getProperty("os.name").toLowerCase();

            // Crear el nombre del archivo dependiendo del sistema operativo
            String nombreArchivo = "";
            if (sistemaOperativo.contains("win")) {
                nombreArchivo = System.getenv("USERPROFILE") + "\\Desktop\\procesosDelSistema.txt";
                processBuilder = new ProcessBuilder("tasklist");
            } else if (sistemaOperativo.contains("nix") || sistemaOperativo.contains("nux")) {
                nombreArchivo = System.getProperty("user.home") + "/Desktop/procesosDelSistema.txt";
                processBuilder = new ProcessBuilder("ps", "-e");
            } else {
                System.out.println("Sistema operativo no soportado");
                System.exit(1);
            }
            
            if(processBuilder != null){
                // Redirigir la salida del proceso a un archivo
                File archivo = new File(nombreArchivo);
                processBuilder.redirectOutput(archivo);

                // Ejecutar el proceso
                Process proceso = processBuilder.start();
                proceso.waitFor();

                // Informar al usuario sobre la ubicación del archivo
                System.out.println("Archivo de procesos creado en: " + nombreArchivo);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
