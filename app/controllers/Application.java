package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.api.mvc.Session;
import play.data.Form;
import models.User;

public class Application extends Controller {

	static Form<User> userForm = Form.form(User.class);
	
	public static Result index() {
		return ok(views.html.index.render(User.all(), userForm));
	}
	
	/**
	 * 仮
	 * @return
	 */
	public static Result login() {
		Form<User> filledForm = userForm.bindFromRequest();
		if(filledForm.hasErrors()) {
			return badRequest(
					views.html.index.render(User.all(), filledForm)
					);
		} else {
			User user = new User();
			user.userId = filledForm.get().userId;
			user.oauthType = filledForm.get().oauthType;
			user.openId= filledForm.get().openId;

			session("userId", user.userId);

			User.create(filledForm.get());
			return redirect(routes.Application.index());  
		}
	}

	public static Result delete(Long id) {
		User.delete(id);
		return ok(views.html.index.render(User.all(), userForm));
	}
}
