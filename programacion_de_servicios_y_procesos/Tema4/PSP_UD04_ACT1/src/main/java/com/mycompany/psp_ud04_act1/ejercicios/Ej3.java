/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act1.ejercicios;

import com.mycompany.psp_ud04_act1.view.Vista;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuelmsni
 */
/**
 * Modifica el programa anterior para que obtenga la información a través
 * del nombre del host y añade una línea con la forma canónica del nombre.
 * 
 *  • Modifícalo para que obtenga la IP de google visualiza las diferencias.
 *  • Modifícalo para que obtenga la IP de un nombre de Host o dirección de internet introducido por teclado.
 *  • Devuelve un array con las IPs de todas las interfaces de red getAllByNamee(String host).
 */
public class Ej3 {
    private static final Logger log = Logger.getLogger(Ej3.class.getName());
    private Vista v;
    public Ej3(Vista v){
        this.v = v;
        parteUno();
        parteDos();
        parteTres();
    }
    
    private void parteUno(){
        v.imprime("\n Parte 1:");
        printByHostName("www.google.com");
    }
    
    private void parteDos(){
        v.imprime("\n Parte 2:");
        printByHostName(v.solicitaString("Introduce el nombre del host"));
    }
    
    private void parteTres(){
        v.imprime("\n Parte 3:");
        var interfacesDeRed = getAllByNamee(v.solicitaString("Introduce el nombre del host"));
        for(InetAddress i: interfacesDeRed){
            printByHostName(i.getHostName());
        }
    }
    
    private static InetAddress[] getAllByNamee(String host){
        try {
            return InetAddress.getAllByName(host);
        } catch (UnknownHostException e) {
            log.warning("Error al obtener la información del host: " + e.getMessage());
        }
        return null;
    }
    
    private void printByHostName(String hostName){
        try {
            InetAddress localHost = InetAddress.getByName(hostName);
            v.imprime("HOST NAME: " + localHost.getHostName());
            v.imprime("Canonical HOST NAME: " + localHost.getCanonicalHostName());
            v.imprime("IP ADDRESS: " + localHost.getHostAddress());
            v.imprime("toString METHOD: " + localHost.toString());
        } catch (Exception e) {
            log.warning("Error al obtener la información del host: " + e.getMessage());
        }
    }
}
