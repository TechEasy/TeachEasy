
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Fee extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public Fee() {
		super();
	}


	// Attributes -------------------------------------------------------------
	private Double	valueTeacher;
	private Double	valueAcademy;
	
	@NotNull
	@Min(0)
	@Digits(fraction=2,integer=3)
	public Double getValueTeacher() {
		return valueTeacher;
	}
	public void setValueTeacher(Double valueTeacher) {
		this.valueTeacher = valueTeacher;
	}
	
	@NotNull
	@Min(0)
	@Digits(fraction=2,integer=3)
	public Double getValueAcademy() {
		return valueAcademy;
	}
	public void setValueAcademy(Double valueAcademy) {
		this.valueAcademy = valueAcademy;
	}


	// Relationships ----------------------------------------------------------

}
