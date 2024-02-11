/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act1.ejercicios;

import com.mycompany.psp_ud04_act1.view.Vista;
import java.net.InetAddress;
import java.util.logging.Logger;

/**
 *
 * @author manuelmsni
 */
/**
 * Realiza un programa que obtenga en un objeto InetAddress con el Host local,
 * y muestre la información relativa al nombre del Host,
 * su dirección IP y el método toString del objeto creado:
 * 
 *  • Crea un objeto de la clase InetAddress
 *  • Asígnale la información relativa al host local (recuerda que puede haber excepción)
 *  • Usa los métodos necesarios
 */
public class Ej2 {
    private static final Logger log = Logger.getLogger(Ej2.class.getName());
    public Ej2(Vista v){
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            v.imprime("HOST NAME: " + localHost.getHostName());
            v.imprime("IP ADDRESS: " + localHost.getHostAddress());
            v.imprime("toString METHOD: " + localHost.toString());
        } catch (Exception e) {
            log.warning("Error al obtener la información del host: " + e.getMessage());
        }
    }
}
