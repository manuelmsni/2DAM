/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mongodbpojotest.controller;

import com.mycompany.mongodbpojotest.dao.AnimalDAO;
import com.mycompany.mongodbpojotest.dao.EspecieDAO;
import com.mycompany.mongodbpojotest.model.Animal;
import com.mycompany.mongodbpojotest.model.Especie;
import com.mycompany.mongodbpojotest.view.Vista;
import java.io.IOException;
import java.util.logging.Logger;
import org.bson.types.ObjectId;

/**
 *
 * @author manuelmsni
 */
public class ControladorVista {
    
    private static final Logger log = Logger.getLogger(ControladorVista.class.getName());
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
                imprimeEspecies();
                break;
            case 3:
                Especie e = obtenerEspecie();
                crearAnimal(e);
                break;
            case 4:
                eliminarAnimal();
                break;
            case 5:
                actualizarAnimal();
                break;
        }
    }
    
    private void imprimeAnimales() {
        v.imprime(Animal.formatearAnimales(AnimalDAO.getInstance().obtenerTodos()));
    }
    
    private void imprimeEspecies() {
        v.imprime(Especie.formatearEspecies(EspecieDAO.getInstance().obtenerTodos()));
    }

    private void crearAnimal(Especie e) {
        AnimalDAO.getInstance().crear(new Animal(
                v.solicitaString("Introduce el nombre:"),
                e
        ));
    }

    private void eliminarAnimal() {
        AnimalDAO.getInstance().borrar(v.solicitaObjectId("Introduce el id:"));
    }

    private void actualizarAnimal() {
        boolean actualizado = false;
        Animal u = AnimalDAO.getInstance().obtener(v.solicitaObjectId("Introduce el id:"));
        if(v.solicitaConfirmacion("¿Deseas cambiar el nombre?")){
            u.setNombre(v.solicitaString("Introduce el nuevo nombre:"));
            actualizado = true;
        }
        if(v.solicitaConfirmacion("¿Deseas cambiar la especie?")){
            u.setEspecie(obtenerEspecie());
            actualizado = true;
        }
        if(actualizado) AnimalDAO.getInstance().actualizar(u);
    }
    

    private Especie obtenerEspecie() {
        return EspecieDAO.getInstance().obtener(v.solicitaObjectId("Introduce el id:"));
    }
    
    private Animal obtenerAnimal() {
        return AnimalDAO.getInstance().obtener(v.solicitaObjectId("Introduce el id:"));
    }

    

}
