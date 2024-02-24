/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_ud04_act3.Ej4;

/**
 *
 * @author manuelmsni
 */
public class Ej4 {
    public static void main(String[] args){
        Servidor servidor = new Servidor(6004);
        servidor.iniciar();

        FormCliente client = new FormCliente();
        client.setVisible(true);
    }
}
