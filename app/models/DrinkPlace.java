package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class DrinkPlace extends Model {
	
	/** serialVersionUID */
	private static final long serialVersionUID = -744407330560387957L;

	@Id  
	public Long seq;
	
	public String shop_name;
	
	public String shop_url;

	public String station;
	
	public static Finder<Long, DrinkPlace> find = new Finder<Long, DrinkPlace>(
			Long.class, DrinkPlace.class
			);

	public static List<DrinkPlace> all() {
		return find.all();
	}
  
	public static void create(DrinkPlace place) {
		place.save();
	}
  
	public static void delete(Long id) {
		find.ref(id).delete();
	}

}