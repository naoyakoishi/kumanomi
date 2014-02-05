package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import play.data.format.Formats.DateTime;
import play.db.ebean.Model;

@Entity
public class DrinkDate extends Model {
	
	/** serialVersionUID */
	private static final long serialVersionUID = 5881153743663994790L;

	@Id  
	public Long seq;

	@DateTime(pattern="yyyy/MM/dd")
	public Date date;

	@ManyToOne
	@JoinColumn(name = "drink_seq")
	public Drink drink;

	@Valid
	@OneToMany(cascade = CascadeType.ALL, mappedBy="date")
	public List<DrinkDecision> decisions;

	public static Finder<Long, DrinkDate> find = new Finder<Long, DrinkDate>(
			Long.class, DrinkDate.class
			);

	public static List<DrinkDate> all() {
		return find.all();
	}
  
	public static void create(DrinkDate drinkDate) {
		drinkDate.save();
	}
  
	public static void delete(Long id) {
		find.ref(id).delete();
	}
}