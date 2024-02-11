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
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuelmsni
 */
/**
 * Realiza un programa que pida una URL por teclado y muestre la siguiente información:
 *   ◦ Valores de los flags DoInput y DoOutput (buscar los getter)
 *   ◦ Valores de todos los campos de la cabecera posibles (bucle)
 *   ◦ Visualiza la cabecera a través de un mapa (Map)
 * 
 * Recuerda las excepciones IOexception en bufferReader y MalformedURLException en el constructor URL.
 */
public class Ej5 {
    private static final Logger log = Logger.getLogger(Ej5.class.getName());
    Vista v;
    public Ej5(Vista v){
        this.v = v;
        
        HttpURLConnection conn = establecerConexionURL(v.solicitaURL("Introduce la url: "));
        
        mostrarInformacionURL(conn);
        
        mostrarInformacionCabecera(conn);
    }

    private HttpURLConnection establecerConexionURL(URL url) {
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            return conn;
        } catch (IOException ex) {
            Logger.getLogger(Ej5.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private void mostrarInformacionURL(HttpURLConnection conn){
        if(conn == null) return;
        v.imprime("INPUT: " + conn.getDoInput());
        v.imprime("OUTPUT: " + conn.getDoOutput());
    }
    
    private void mostrarInformacionCabecera(HttpURLConnection conn){
        if(conn == null) return;
        Map<String, List<String>> headerFields = conn.getHeaderFields();
        v.imprime("Cabecera: ");
        int contador = 0;
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            v.imprime("HEADER " + contador++ + " => " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
