package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.sql.Date;

@Entity
public class Teaching extends Model {
    private String subjectId;
    private String workId;
    private Date startUp;

    @ManyToOne
    private Teacher myTeaching;

    public Teacher getMyTeaching() {
        return myTeaching;
    }

    public void setMyTeaching(Teacher myTeaching) {
        this.myTeaching = myTeaching;
    }

    public void setStartUp(Date startUp) {
        this.startUp = startUp;
    }

    public Date getStartUp() {
        return startUp;
    }

    public Teaching(String subjectId, String workId, Date startUp) {
        this.subjectId = subjectId;
        this.workId = workId;
        this.startUp = startUp;
    }

    public Teaching(String subjectId, String workId) {
        this.subjectId = subjectId;
        this.workId = workId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getWorkId() {
        return workId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    @Override
    public String toString(){
        return subjectId;
    }
}
