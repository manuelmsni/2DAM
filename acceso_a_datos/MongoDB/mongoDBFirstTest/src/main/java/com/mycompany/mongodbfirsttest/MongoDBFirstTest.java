/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mongodbfirsttest;

import com.mycompany.mongodbfirsttest.controller.ControladorVista;
import com.mycompany.mongodbfirsttest.model.Usuario;
import com.mycompany.mongodbfirsttest.view.Vista;
import java.util.logging.Logger;

/**
 *
 * @author Vespertino
 */
public class MongoDBFirstTest {
    
    private static final Logger log = Logger.getLogger(MongoDBFirstTest.class.getName());

    public static void main(String[] args) {
        Vista v = new Vista();
        ControladorVista c = new ControladorVista(v);
        c.start();
    }
}
