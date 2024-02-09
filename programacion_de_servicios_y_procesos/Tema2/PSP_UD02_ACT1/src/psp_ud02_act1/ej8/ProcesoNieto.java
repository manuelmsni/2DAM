/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_ud02_act1.ej8;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vespertino
 */
public class ProcesoNieto {
    public static void main(String[] args){
        
        String padrePid = args[0];
        
        long miPid = ProcessHandle.current().pid();

        System.out.println("Soy el proceso NIETO " + miPid + "; Mi padre es = " + padrePid);

    }
}
