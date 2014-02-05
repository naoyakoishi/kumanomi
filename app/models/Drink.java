package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Drink extends Model {
	/** serialVersionUID */
	private static final long serialVersionUID = -2449308994634687078L;

	@Id  
	public Long seq;

	@Required
	public String title;
	
	public String organizer;
	
	public Date update_at;
	
	@Valid
	@OneToMany(cascade = CascadeType.ALL, mappedBy="drink")
	public List<DrinkDate> dates;
	
	@Valid
	@OneToMany(cascade = CascadeType.ALL, mappedBy="drink")
	public List<DrinkMember> members;
	
	public List<String> joinMembers;
  
	public static Finder<Long, Drink> find = new Finder<Long, Drink>(
			Long.class, Drink.class
			);

	public static List<Drink> all() {
		return find.all();
	}
  
	public static void create(Drink drink) {
		drink.save();
	}
  
	public static void delete(Long id) {
		find.ref(id).delete();
	}
}