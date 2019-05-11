package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Teaching extends Model {
    private String subjectId;
    private String workId;

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
        return "授课";
    }
}
