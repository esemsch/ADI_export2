package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rating database table.
 * 
 */
@Embeddable
public class RatingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String program_tmsId;

	@Column(name="type_id")
	private int typeId;

	public RatingPK() {
	}
	public String getProgram_tmsId() {
		return this.program_tmsId;
	}
	public void setProgram_tmsId(String program_tmsId) {
		this.program_tmsId = program_tmsId;
	}
	public int getTypeId() {
		return this.typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RatingPK)) {
			return false;
		}
		RatingPK castOther = (RatingPK)other;
		return 
			this.program_tmsId.equals(castOther.program_tmsId)
			&& (this.typeId == castOther.typeId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.program_tmsId.hashCode();
		hash = hash * prime + this.typeId;
		
		return hash;
	}
}