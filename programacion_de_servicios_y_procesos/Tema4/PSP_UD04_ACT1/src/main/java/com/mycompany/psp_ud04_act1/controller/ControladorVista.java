/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act1.controller;

import com.mycompany.psp_ud04_act1.ejercicios.Ej1;
import com.mycompany.psp_ud04_act1.ejercicios.Ej2;
import com.mycompany.psp_ud04_act1.ejercicios.Ej3;
import com.mycompany.psp_ud04_act1.ejercicios.Ej4;
import com.mycompany.psp_ud04_act1.ejercicios.Ej5;
import com.mycompany.psp_ud04_act1.ejercicios.Ej6;
import com.mycompany.psp_ud04_act1.ejercicios.Ej7;
import com.mycompany.psp_ud04_act1.ejercicios.Ej8;
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
        v.imprime("\n----- Ejercicio" + opcion + " ------");
        switch (opcion){
            case 1:
                new Ej1(v);
                break;
            case 2:
                new Ej2(v);
                break;
            case 3:
                new Ej3(v);
                break;
            case 4:
                new Ej4(v);
                break;
            case 5:
                new Ej5(v);
                break;
            case 6:
                new Ej6(v);
                break;
            case 7:
                new Ej7(v);
                break;
            case 8:
                new Ej8(v);
                break;
        }
        v.imprime("----------------------\n");
    }

}
