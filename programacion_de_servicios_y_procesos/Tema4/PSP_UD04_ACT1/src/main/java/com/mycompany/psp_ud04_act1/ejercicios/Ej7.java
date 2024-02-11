/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act1.ejercicios;

import com.mycompany.psp_ud04_act1.view.Vista;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

import java.util.logging.Logger;

/**
 *
 * @author manuelmsni
 */
/**
 * Realiza un programa que usando la clase URLConnection envíe los datos requeridos por el php (nombre y apellidos).
 * Para ello:
 *   • Crear un objeto URL al script que queremos conectar “http://localhost/php/ejemplo.php”
 *   • Establecer la comunicacion con la URL obteniendo el objeto URLConnection correspondiente.
 *   • Configurar la conexión para permitir el envío de datos (setDoOutput)
 *   • Una forma de enviar los datos es a través de un objeto PrintWriter pasándole en el constructor 
 *     el Stream de salida obtenido por getOutputStream() del objeto URLConnection (Los parámetros se pasan con &: &nombre=”nombre”)
 *   • Para recibir los datos del php de vuelta, utilizar el inputStreamReader como en el ejemplo anterior
 *   • Recuerda las excepciones y cerrar los flujos de entrada y salida una vez usados.
 */
public class Ej7 {
    
    private static final Logger log = Logger.getLogger(Ej7.class.getName());
    
    Vista v;
    
    public Ej7(Vista v){
        this.v = v;
        enviarDatos("Manuel", "Martín Santamaría");
    }
    
    public void enviarDatos(String nombre, String apellidos) {
        String urlStr = "http://localhost/php/ejemplo.php";
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            String parametros = "nombre=" + URLEncoder.encode(nombre, "UTF-8") +
                                 "&apellidos=" + URLEncoder.encode(apellidos, "UTF-8");
            try (PrintWriter out = new PrintWriter(conn.getOutputStream())) {
                out.print(parametros);
            }

            StringBuilder respuesta = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String linea;
                while ((linea = in.readLine()) != null) {
                    respuesta.append(linea);
                }
            }

            v.imprime("Respuesta del servidor: " + respuesta.toString());

        } catch (MalformedURLException e) {
            log.warning("La URL es incorrecta: " + e.getMessage());
        } catch (IOException e) {
            log.warning("Error de IO: " + e.getMessage());
        }
    }

}
