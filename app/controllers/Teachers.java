package controllers;

import play.mvc.With;

@With(Secure.class)
@Check("AdminAndTeacher")
public class Teachers extends CRUD {
}
