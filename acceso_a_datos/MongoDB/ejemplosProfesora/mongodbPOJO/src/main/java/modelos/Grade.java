/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

/**
 *
 * @author Anne
 */
public class Grade implements Serializable{
    private ObjectId id;
    @BsonProperty(value = "student_id")
    private Double studentId;
    
    private List<Score> scores;
    @BsonProperty(value = "class_id")
    private Double classId;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Double getStudent_Id() {
        return studentId;
    }

    public void setStudent_Id(Double studentId) {
        this.studentId = studentId;
    }
public Double getstudent_Id() {
        return studentId;
    }

    public void setstudent_Id(Double studentId) {
        this.studentId = studentId;
    }
    public Double getClassId() {
        return classId;
    }

    public void setClassId(Double classId) {
        this.classId = classId;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.studentId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grade other = (Grade) obj;
        return Objects.equals(this.studentId, other.studentId);
    }

    @Override
    public String toString() {
        return "Grade{" + "id=" + id + ", studentId=" + studentId + ", classId=" + classId + ", scores=" + scores + '}';
    }

    public Grade( Double studentId, Double classId, List<Score> scores) {
        
        this.studentId = studentId;
        this.classId = classId;
        this.scores = scores;
    }

    public Grade() {
    }

   
    
}
