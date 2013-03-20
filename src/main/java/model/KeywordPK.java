package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the keyword database table.
 * 
 */
@Embeddable
public class KeywordPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String program_tmsId;

	private int sortOrder;

	private String type;

	public KeywordPK() {
	}
	public String getProgram_tmsId() {
		return this.program_tmsId;
	}
	public void setProgram_tmsId(String program_tmsId) {
		this.program_tmsId = program_tmsId;
	}
	public int getSortOrder() {
		return this.sortOrder;
	}
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof KeywordPK)) {
			return false;
		}
		KeywordPK castOther = (KeywordPK)other;
		return 
			this.program_tmsId.equals(castOther.program_tmsId)
			&& (this.sortOrder == castOther.sortOrder)
			&& this.type.equals(castOther.type);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.program_tmsId.hashCode();
		hash = hash * prime + this.sortOrder;
		hash = hash * prime + this.type.hashCode();
		
		return hash;
	}
}