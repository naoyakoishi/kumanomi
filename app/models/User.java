package models;

import java.util.List;
import java.util.Map;

import play.db.ebean.Model;
import play.data.validation.Constraints.Required;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;

@Entity
public class User extends Model {
	/** serialVersionUID */
	private static final long serialVersionUID = 3785050509333281504L;

	@Id  
	public Long seq;

	@Required
	public String user_id;
	
	@Required
	public String name;

	@Required
	public String open_id;

	@Valid
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	public List<DrinkDecision> decisions;

	public static Finder<Long, User> find = new Finder<Long, User>(
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

	public static User confirmUser(String userId, Map<String, String> friendMap) {
		User result = find.where().eq("user_id", userId).findUnique();
		if (null != result) {
			return result;
		} else {
			User user = new User();
			user.user_id = userId;
			user.name = friendMap.get(userId);
			user.save();
			return user;
		}		
	}

}