package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;
import models.Drink;
import models.DrinkUser;

public class DrinkController extends Controller {

	static Form<Drink> drinkForm = Form.form(Drink.class);
	
	/**
	 * 詳細画面を表示する。
	 * @return 詳細画面
	 */
	public static Result drink(Long id) {
		try {
			Drink drink = Drink.find.ref(id);			
			return ok(
					views.html.drink.render(drink)
					);
		} catch(Exception e) {
			return redirect(routes.DrinkController.drinks());  
		}
	}
	
	/**
	 * 一覧画面を表示する。
	 * @return 一覧画面
	 */
	public static Result drinks() {
		return ok(
				views.html.drinks.render(Drink.all())
				);
	}
	
	/**
	 * 入力画面を表示する。
	 * @return 入力画面
	 */
	public static Result drinkInput() {
		return ok(
				views.html.drinkInput.render(drinkForm, createUserList())
				);
	}
	
	/**
	 * 登録処理
	 * @return 一覧画面
	 */
	public static Result newDrink() {
		Form<Drink> filledForm = drinkForm.bindFromRequest();

		// エラーがある場合
		if(filledForm.hasErrors()) {
			return badRequest(
					views.html.drinkInput.render(filledForm, createUserList())
					);
		} else {
			Drink drink = filledForm.get();
			for (int i = 0; i < drink.dates.size(); i++) {
				drink.dates.get(i).delete();
			}
					
			String[] users = request().body().asFormUrlEncoded().get("tmpUser");
			for (int i = 0; i < users.length; i++) {
				DrinkUser user = new DrinkUser();
				user.name = users[i];
				drink.users.add(user);
			}

			drink.organizer = "kumanomi";
			drink.updateAt = new Date();
			Drink.create(drink);
			return redirect(routes.DrinkController.drinks());  
		}
	}
	
	/**
	 * 削除処理
	 * @param id
	 * @return 一覧画面
	 */
	public static Result deleteDrink(Long id) {
		Drink.delete(id);
		return redirect(routes.DrinkController.drinks());
	}
	
	
	/**
	 * （仮）ユーザーリスト作成
	 * @return ユーザーリスト
	 */
	private static List<String> createUserList() {
		List<String> users = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			users.add("name" + String.valueOf(i));
		}
		return users;
	}
}
