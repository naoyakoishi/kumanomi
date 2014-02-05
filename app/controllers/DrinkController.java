package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;
import logic.oauth.twitterLogic;
import models.Drink;
import models.DrinkMember;
import views.html.drink.*;

public class DrinkController extends Controller {

	static Form<Drink> drinkForm = Form.form(Drink.class);

	/**
	 * 一覧画面を表示する。
	 * @return 一覧画面
	 */
	public static Result index() {
		return ok(index.render(myDrinkList()));
	}

	/**
	 * 詳細画面を表示する。
	 * @return 詳細画面
	 */
	public static Result show(Long id) {
		try {
			Drink drink = Drink.find.ref(id);			
			return ok(show.render(drink));
		} catch(Exception e) {
			return redirect(routes.DrinkController.index());  
		}
	}

	/**
	 * 入力画面を表示する。
	 * @return 入力画面
	 */
	public static Result add() {
		return ok(add.render(drinkForm, twitterLogic.getFriendMap()));
	}

	/**
	 * 登録処理
	 * @return 一覧画面
	 */
	public static Result create() {
		Form<Drink> filledForm = drinkForm.bindFromRequest();

		// エラーがある場合
		if(filledForm.hasErrors()) {
			return badRequest(add.render(filledForm, twitterLogic.getFriendMap()));
		} else {
			Drink drink = filledForm.get();
			
			// TODO 仮
			for (String userId : drink.joinMembers) {
				DrinkMember member = new DrinkMember();

				drink.members.add(member);
			}

			drink.organizer = session("userId");
			drink.update_at = new Date();
			Drink.create(drink);
			return redirect(routes.DrinkController.index());  
		}
	}

	/**
	 * 削除処理
	 * @param id
	 * @return 一覧画面
	 */
	public static Result delete(Long id) {
		Drink.delete(id);
		return redirect(routes.DrinkController.index());
	}

	/**
	 * 自分が含まれている飲み会の一覧を取得
	 * @return　飲み会一覧
	 */
	private static List<Drink> myDrinkList() {
		String userId = session("userId");
		List<Drink> result = new ArrayList<Drink>();
		List<Drink> drinks = Drink.all();
		for (Drink drink : drinks) {
			for(DrinkMember member : drink.members) {

			}
		}
		return result;
	}
}
