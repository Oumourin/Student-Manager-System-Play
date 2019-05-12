package controllers;

import play.*;
import play.data.validation.Required;
import play.mvc.*;

import java.text.Normalizer;
import java.util.*;

import models.*;
import play.mvc.results.Result;

public class Application extends Controller {

    public static void index() {
        boolean isConnected;
        if(Security.isConnected())
        {
            isConnected = true;
        }
        else {
            isConnected = false;
        }
        render(isConnected);
    }

    @Check("Admin")
    public static void initClass(){
       String result = Admin.initStuId("1919", 20);
       render("Application/Result.html",result);
    }

    @Check("Admin")
    public static void activeTeacher(){
        String result = Admin.activeTeacher("114514");
        render("Application/Result.html",result);
    }
}