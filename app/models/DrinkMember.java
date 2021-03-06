package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class DrinkMember extends Model {
	
	/** serialVersionUID */
	private static final long serialVersionUID = -5307248167610902268L;

	@Id  
	public Long seq;

	@ManyToOne
	@JoinColumn(name = "drink_seq")
	public Drink drink;

	@ManyToOne
	@JoinColumn(name = "user_seq")
	public User user;
	
	public static Finder<Long, DrinkMember> find = new Finder<Long, DrinkMember>(
			Long.class, DrinkMember.class
			);

	public static List<DrinkMember> all() {
		return find.all();
	}
  
	public static void create(DrinkMember member) {
		member.save();
	}
  
	public static void delete(Long id) {
		find.ref(id).delete();
	}
}