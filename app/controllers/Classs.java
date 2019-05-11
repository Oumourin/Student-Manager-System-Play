package controllers;

import play.mvc.With;

@With(Secure.class)
@Check("Admin")
public class Classs extends CRUD {
}
