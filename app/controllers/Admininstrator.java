package controllers;

// import org.h2.engine.User;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Admininstrator extends Controller {

    @Before
    static void setConnected(){
        if (Security.isConnected()){

        }
    }
}
