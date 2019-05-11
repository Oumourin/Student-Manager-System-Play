package controllers;

import play.mvc.With;

@With(Secure.class)
@Check("AdminAndTeacher")
public class Students extends CRUD {

}
