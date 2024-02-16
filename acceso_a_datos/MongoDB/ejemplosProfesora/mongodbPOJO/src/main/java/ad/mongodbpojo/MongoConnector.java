/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.mongodbpojo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Anne
 */
class MongoConnector {
     private static MongoClient instance = null;

    public MongoConnector(String dbUri) throws InstantiationException {
        if (instance == null) {
            instance = MongoClients.create(dbUri);
        } else {
            throw new InstantiationException("Connector Instance Already Exists");
        }
    }

    public MongoClient getInstance() {
        return instance;
    }

    public void listDatabases() {
        try {
            List<Document> databases = instance.listDatabases().into(new ArrayList<>());
            databases.forEach(db -> System.out.println(db.get("name")));
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    public MongoDatabase createDB(String dbName) {
        return instance.getDatabase(dbName);
    }

    public void createCollection(MongoDatabase db, String collectionName) {
        db.createCollection(collectionName);
    }

    public void printCollectionNames(MongoDatabase db) {
        List<String> collections = db.listCollectionNames().into(new ArrayList<>());
        collections.forEach(name -> System.out.println(name));
    }
}
