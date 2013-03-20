package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the cast database table.
 * 
 */
@Embeddable
public class CastPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int billingOrder;

	private String person_personId;

	private String program_tmsId;

	public CastPK() {
	}
	public int getBillingOrder() {
		return this.billingOrder;
	}
	public void setBillingOrder(int billingOrder) {
		this.billingOrder = billingOrder;
	}
	public String getPerson_personId() {
		return this.person_personId;
	}
	public void setPerson_personId(String person_personId) {
		this.person_personId = person_personId;
	}
	public String getProgram_tmsId() {
		return this.program_tmsId;
	}
	public void setProgram_tmsId(String program_tmsId) {
		this.program_tmsId = program_tmsId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CastPK)) {
			return false;
		}
		CastPK castOther = (CastPK)other;
		return 
			(this.billingOrder == castOther.billingOrder)
			&& this.person_personId.equals(castOther.person_personId)
			&& this.program_tmsId.equals(castOther.program_tmsId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.billingOrder;
		hash = hash * prime + this.person_personId.hashCode();
		hash = hash * prime + this.program_tmsId.hashCode();
		
		return hash;
	}
}