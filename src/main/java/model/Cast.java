package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cast database table.
 * 
 */
@Entity
public class Cast implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CastPK id;

	private String characterName;

	//bi-directional many-to-one association to Movy
	@ManyToOne
	@JoinColumn(name="program_tmsId",updatable=false,insertable=false)
	private Movy movy;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(updatable=false,insertable=false)
	private Person person;

	public Cast() {
	}

	public CastPK getId() {
		return this.id;
	}

	public void setId(CastPK id) {
		this.id = id;
	}

	public String getCharacterName() {
		return this.characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public Movy getMovy() {
		return this.movy;
	}

	public void setMovy(Movy movy) {
		this.movy = movy;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}