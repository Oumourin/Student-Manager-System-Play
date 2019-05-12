package models;

import net.sf.oval.constraint.MaxSize;
import net.sf.oval.constraint.MinSize;
import net.sf.oval.constraint.Past;
import play.data.validation.Password;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Teacher extends Model {
    @Id
    private String workId;

    @Password
    private String password;
    private String teacherName;

    private boolean isActive;

    @OneToMany(mappedBy = "myTeaching", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Teaching> teachings;

    @OneToMany(mappedBy = "myTeacher", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students;

    public Teacher(String workId, String password) {
        this.workId = workId;
        this.password = password;
        this.teacherName = "";
        this.isActive = true;
    }

    public Teacher(String workId, String password, String teacherName){
        this.workId = workId;
        this.password = password;
        this.teacherName = teacherName;
        this.isActive = false;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String toString(){
        return workId;
    }

    public static Teacher checkTeacher(String workId, String password)
    {
        return Teacher.find("byWorkIdAndPassword", workId, password).first();
    }

    // 自我注册方法
    public static void regTeacher(String workId, String password, String teacherName){
        Teacher newTeacher = new Teacher(workId, password, teacherName);
        newTeacher.save();
    }

    // 打分方法
    public static void setScore(String stuId, String subjectId, Double
            score){
        Student student = Student.find("byStuId", stuId).first();
        Subject subject = Subject.find("bySubjectId", subjectId).first();
        if ( student != null ){
            if (subject != null)
            {
                ScoreList newScoreList = new ScoreList(stuId, subjectId, score);
                newScoreList.save();
            }
        }
    }

}
