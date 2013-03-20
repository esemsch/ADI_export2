package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ratingtype database table.
 * 
 */
@Entity
public class Ratingtype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String body;

	//bi-directional many-to-one association to Rating
	@OneToMany(mappedBy="ratingtype")
	private List<Rating> ratings;

	public Ratingtype() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<Rating> getRatings() {
		return this.ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public Rating addRating(Rating rating) {
		getRatings().add(rating);
		rating.setRatingtype(this);

		return rating;
	}

	public Rating removeRating(Rating rating) {
		getRatings().remove(rating);
		rating.setRatingtype(null);

		return rating;
	}

}