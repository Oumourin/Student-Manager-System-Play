package controllers;

import models.Admin;
import models.Student;
import models.Teacher;

public class Security extends Secure.Security {

    static boolean authenticate(String workId, String password){
        if(Admin.checkAdmin(workId, password) != null)
        {
            return true;
        }
        if(Teacher.checkTeacher(workId, password) != null)
        {
            return true;
        }

        if(Student.checkStudent(workId, password) != null)
        {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean check(String profile) {
        if (Security.isConnected()) {
            //管理员鉴权
            if (profile.equals("Admin")) {
                String user = Security.connected();
                Admin admin = Admin.find("byWorkId", user).first();
                if (admin == null) {
                    return false;
                } else {
                    return true;
                }
            }
            //教师鉴权
            if (profile.equals("Teacher")) {
                String user = Security.connected();
                Teacher teacher = Teacher.find("byWorkId", user).first();
                if (teacher == null) {
                    return false;
                }
                else {
                    return true;
                }
            }
            //学生鉴权
            if (profile.equals("Student")) {
                String user = Security.connected();
                Student student = Student.find("byStuId", user).first();
                if (student == null) {
                    return false;
                } else {
                    return true;
                }
            }

            //管理员和老师鉴权
            if (profile.equals("AdminAndTeacher")){
                String user = Security.connected();
                Admin admin = Admin.find("byWorkId", user).first();
                Teacher teacher = Teacher.find("byWorkId", user).first();
                if(admin == null){
                    if (teacher == null){
                        return false;
                    }
                    else {
                        return true;
                    }
                }
                else {
                    return true;
                }
            }

            //学生和老师鉴权
            if (profile.equals("AdminAndStudent")){
                String user = Security.connected();
                Admin admin = Admin.find("byWorkId", user).first();
                Student student = Student.find("byStuId", user).first();
                if (admin == null){
                    if (student == null)
                    {
                        return false;
                    }
                    else {
                        return true;
                    }
                }
                else {
                    return true;
                }
            }
            return false;
        }
        return false;

    }

    public static void onDisconnected(){
        Application.index();
    }

}
