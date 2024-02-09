/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primeraactividadpsp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author manuelmsni
 */
public class Ej6 {
    
    public static class Contactos implements Serializable {

        // Añadir el atributo público TamañoMaximoAgenda
        public static int TamañoMaximoAgenda = 100;

        public Map<String, Datos> agenda = new HashMap<String, Datos>();

        public void addDatos(String nombre, String tfno, String email) {
            agenda.put(nombre, new Datos(email, tfno));
        }

        public String getTfno(String nombre) {
            return agenda.get(nombre).getTfno();
        }

        public String getEmail(String nombre) {
            return agenda.get(nombre).getEmail();
        }

        public int tamaño() {
            return agenda.size();
        }
        
    }
    
    public static void serializa(String path) {
        // Crear un objeto Contactos y agregar datos
        Contactos contactos = new Contactos();
        contactos.addDatos("Manuel", "473545247", "manuel@eso.com");
        contactos.addDatos("Martin", "254724575", "manuel@lootro.com");

        // Serializar el objeto en un archivo en disco
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(contactos);
            System.out.println("Contacto serializado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void deserializa(String path) {
        // Deserializar el objeto desde un archivo en disco
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            Contactos contactos = (Contactos) in.readObject();
            System.out.println("Contacto deserializado.");

            // Comprobar los datos deserializados
            System.out.println("Tamaño de la agenda: " + contactos.tamaño());
            for(Map.Entry<String, Datos> datos : contactos.agenda.entrySet()){
                System.out.println("Teléfono de " + datos.getKey() + " " + datos.getValue().tfno);
                System.out.println("Email de " + datos.getKey() + " " + datos.getValue().email);
            }
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch(InvalidClassException ice){
            System.out.println("Error provocado solicitado en el enunciado del ejercicio, tras serializar, se ha cambiado la clase, añadiendo un atributo, lo que cambia el SerialVersionUUID, provocando una excepción de InvalidClassException " + ice.getMessage());
        } catch(IOException ioe){
            
        }
    }
    
    public static class Datos implements Serializable {
            private String email;
            private String tfno;

            public Datos(String email, String telefono) {
                this.email = email;
                this.tfno = telefono;
            }

            public String getTfno() {
                return tfno;
            }

            public String getEmail() {
                return email;
            }
        }
    
}
