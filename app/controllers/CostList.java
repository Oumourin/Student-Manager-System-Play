package controllers;

import play.mvc.With;

@With(Secure.class)
@Check("AdminAndStudent")
public class CostList extends CRUD {
}
