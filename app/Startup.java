import models.Admin;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

@OnApplicationStart
public class Startup extends Job {

    public void doJob(){
        if (Admin.count() == 0){
            Fixtures.loadModels("initial-data.yml");
        }
    }
}
