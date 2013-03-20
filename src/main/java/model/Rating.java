package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rating database table.
 * 
 */
@Entity
public class Rating implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RatingPK id;

	private String value;

	//bi-directional many-to-one association to Movy
	@ManyToOne
	@JoinColumn(name="program_tmsId",updatable=false,insertable=false)
	private Movy movy;

	//bi-directional many-to-one association to Ratingtype
	@ManyToOne
	@JoinColumn(name="type_id",updatable=false,insertable=false)
	private Ratingtype ratingtype;

	public Rating() {
	}

	public RatingPK getId() {
		return this.id;
	}

	public void setId(RatingPK id) {
		this.id = id;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Movy getMovy() {
		return this.movy;
	}

	public void setMovy(Movy movy) {
		this.movy = movy;
	}

	public Ratingtype getRatingtype() {
		return this.ratingtype;
	}

	public void setRatingtype(Ratingtype ratingtype) {
		this.ratingtype = ratingtype;
	}

}