package models;

import net.sf.oval.constraint.MaxSize;
import net.sf.oval.constraint.MinSize;
import play.data.validation.Password;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacher extends Model {
    @Id
    private String workId;

    @Password
    private String password;
    private String teacherName;

    public Teacher(String workId, String password) {
        this.workId = workId;
        this.password = password;
        this.teacherName = "";
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getWorkId() {
        return workId;
    }

    public String getPassword() {
        return password;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String toString(){
        return "教师";
    }

    public static Teacher checkTeacher(String workId, String password)
    {
        return Teacher.find("byWorkIdAndPassword", workId, password).first();
    }
}
