/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act1.view;

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;

public class Vista implements Closeable {

    public static final String[] OPCIONES = {
        "Ej1",
        "Ej2"
    };
    
    public static final String OPCION_SALIR = "0";

    private Scanner scanner;
    public Vista(){
        scanner = new Scanner(System.in);
    }

    public void imprime(String mensaje){
        System.out.println(mensaje);
    }

    public String solicitaString(String mensaje){
        imprime(mensaje);
        String solicitado;
        boolean valido;
        do{
            solicitado = scanner.nextLine();
            if(solicitado == null) valido = false;
            else if(solicitado.equals(OPCION_SALIR)) return null;
            else valido = !solicitado.isBlank();
            if(!valido) System.out.println("No se ha introducido ningún valor.");
        } while (!valido);
        return solicitado;
    }

    public Integer solicitaInt(String mensaje){
        String solicitado;
        boolean valido = false;
        do{
            solicitado = solicitaString(mensaje);
            if(solicitado == null) return null;
            try{
                Integer.parseInt(solicitado);
                valido = true;
            }catch (NumberFormatException e){
                System.out.println("El valor introducido no es un número entero.");
            }
        } while (!valido);
        return Integer.valueOf(solicitado);
    }


    public Integer solicitaIntEnIntervaloCerrado(String mensaje, int min, int max){
        Integer solicitado;
        boolean valido = false;
        do{
            solicitado = solicitaInt(mensaje);
            if(solicitado == null) return null;
            valido = solicitado >= min && solicitado <= max;
            if(!valido) System.out.println("El número introducido no está en el rango permitido.");
        } while (!valido);
        return solicitado;
    }


    public Integer menu(){
        imprime("Elige una opción:");
        for (int i = 0; i < OPCIONES.length; i++) {
            System.out.println((i+1) + ".- " + OPCIONES[i]);
        }
        imprime("[Introduce \"" + OPCION_SALIR + "\" para salir]");
        return solicitaIntEnIntervaloCerrado("Introduce un número entre 1 y " + OPCIONES.length + " (incluidos).", 1, OPCIONES.length);
    }

    @Override
    public void close() throws IOException {
        scanner.close();
    }
}