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
        String id;
        if(Security.isConnected())
        {
            isConnected = true;
        }
        else {
            isConnected = false;
        }
        render(isConnected);
    }

    
}