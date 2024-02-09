/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act1.controller;

import com.mycompany.psp_ud04_act1.ejercicios.Ej1;
import com.mycompany.psp_ud04_act1.view.Vista;
import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author Vespertino
 */
public class ControladorVista {
    
    private static final Logger log = Logger.getLogger(ControladorVista.class.getName());
    
    private Vista v;
    public ControladorVista(Vista v){
        this.v=v;
        bucleDePrograma();
        try {
            v.close();
        } catch (IOException ex) {
            log.warning("Error cerrando la vista: " + ex.getMessage());
        }
    }
    
        public void bucleDePrograma(){
        try{
            boolean salir = false;
            Integer opcion;
            do{
                opcion = v.menu();
                if(opcion == null) salir = true;
                else router(opcion);
            } while(!salir);
            v.imprime("Hasta luego.");
            try {
                v.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }
    
    private void router(int opcion){
        switch (opcion){
            case 1:
                new Ej1(v);
                break;
            case 2:
                
                break;
            case 3:
                
                break;
        }
    }

}
