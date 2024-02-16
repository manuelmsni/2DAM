package ad.mongo_pojo_unacoleccion;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;
import modelo.Person;

/**
 * Ejemplo base de datos mongodb desde java En este ejemplo se usan POJO (Plain
 * Old Java Object) como datos.
 *
 * @author Anne Sept 2023
 */
public class MongoPojo1Coleccion {

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
                    .getDatabase("personasDB").withCodecRegistry(pojoCodecRegistry);

            // Obtener o crear una colección
            MongoCollection<Person> collection = database.getCollection("personas", Person.class);

            // Insertar algún dato en la colección
            Person pojoData = new Person("Pedro", 22);
            InsertOneResult insertOneResult = collection.insertOne(pojoData);

            System.out.println("\n--- insert one result ---");
            System.out.println(insertOneResult.getInsertedId());

            Person pojoData1 = new Person("Pedrccccc", 22);
            insertOneResult = collection.insertOne(pojoData1);
            System.out.println("\n--- insert one result ---");
            System.out.println(insertOneResult.getInsertedId());

            // Insertar varios datos de golpe
            List<Person> severalData = new ArrayList<>();
            severalData.add(new Person("Juan", 21));
            severalData.add(new Person("Elena", 23));
            InsertManyResult insertManyResult = collection.insertMany(severalData);
            System.out.println("\n--- insert many result ---");
            System.out.println(insertManyResult.getInsertedIds());

            // Consultar la colección
            FindIterable<Person> allCollection = collection.find();
            System.out.println("\n--- find() result ---");
            for (Person person : allCollection) {
                System.out.println(person);
            }
            //           allCollection.forEach(person -> System.out.println(person));

            // Consultar por una key
            Bson filter = Filters.eq("name", "Pedro");
            FindIterable<Person> elementsFound = collection.find(filter);
            System.out.println("\n--- find(filter) result ---");
            for (Person person : elementsFound) {
                System.out.println(person);
            }
//            elementsFound.forEach(person -> System.out.println(person));
//
            // Modificar un elemento de la colección
            Bson newAge = Updates.set("age", 23);
            UpdateResult updateMany = collection.updateMany(filter, newAge);

            elementsFound = collection.find(filter);
            System.out.println("\n--- updateMany() result ---");
            System.out.println(updateMany.getMatchedCount());
            for (Person person : elementsFound) {
                System.out.println(person);
            }
//            elementsFound.forEach(person -> System.out.println(person));
//
            // Reemplazar el POJO
            Bson filtercccc = Filters.eq("name", "Pedrccccc");
            Person newPedro = new Person("Pedro", 14);

            UpdateResult updateResultcccc = collection.replaceOne(filtercccc, newPedro);
            System.out.println(updateResultcccc.getModifiedCount());
            allCollection = collection.find();
            System.out.println("\n--- find() new pedro result ---");
            for (Person person : allCollection) {
                System.out.println(person);
            }
//            allCollection.forEach(person -> System.out.println(person));
//
            // Borrar por key
            DeleteResult deleteResult = collection.deleteMany(filter);
            System.out.println("\n--- Number of deleted elements with filter ---");
            System.out.println(deleteResult.getDeletedCount());
//
//            // Borrar todo
////            deleteResult = collection.deleteMany(Filters.empty());
////            System.out.println("\n--- Number of deleted elements with empty filter ---");
////            System.out.println(deleteResult.getDeletedCount());
//
            //           Eliminar la coleccion
            collection.drop();
//
//            // Eliminar la base de datos
            database.drop();
//
//            // Cierre de la conexión. No es necesario puesto que usamos try-with-resources
             mongoClient.close();
        }
    }
}
