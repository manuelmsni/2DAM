/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ad.mongodbpojo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.result.InsertOneResult;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import modelos.Grade;
import modelos.Score;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.bson.Document;

/**
 *
 * @author Anne
 */
public class MongodbPOJO {

    public static void main(String[] args) {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
        PojoCodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(), CodecRegistries.fromProviders(pojoCodecProvider));
        // Obtener o crear una base de datos
 //       MongoDatabase database = mongoClient.getDatabase("My_Data_Base").withCodecRegistry(pojoCodecRegistry);
//        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
//
//        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
//        MongoClientSettings clientSettings = MongoClientSettings.builder()
//                .applyConnectionString(connectionString)
//                .codecRegistry(codecRegistry)
//                .build();
//        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {

            MongoDatabase db = mongoClient.getDatabase("sample_training").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Grade> grades = db.getCollection("grades", Grade.class);
            System.out.println("Lista de los Grados encontrados:");
            for (Grade g : grades.find()) {
                System.out.println(g.toString());
            }
            System.out.println("Buscando el estudiante los grados del Esutidante 0");
            Bson filtroc = Filters.eq("student_id", 0d);
            Grade grade0;
            grade0 = grades.find(filtroc).first();

            System.out.println("Grade (Estudiante 0) found:\t" + grade0);
            // create a new grade.

            Grade newGrade = new Grade();
            newGrade.setstudent_Id(10003d);
            newGrade.setClassId(10d);
            List<Score> scores = new ArrayList<>();
            Score score = new Score();
            score.setType("homework");
            score.setScore(50d);
            scores.add(score);
            newGrade.setScores(scores);
            System.out.println(newGrade.toString());

            try {
               // InsertOneResult insertOneResult = grades.insertOne(newGrade);
                grades.insertOne(newGrade);
            } catch (Exception e) {
                System.out.println("no puedo grabar");
                e.printStackTrace();
            }

            // find this grade.
            Bson filtro = Filters.eq("student_id", 10003d);
            Grade grade;
            grade = grades.find(filtro).first();
            System.out.println("Grade found:\t" + grade);

            // update this grade: adding an exam grade
            List<Score> newScores = new ArrayList<>(grade.getScores());
            Score newScore = new Score("exam", 42d);
            newScores.add(newScore);
            grade.setScores(newScores);
            Document filterByGradeId = new Document("_id", grade.getId());
            FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
            Grade updatedGrade = grades.findOneAndReplace(filterByGradeId, grade, returnDocAfterReplace);
            System.out.println("Grade replaced:\t" + updatedGrade);

            // delete this grade
            System.out.println(grades.deleteOne(filterByGradeId));
        }
    }

}
