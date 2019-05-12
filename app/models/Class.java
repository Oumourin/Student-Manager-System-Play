package models;

//import org.bouncycastle.math.raw.Mod;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Class extends Model {

    @Id
    private String classId;
    private int stuCount;

    @OneToMany(mappedBy = "myClass", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students;

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

    public List<Student> getStudents() {
        return students;
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
        return classId;
    }
}
