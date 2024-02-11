/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act1.ejercicios;

import com.mycompany.psp_ud04_act1.view.Vista;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

/**
 *
 * @author manuelmsni
 */
/**
 * Realiza un programa que pida un URL por teclado y muestre su contenido (en html):
 *  • Crea un objeto de la clase URL a partir de los datos de entrada
 *  • Utiliza el método openStream()
 *  • Para leer el inputStream devuelto por openStream(), puedes hacer los siguiente:
 *      ◦ Crear un bufferReader al cual le pasaremos un InputStreamReader sobre el inputStream obtenido
 *      ◦ Leer el bucle y mostrar por pantalla el bufferReader mientras su readLine() no sea nulo
 *      ◦ Cerrar el bufferReader con .close();
 *  • Recuerda las excepciones IOexception en bufferReader y MalformedURLException en el constructor URL
 */
public class Ej4 {
    private static final Logger log = Logger.getLogger(Ej4.class.getName());
    Vista v;
    public Ej4(Vista v){
        this.v = v;
        mostrarContenidoURL(v.solicitaURL("Introduce la url: "));
    }

    private void mostrarContenidoURL(URL url) {
        // Al usar try-with-resources se llama al método close() de forma automática
        try (InputStream inputStream = url.openStream(); BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                v.imprime(linea);
            }
        } catch (IOException e) {
            log.warning("Error al leer el contenido del URL: " + e.getMessage());
        }
    }
}
