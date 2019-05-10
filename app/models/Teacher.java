package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacher extends Model {
    @Id
    private String workId;
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
}
