package models;

import net.sf.oval.constraint.MaxSize;
import net.sf.oval.constraint.MinSize;
import play.data.validation.Password;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student extends Model {

    @Id
    private String stuId;

    @Password
    private String password;
    private String stuName;
    private Double GPA;
    private String classId;

    // 默认构造器
    public Student(String stuId, String password, String classId) {
        this.stuId = stuId;
        this.password = password;
        this.classId = classId;
        this.stuName = " ";
        this.GPA = 0.;
    }

    public String getStuId() {
        return stuId;
    }

    public String getPassword() {
        return password;
    }

    public String getStuName() {
        return stuName;
    }

    public Double getGPA() {
        return GPA;
    }

    public String getClassId() {
        return classId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setGPA(Double GPA) {
        this.GPA = GPA;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Override
    public String toString(){
        return "学生";
    }

    public static Student checkStudent(String stuId, String password){
        return Student.find("byStuIdAndPassword", stuId, password).first();
    }
}
