/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mongodbfirsttest.view;

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vista implements Closeable {
    
    public static final String[] OPCIONES = {
        "Listar animales",
        "Crear animal",
        "Eliminar animal",
        "Actualizar animal",
        "Busca animal por nombre",
        "Busca animal por especie"
    };
    
    public static final String OPCION_SALIR = "99";

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
    
    public String solicitaCorreo(String mensaje) {
        String email;
        boolean valido;
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        do {
            email = solicitaString(mensaje);
            if (email == null) return null;
            Matcher matcher = pattern.matcher(email);
            valido = matcher.matches();
            if (!valido) System.out.println("El correo electrónico introducido no tiene un formato válido.");
        } while (!valido);
        return email;
    }
    
    public Boolean solicitaConfirmacion(String mensaje) {
        String respuesta;
        boolean valido;
        do {
            respuesta = solicitaString(mensaje + " (sí/no)");
            if (respuesta == null) return null;
            respuesta = respuesta.trim().toLowerCase();
            valido = respuesta.equals("sí") || respuesta.equals("si") || respuesta.equals("no");
            if (!valido) System.out.println("Respuesta no válida. Por favor, responde 'sí' o 'no'.");
        } while (!valido);
        return respuesta.equals("sí") || respuesta.equals("si");
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
