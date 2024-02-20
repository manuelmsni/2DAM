/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mongodbfirsttest.controller;

import com.mycompany.mongodbfirsttest.MongoDBFirstTest;
import com.mycompany.mongodbfirsttest.dao.AnimalDAO;
import com.mycompany.mongodbfirsttest.model.Animal;
import com.mycompany.mongodbfirsttest.view.Vista;
import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author manuelmsni
 */
public class ControladorVista {
    
    private static final Logger log = Logger.getLogger(MongoDBFirstTest.class.getName());
    private Vista v;
    
    public ControladorVista(Vista v){
        this.v=v;
    }
    
    public void start(){
        bucleDePrograma();
    }
    
    public void exit(){
        try {
            v.close();
        } catch (IOException ex) {
            log.warning("No se ha podido cerrar la vista: " + ex.getMessage());
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
            v.imprime("Adios.");
            exit();
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }
    
    private void router(int opcion){
        switch (opcion){
            case 1:
                imprimeAnimales();
                break;
            case 2:
                crearAnimal();
                break;
            case 3:
                eliminarAnimal();
                break;
            case 4:
                actualizarAnimal();
                break;
            case 5:
                imprimeAnimalPorNombre();
                break;
            case 6:
                imprimeAnimalPorEspecie();
                break;
        }
    }
    
    private void imprimeAnimales() {
        v.imprime(Animal.formatearUsuarios(AnimalDAO.getInstance().obtenerTodos()));
    }

    private void crearAnimal() {
        AnimalDAO.getInstance().crear(new Animal(
                v.solicitaString("Introduce el nombre:"),
                v.solicitaString("Introduce la especie:")
        ));
    }

    private void eliminarAnimal() {
        AnimalDAO.getInstance().borrar(v.solicitaString("Introduce el id:"));
    }

    private void actualizarAnimal() {
        boolean actualizado = false;
        Animal u = AnimalDAO.getInstance().obtener(v.solicitaString("Introduce el id:"));
        if(v.solicitaConfirmacion("¿Deseas cambiar el nombre?")){
            u.setNombre(v.solicitaString("Introduce el nuevo nombre:"));
            actualizado = true;
        }
        if(v.solicitaConfirmacion("¿Deseas cambiar la especie?")){
            u.setEspecie(v.solicitaString("Introduce la nueva especie:"));
            actualizado = true;
        }
        if(actualizado) AnimalDAO.getInstance().actualizar(u);
    }
    
    private void imprimeAnimalPorNombre() {
        v.imprime(AnimalDAO.getInstance().obtenerPorNombre(v.solicitaString("Introduce el nombre:")).toString());
    }

    private void imprimeAnimalPorEspecie() {
        v.imprime(AnimalDAO.getInstance().obtenerPorEspecie(v.solicitaString("Introduce la especie:")).toString());
    }

}
