/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act1.ejercicios;

import com.mycompany.psp_ud04_act1.view.Vista;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import java.util.logging.Logger;

/**
 *
 * @author manuelmsni
 */
/**
 * Realizar un programa que se conecte al html creado anteriormente, utilizando los métodos de URLConnection.
 * Además, en la salida del programa deben aparecer los siguientes elementos:
 *   • Dirección + [método]: valor
 *   • Fecha de última modificación + [método]: valor
 *   • Tipo de contenido + [método]: valor
 *   • Todos los campos de la cabecera + [método]: valores cada uno en una línea y tipo: valor
 *   • Los campos de la cabecera 1 y 4: + [método]: valor  cada uno en una línea
 *   • Contenido de + [método]: valor
 * 
 * Para recorrer una estructura Map podemos usar una estructura Iterator.
 * Para obtener un iterador sobre el map se invoca a los métodos entrySetO e iteratorO.
 * Para mover el iterador utilizaremos el método nextO y para comprobar si ha llegado al final usamos el método hasNextO.
 * De la estructura recuperaremos los valores mediante getKey(), para la clave y getValue(), para el valor.
 */
public class Ej8 {
    
    private static final Logger log = Logger.getLogger(Ej8.class.getName());
    
    Vista v;
    
    public Ej8(Vista v){
        this.v = v;
        analizaHtml();
    }
    
    private void analizaHtml(){
        String urlString = "http://localhost/php/index.html";
        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();

            v.imprime("Dirección [getURL()]: " + conn.getURL());
            v.imprime("Fecha de última modificación [getLastModified()]: " + conn.getLastModified());
            v.imprime("Tipo de contenido [getContentType()]: " + conn.getContentType());
            Map<String, List<String>> headerFields = conn.getHeaderFields();
            v.imprime("Todos los campos de la cabecera [getHeaderFields()]:");
            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                v.imprime("\t" + entry.getKey() + ": " + entry.getValue());
            }
            
            v.imprime("Los campos de la cabecera 1 y 4: ");

            v.imprime("\t[getHeaderFieldKey(1)]: " + conn.getHeaderFieldKey(1));
            v.imprime("\t\t[getHeaderField(1)]: " + conn.getHeaderField(1));
            
            v.imprime("\t[getHeaderFieldKey(4)]: " + conn.getHeaderFieldKey(4));
            v.imprime("\t\t[getHeaderField(4)]: " + conn.getHeaderField(4));

            v.imprime("Contenido [getInputStream()]:");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                v.imprime(inputLine);
            }
            in.close();

        } catch (MalformedURLException e) {
            log.severe("URL mal formada: " + e.getMessage());
        } catch (IOException e) {
            log.severe("Error de E/S: " + e.getMessage());
        }
    }
}
