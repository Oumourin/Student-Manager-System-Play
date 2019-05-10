package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import java.sql.Date;

@Entity
public class ElectiveList extends Model {
    private String stuId;
    private String subjectId;
    private String workId;
    private Date startDate;

    public ElectiveList(String stuId, String subjectId, String workId, Date startDate) {
        this.stuId = stuId;
        this.subjectId = subjectId;
        this.workId = workId;
        this.startDate = startDate;
    }

    public ElectiveList(String stuId, String subjectId, String workId) {
        this.stuId = stuId;
        this.subjectId = subjectId;
        this.workId = workId;
    }

    public String getStuId() {
        return stuId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getWorkId() {
        return workId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
