/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hibernateautogenerated1an;

//import com.mycompany.hibernateautogenerated1an.controller.MainController;
//import com.mycompany.hibernateautogenerated1an.model.Book;
//import com.mycompany.hibernateautogenerated1an.model.Person;
import jakarta.transaction.Transactional;
 import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;

/**
 * Implementa la interfaz Closeable para indicar que se ha de cerrar el scanner.
 * Se hace uso de clases envoltorio (Integer...) para poder devolver nulos en caso de que el usuario quiera salir.
 */
public class Vista implements Closeable {

    public static final String[] OPCIONES = {
            "Listar libros",
            "Listar autores",
            "Crear libro",
            "Crear autor",
            "Añadir autor a libro",
            "Eliminar libro",
            "Eliminar autor"
    };
    
    public static final String OPCION_SALIR = "salir";
 
    private void router(int opcion){
        switch (opcion){
            case 1:
                imprimeLibros();
                break;
            case 2:
                imprimeAutores();
                break;
            case 3:
                MainController.addBook(new Book(solicitaString("Introduce el nombre del libro: ")));
                
                break;
            case 4:
                MainController.addPerson(new Person(solicitaString("Inteoduce el nombre del autor: ")));
                
                break;
            case 5:
                imprimeLibros();
                imprimeAutores();
                Book b = MainController.getLibro(solicitaInt("Introduce el id del libro: "));
                imprime("Has seleccionado el libro: " + b.toString());
                Person p = MainController.getPerson(solicitaInt("Introduce el id del autor: "));
                imprime("Has seleccionado el autor: " + p.toString());
                b.addPerson(p);
                imprime("El libro modificado en memoria es: " + b.toString());
                MainController.editBook(b);
                        
                break;
            case 6:
                MainController.deleteBook(solicitaInt("Introduce el id del libro: "));
                break;
            case 7:
                MainController.deletePerson(solicitaInt("Introduce el id del autor: "));
                break;
        }
    }
    
    private void imprimeLibros(){
        imprime("Libros:");
        MainController.getAllBooks().forEach(l->{imprime(l.toString());});
    }
    private void imprimeAutores(){
        imprime("Autores:");
        MainController.getAllPersons().forEach(p->{imprime(p.toString());});
    }

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

    public Double solicitaDouble(String mensaje){
        String solicitado;
        boolean valido = false;
        do{
            solicitado = solicitaString(mensaje);
            if(solicitado == null) return null;
            try{
                Double.parseDouble(solicitado);
                valido = true;
            }catch (NumberFormatException e){
                System.out.println("El valor introducido no es un número.");
            }
        } while (!valido);
        return Double.valueOf(solicitado);
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

    public Double solicitaDoubleEnIntervaloCerrado(String mensaje, double min, double max){
        Double solicitado;
        boolean valido = false;
        do{
            solicitado = solicitaDouble(mensaje);
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

    public void bucleDePrograma(){
        try{
            boolean salir = false;
            Integer opcion;
            do{
                opcion = menu();
                if(opcion == null) salir = true;
                else router(opcion);
            } while(!salir);
            imprime("Hasta luego.");
            try {
                close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws IOException {
        scanner.close();
    }
}