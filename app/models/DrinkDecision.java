package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class DrinkDecision extends Model {
	
	/** serialVersionUID */
	private static final long serialVersionUID = 2958338137069443507L;

	@Id  
	public Long seq;

	public String user_id;
	
	public String name;

	@ManyToOne
	@JoinColumn(name = "drink_date_seq")
	public DrinkDate date;

	@ManyToOne
	@JoinColumn(name = "user_seq")
	public User user;

	public static Finder<Long, DrinkDecision> find = new Finder<Long, DrinkDecision>(
			Long.class, DrinkDecision.class
			);

	public static List<DrinkDecision> all() {
		return find.all();
	}
  
	public static void create(DrinkDecision decision) {
		decision.save();
	}
  
	public static void delete(Long id) {
		find.ref(id).delete();
	}
}