package models;

import java.util.Date;

import play.data.format.Formats.DateTime;
import play.db.ebean.Model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DrinkTime extends Model {
	
	/** serialVersionUID */
	private static final long serialVersionUID = 5881153743663994790L;

	@Id  
	public Long id;

	@DateTime(pattern="yyyy/MM/dd")
	public Date date;

	@ManyToOne
	@JoinColumn(name = "drink_id")
	public Drink drink;
}