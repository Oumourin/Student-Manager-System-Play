package models;

//import org.bouncycastle.math.raw.Mod;
import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class ScoreList extends Model {
    private String stuId;
    private String subjectId;
    private Double score;

    public ScoreList(String stuId, String subjectId, Double score) {
        this.stuId = stuId;
        this.subjectId = subjectId;
        this.score = score;
    }

    public String getStuId() {
        return stuId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public Double getScore() {
        return score;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String toString(){
        return "成绩表";
    }
}
