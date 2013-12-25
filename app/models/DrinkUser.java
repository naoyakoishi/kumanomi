package models;

import play.db.ebean.Model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DrinkUser extends Model {
	
	/** serialVersionUID */
	private static final long serialVersionUID = -5307248167610902268L;

	@Id  
	public Long id;

	public String userId;
	
	public String name;

	@ManyToOne
	@JoinColumn(name = "drink_id")
	public Drink drink;
}