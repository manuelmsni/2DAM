/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mongodbpojotest;

import com.mycompany.mongodbpojotest.controller.ControladorVista;
import com.mycompany.mongodbpojotest.view.Vista;
import java.util.logging.Logger;

/**
 *
 * @author Vespertino
 */
public class MongoDBPojoTest {
    
    private static final Logger log = Logger.getLogger(MongoDBPojoTest.class.getName());

    public static void main(String[] args) {
        Vista v = new Vista();
        ControladorVista c = new ControladorVista(v);
        c.start();
    }
}
