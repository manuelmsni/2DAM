/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mongodbfirsttest.controller;

import com.mycompany.mongodbfirsttest.MongoDBFirstTest;
import com.mycompany.mongodbfirsttest.dao.UsuarioDAO;
import com.mycompany.mongodbfirsttest.model.Usuario;
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
                imprimeUsuarios();
                break;
            case 2:
                crearUsuario();
                break;
            case 3:
                eliminarUsuario();
                break;
            case 4:
                actualizarUsuario();
                break;
            case 5:
                imprimeUsuarioPorNombre();
                break;
            case 6:
                imprimeUsuarioPorCorreo();
                break;
        }
    }
    
    private void imprimeUsuarios() {
        v.imprime(Usuario.formatearUsuarios(UsuarioDAO.getInstance().obtenerTodos()));
    }

    private void crearUsuario() {
        UsuarioDAO.getInstance().crear(new Usuario(
                v.solicitaString("Introduce el nombre:"),
                v.solicitaCorreo("Introduce el correo:")
        ));
    }

    private void eliminarUsuario() {
        UsuarioDAO.getInstance().borrar(v.solicitaString("Introduce el id:"));
    }

    private void actualizarUsuario() {
        boolean actualizado = false;
        Usuario u = UsuarioDAO.getInstance().obtener(v.solicitaString("Introduce el id:"));
        if(v.solicitaConfirmacion("¿Deseas cambiar el nombre?")){
            u.setNombre(v.solicitaString("Introduce el nuevo nombre:"));
            actualizado = true;
        }
        if(v.solicitaConfirmacion("¿Deseas cambiar el correo?")){
            u.setCorreo(v.solicitaCorreo("Introduce el nuevo correo:"));
            actualizado = true;
        }
        if(actualizado) UsuarioDAO.getInstance().actualizar(u);
    }
    
    private void imprimeUsuarioPorNombre() {
        v.imprime(UsuarioDAO.getInstance().obtenerPorNombre(v.solicitaString("Introduce el nombre:")).toString());
    }

    private void imprimeUsuarioPorCorreo() {
        v.imprime(UsuarioDAO.getInstance().obtenerPorCorreo(v.solicitaCorreo("Introduce el correo:")).toString());
    }

}
