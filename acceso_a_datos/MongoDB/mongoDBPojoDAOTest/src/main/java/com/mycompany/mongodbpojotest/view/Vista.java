/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mongodbpojotest.view;

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bson.types.ObjectId;

public class Vista implements Closeable {
    
    public static final String[] OPCIONES = {
        "Listar especies",
        "Listar animales",
        "Crear especie",
        "Crear animal",
        "Eliminar especie",
        "Eliminar animal",
        "Actualizar especie",
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
            if (!valido) imprime("El correo electrónico introducido no tiene un formato válido.");
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
            if (!valido) imprime("Respuesta no válida. Por favor, responde 'sí' o 'no'.");
        } while (!valido);
        return respuesta.equals("sí") || respuesta.equals("si");
    }
    
    public ObjectId solicitaObjectId(String mensaje) {
        String respuesta;
       // boolean valido;
       // do{
            respuesta = solicitaString(mensaje);
            if (respuesta == null) return null;
            respuesta = respuesta.trim();
         //   valido = ObjectId.isValid(mensaje);
           // if (!valido) imprime("No es un id válido.");
       // } while (!valido);
        return new ObjectId(respuesta);
    }

    public Integer menu(){
        imprime("Elige una opción:");
        for (int i = 0; i < OPCIONES.length; i++) {
            imprime((i+1) + ".- " + OPCIONES[i]);
        }
        imprime("[Introduce \"" + OPCION_SALIR + "\" para salir]");
        return solicitaIntEnIntervaloCerrado("Introduce un número entre 1 y " + OPCIONES.length + " (incluidos).", 1, OPCIONES.length);
    }

    @Override
    public void close() throws IOException {
        scanner.close();
    }
}
