package models;

import java.util.List;

import play.db.ebean.Model;
import play.data.validation.Constraints.Required;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class User extends Model {
	/** serialVersionUID */
	private static final long serialVersionUID = 3785050509333281504L;

	@Id  
	public Long id;

	@Required
	public String userId;
	
	@Required
	public String oauthType;

	@Required
	public String openId;
	
	public static Finder<Long, User> find = new Finder(
			Long.class, User.class
			);

	public static List<User> all() {
		return find.all();
	}
  
	public static void create(User user) {
		user.save();
	}
  
	public static void delete(Long id) {
		find.ref(id).delete();
	}
}