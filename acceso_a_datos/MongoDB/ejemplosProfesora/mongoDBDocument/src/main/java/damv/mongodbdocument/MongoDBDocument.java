/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package damv.mongodbdocument;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author ProfVespertino
 */
public class MongoDBDocument {

    public static void main(String[] args) {
        String uri = "mongodb://localhost:57017";
        MongoClient mongoClient = null;
        try {
            // creamos conexión
            mongoClient = MongoClients.create(uri);
            // accedemos a bd
            MongoDatabase database = mongoClient.getDatabase("test1");
            
            // recogemos collecion
            MongoCollection collectionUsuarios= database.getCollection("usuarios");
            // crear documento de tipo usuario
            Document usuario = new Document("login","guille")
                    .append("pass", "secret");
            // insertamos documento usuario
            collectionUsuarios.insertOne(usuario);
            // contamos documentos en usuarios
            
            System.out.println(collectionUsuarios.countDocuments());
            // Consultamos todos los usuarios
            mostrarCollection(collectionUsuarios);
//            FindIterable<Document> usuarios =collectionUsuarios.find();
//            for(Document usu :usuarios){
//                System.out.println(usu.toJson());
//            }
            
            //Filtrar un usuario por login
           FindIterable<Document> usuariosFiltrados =collectionUsuarios.find(eq("login","santi"));
           for(Document usu :usuariosFiltrados){
                System.out.println(usu.toJson());
            }
           
           // Modificar un documento
           // update one document
            Bson filter = eq("login", "santi");
            Bson updateOperation = set("pass", "newPass");
            UpdateResult updateResult = collectionUsuarios.updateOne(filter, updateOperation);
            System.out.println("Actualizado " + updateResult);
            
           Document usuFiltrado = (Document) collectionUsuarios.find(filter).first();
           System.out.println(usuFiltrado.toJson());
           // delete Many  document
           Bson filter2 = eq("login", "guille");
           DeleteResult result = collectionUsuarios.deleteMany(filter2);
           System.out.println("Borrado " + result);
           
           // mostrar contenido
           mostrarCollection(collectionUsuarios);
          
        } catch (Exception e) {
            e.printStackTrace();

        }finally{
        
            if (mongoClient!=null) mongoClient.close();
        }
    }
    private static void mostrarCollection(MongoCollection mongoCollection){
    FindIterable<Document> usuarios =mongoCollection.find();
            for(Document usu :usuarios){
                System.out.println(usu.toJson());
            }
    }
}
