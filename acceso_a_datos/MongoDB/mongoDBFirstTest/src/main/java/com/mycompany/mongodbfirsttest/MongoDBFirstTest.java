/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mongodbfirsttest;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mycompany.mongodbfirsttest.util.Constants;
import java.util.logging.Logger;

/**
 *
 * @author Vespertino
 */
public class MongoDBFirstTest {
    
    private static final Logger log = Logger.getLogger(MongoDBFirstTest.class.getName());

    public static void main(String[] args) {
        try(MongoClient mc = MongoClients.create(Constants.DB_URI)){
            var db = mc.getDatabase("test");
            var col = db.getCollection("usuarios");
            log.info("Contados: " + col.countDocuments());
        } catch(Exception e){
            log.warning("Ha habido un error estableciendo la conexión: " + e.getMessage());
        }
        
    }
}
