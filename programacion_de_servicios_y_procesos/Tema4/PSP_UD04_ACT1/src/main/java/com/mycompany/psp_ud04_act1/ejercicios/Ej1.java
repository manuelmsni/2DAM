/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act1.ejercicios;

import com.mycompany.psp_ud04_act1.controller.ControladorVista;
import com.mycompany.psp_ud04_act1.view.Vista;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

/**
 *
 * @author manuelmsni
 */
/**
 * Realiza un programa que admita desde la línea de comandos un nombre
 * de máquina o una dirección IP y visualice información sobre ella.
 */
public class Ej1 {
    private static final Logger log = Logger.getLogger(Ej1.class.getName());
    public Ej1(Vista v){
        try{
            InetAddress dir = InetAddress.getByName(v.solicitaString("Escribe el nombre del host"));
            v.imprime("HostName: " + dir.getHostName());
            v.imprime("CanonicalHostName: " + dir.getCanonicalHostName());
            v.imprime("HostAddress: " + dir.getHostAddress());
            v.imprime("¿Es local?: " + (dir.isSiteLocalAddress() ? "Si" : "No"));
            v.imprime("¿Es una dirección de bucle local?: " + (dir.isLoopbackAddress() ? "Si" : "No"));
        } catch (UnknownHostException uhe) {
            log.warning("" + uhe.getMessage());
        }
    }
}
