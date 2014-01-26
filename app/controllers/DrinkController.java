package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;

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
		return ok(add.render(drinkForm, createUserList()));
	}
	
	/**
	 * 登録処理
	 * @return 一覧画面
	 */
	public static Result create() {
		Form<Drink> filledForm = drinkForm.bindFromRequest();

		// エラーがある場合
		if(filledForm.hasErrors()) {
			return badRequest(add.render(filledForm, createUserList()));
		} else {
			Drink drink = filledForm.get();
			
			// TODO 仮
			String[] members = request().body().asFormUrlEncoded().get("tmpUser");
			for (int i = 0; i < members.length; i++) {
				DrinkMember member = new DrinkMember();
				member.userId = members[i];
				drink.members.add(member);
			}

			drink.organizer = session("userId");
			drink.updateAt = new Date();
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
				System.out.println(member.userId);
				if (member.userId.equals(userId)) {
					System.out.println(member.userId);
					result.add(drink);
					break;
				}
			}
		}
		return result;
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
