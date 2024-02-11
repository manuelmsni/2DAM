/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act1.view;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class Vista implements Closeable {

    public static final String[] OPCIONES = {
        "Ej1",
        "Ej2",
        "Ej3",
        "Ej4",
        "Ej5",
        "Ej6",
        "Ej7",
        "Ej8"
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
            if(!valido) imprime("No se ha introducido ningún valor.");
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
                imprime("El valor introducido no es un número entero.");
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
            if(!valido) imprime("El número introducido no está en el rango permitido.");
        } while (!valido);
        return solicitado;
    }
    
    public URL solicitaURL(String mensaje){
        String solicitado;
        URL url = null;
        boolean valido = false;
        do{
            solicitado = solicitaString(mensaje);
            if(solicitado == null) return null;
            try{
                url = new URL(solicitado);
                valido = true;
            }catch (MalformedURLException e){
                imprime("El valor introducido no es una URL válida.");
            }
        } while (!valido);
        return url;
    }


    public Integer menu(){
        imprime("Elige una opción:");
        for (int i = 0; i < OPCIONES.length; i++) {
            System.out.println((i+1) + ".- " + OPCIONES[i]);
        }
        imprime("[Introduce \"" + OPCION_SALIR + "\" para salir]");
        return solicitaIntEnIntervaloCerrado("Introduce un número entre 1 y " + OPCIONES.length + " (incluidos).", 1, OPCIONES.length);
    }
    
    public File solicitaDirectorio() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        int option = fileChooser.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        } else {
            return null;
        }
    }

    @Override
    public void close() throws IOException {
        scanner.close();
    }
}