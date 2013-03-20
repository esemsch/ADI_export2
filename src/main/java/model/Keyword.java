package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the keyword database table.
 * 
 */
@Entity
public class Keyword implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private KeywordPK id;

	private String value;

	//bi-directional many-to-one association to Movy
	@ManyToOne
	@JoinColumn(name="program_tmsId",updatable=false,insertable=false)
	private Movy movy;

	public Keyword() {
	}

	public KeywordPK getId() {
		return this.id;
	}

	public void setId(KeywordPK id) {
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

}