package models;

import net.sf.oval.constraint.MaxSize;
import net.sf.oval.constraint.MinSize;
import org.h2.engine.User;
import play.data.validation.Password;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin extends Model {

    @Id
    private String workId;

    @Password
    private String password;

    public Admin(String workId, String password) {
        this.workId = workId;
        this.password = password;
    }

    public String getWorkId() {
        return workId;
    }

    public String getPassword() {
        return password;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "管理员";
    }

    public static Admin checkAdmin(String workId, String password){
        return find("byWorkIdAndPassword", workId, password).first();
    }

    //生成新班级和新学号
    public static String initStuId(String classId, int count){
        Class findClass = Class.find("byClassId", classId).first();
        if (findClass == null){
            return "班级不存在!";
        }
        Student findStudent = Student.find("byClassId", classId).first();
        if(findStudent != null){
            return "班级学生学号已经存在！";
        }
        Class newClass = new Class(classId,count);
        newClass.save();
        for (int stu = 1; stu <= count; stu++){
            if (stu < 10){
                String stuId = classId + "0" + stu;
                Student newStudent = new Student(stuId, "password", classId);
                newStudent.save();
            }
            String stuId = classId + stu;
            Student newStudent = new Student(stuId, "password", classId);
            newStudent.save();
        }
        return "已经创建" + classId + "班学号";
    }

    // public static String
}
