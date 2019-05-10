package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin extends Model {

    @Id
    private String workId;
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
}
