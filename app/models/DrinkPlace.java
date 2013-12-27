package models;

import play.data.validation.Constraints.Pattern;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DrinkPlace extends Model {
	
	/** serialVersionUID */
	private static final long serialVersionUID = -744407330560387957L;

	@Id  
	public Long id;
	
	public String shopName;
	
	@Pattern(value = "^(http://|https://).*")
	public String shopUrl;
	
	@Required
	public String station;

	@ManyToOne
	@JoinColumn(name = "drink_id")
	public Drink drink;
}