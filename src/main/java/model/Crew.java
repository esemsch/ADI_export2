package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the crew database table.
 * 
 */
@Entity
public class Crew implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CrewPK id;

	private String role;

	//bi-directional many-to-one association to Movy
	@ManyToOne
	@JoinColumn(name="program_tmsId",updatable=false,insertable=false)
	private Movy movy;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(updatable=false,insertable=false)
	private Person person;

	public Crew() {
	}

	public CrewPK getId() {
		return this.id;
	}

	public void setId(CrewPK id) {
		this.id = id;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
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