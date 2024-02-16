/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.mongodbpojo;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import modelos.Grade;
import modelos.Score;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

/**
 *
 * @author Anne
 **/
// Crea esta colección en una base de datos de mongodb llamada universityDB
//{
//    "_id": {
//        "$oid": "56d5f7eb604eb380b0d8d8ce"
//    },
//    "student_id": {
//        "$numberDouble": "0"
//    },
//    "scores": [{
//        "type": "exam",
//        "score": {
//            "$numberDouble": "78.40446309504266"
//        }
//    }, {
//        "type": "quiz",
//        "score": {
//            "$numberDouble": "73.36224783231339"
//        }
//    }, {
//        "type": "homework",
//        "score": {
//            "$numberDouble": "46.980982486720535"
//        }
//    }, {
//        "type": "homework",
//        "score": {
//            "$numberDouble": "76.67556138656222"
//        }
//    }],
//    "class_id": {
//        "$numberDouble": "339"
//    }
//}
public class MongoPojo2Collections {

    public static void main(String[] args) {
        // Cadena de conexion con la base de datos mongo
        String uri = "mongodb://localhost:57017";
        PojoCodecProvider pojoCodecProvider = PojoCodecProvider
                .builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(pojoCodecProvider));

        // Se abre la conexión
        try (MongoClient mongoClient = MongoClients.create(uri)) {

            // Obtener o crear una base de datos
            MongoDatabase database = mongoClient
                    .getDatabase("unversityDB").withCodecRegistry(pojoCodecRegistry);

            // Obtener o crear una colección
            MongoCollection<Grade> collection = database.getCollection("grades", Grade.class);

            // Insertar algún dato en la colección
            Grade pojoData = new Grade();
            pojoData.setstudent_Id(10003d);
            pojoData.setClassId(10d);
            List<Score> scores = new ArrayList<>();
            Score score = new Score();
            score.setType("homework");
            score.setScore(50d);
            scores.add(score);
            pojoData.setScores(scores);

            InsertOneResult insertOneResult = collection.insertOne(pojoData);
            System.out.println("\n--- insert one result ---");
            System.out.println(insertOneResult.getInsertedId());

            // Insertar varios datos de golpe
//            List<Person> severalData = new ArrayList<>();
//            severalData.add(new Person("Juan", 21));
//            severalData.add(new Person("Elena", 23));
//            InsertManyResult insertManyResult = collection.insertMany(severalData);
//            System.out.println("\n--- insert many result ---");
//            System.out.println(insertManyResult.getInsertedIds());
            // Consultar la colección
//            FindIterable<Grade> allCollection = collection.find();
//            System.out.println("\n--- find() result ---");
//            allCollection.forEach(grade -> System.out.println(grade));
//
//            // Consultar por una key
//            Bson filter = Filters.eq("student_Id", 10003d);
//            FindIterable<Grade> elementsFound = collection.find(filter);
//            System.out.println("\n--- find(filter) result ---");
//            elementsFound.forEach(grade -> System.out.println(grade));
//
//            // Modificar un elemento de la colección
//            Bson newClass = Updates.set("class_id", 88);
//            UpdateResult updateOne = collection.updateOne(filter, newClass);
//            
//            elementsFound = collection.find(filter);
//            System.out.println("\n--- updateOne() result ---");
//            System.out.println(updateOne.getMatchedCount());
//            elementsFound.forEach(grade -> System.out.println(grade));
//
//            // Reemplazar el POJO
//             Grade pojoOtro= new Grade();
//            pojoOtro.setstudent_Id(3333d);
//            pojoOtro.setClassId(90d);
//            List<Score> scoresOtro = new ArrayList<>();
//            Score scoreOtro = new Score();
//            scoreOtro.setType("quiz");
//            scoreOtro.setScore(80d);
//            scoresOtro.add(scoreOtro);
//            pojoOtro.setScores(scoresOtro);
//            
//            collection.replaceOne(filter, pojoOtro);
//            allCollection = collection.find();
//            System.out.println("\n--- find() new grade result ---");
//            allCollection.forEach(grade -> System.out.println(grade));
            // Borrar por key
//            DeleteResult deleteResult = collection.deleteMany(filter);
//            System.out.println("\n--- Number of deleted elements with filter ---");
//            System.out.println(deleteResult.getDeletedCount());
//            DeleteResult deleteResult = collection.deleteMany(filter);
//            System.out.println("\n--- Number of deleted elements with filter ---");
//            System.out.println(deleteResult.getDeletedCount());

            // Borrar todo
//            deleteResult = collection.deleteMany(Filters.empty());
//            System.out.println("\n--- Number of deleted elements with empty filter ---");
//            System.out.println(deleteResult.getDeletedCount());
            // Eliminar la coleccion
            // collection.drop();
            // Eliminar la base de datos
            //  database.drop();
            // Cierre de la conexión. No es necesario puesto que usamos try-with-resources
            // mongoClient.close();
        }
    }
}
