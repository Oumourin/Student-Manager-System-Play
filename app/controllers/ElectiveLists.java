package controllers;

import play.mvc.With;

@With(Secure.class)
@Check("AdminAndStudent")
public class ElectiveLists extends CRUD {
}
