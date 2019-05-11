package models;

import play.db.jpa.Model;
import play.jobs.On;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Subject extends Model {

    @Id
    private String subjectId;
    private String subjectName;
    private Double scorePoint;


    public Subject(String subjectId, String subjectName, Double scorePoint) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.scorePoint = scorePoint;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Double getScorePoint() {
        return scorePoint;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setScorePoint(Double scorePoint) {
        this.scorePoint = scorePoint;
    }

    @Override
    public String toString(){
        return "学科";
    }
}
