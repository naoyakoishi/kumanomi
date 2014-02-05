package controllers;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

	static Form<User> userForm = Form.form(User.class);
	
	public static Result index() {
		return ok(views.html.index.render(User.all(), userForm));
	}

	public static Result delete(Long id) {
		User.delete(id);
		return ok(views.html.index.render(User.all(), userForm));
	}
}
