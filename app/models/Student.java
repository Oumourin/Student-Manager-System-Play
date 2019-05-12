package models;

import controllers.Security;
import net.sf.oval.constraint.MaxSize;
import net.sf.oval.constraint.MinSize;
import play.data.validation.Password;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Student extends Model {

    @Id
    private String stuId;

    @Password
    private String password;
    private String stuName;
    private Double GPA;
    private String classId;

    @ManyToOne
    private Class myClass;

    @ManyToOne
    private Teacher myTeacher;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ScoreList> myScoreList;

    @OneToMany(mappedBy = "stu", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<CostList> myCostList;

    public Class getMyClass() {
        return myClass;
    }

    public Teacher getMyTeacher() {
        return myTeacher;
    }

    public void setMyTeacher(Teacher myTeacher) {
        this.myTeacher = myTeacher;
    }

    public void setMyClass(Class myClass) {
        this.myClass = myClass;
    }

    public void setMyScoreList(List<ScoreList> myScoreList) {
        this.myScoreList = myScoreList;
    }

    public void setMyCostList(List<CostList> myCostList) {
        this.myCostList = myCostList;
    }

    public List<ScoreList> getMyScoreList() {
        return myScoreList;
    }

    public List<CostList> getMyCostList() {
        return myCostList;
    }

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

    //  费用相关方法
    // 列出未支付费用
    public static List<CostList> listUnCost(){
        List<CostList> unCostList = CostList.find("byIsPay", false).fetch();
        return unCostList;
    }

    // 支付费用
    public static void payCost(String orderId){
        CostList myCost = CostList.find("byOrderId", orderId).first();
        if(myCost != null){
            myCost.setPay(true);
            myCost.save();
        }
    }

    // 课程相关方法
    // 选课
    public static void electiveSubject(String subjectId, String stuId){
        Subject findSubject = Subject.find("bySubjectId", subjectId).first();
        if (findSubject != null){
            Teaching teaching = Teaching.find("bySubjectId", subjectId).first();
            ElectiveList myElective = new ElectiveList(stuId, subjectId, teaching.getWorkId(), teaching.getStartUp());
            myElective.save();
        }
    }

    // 删除选课
    public static void deletElective(String subjectId){
        ElectiveList findElective = ElectiveList.find("bySubjectId", subjectId).first();
        Date date = new Date();
        if (findElective != null){
            if (date.before(findElective.getStartDate())){
                findElective.delete();
            }
        }
    }

    // 打印成绩单
    public List<String> findMyScore(){
        List<String> myList = new ArrayList<>();
        for (int i=0; i<myScoreList.size(); i++){
            String myScore = myScoreList.get(i).getStuId() +"  "+ myScoreList.get(i).getScore();
            myList.add(myScore);
        }
        return myList;
    }


}
