package models;

//import org.bouncycastle.math.raw.Mod;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Class extends Model {

    @Id
    private String classId;
    private int stuCount;

    public Class(String classId) {
        this.classId = classId;
    }

    public Class(String classId, int stuCount) {
        this.classId = classId;
        this.stuCount = stuCount;
    }

    public String getClassId() {
        return classId;
    }

    public int getStuCount() {
        return stuCount;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public void setStuCount(int stuCount) {
        this.stuCount = stuCount;
    }

    @Override
    public String toString(){
        return "班级";
    }
}
