
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.Min;

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
	private Double	valueStudent;
	private Double	valueStandard;
	
	@Min(0)
	public Double getValueTeacher() {
		return valueTeacher;
	}
	public void setValueTeacher(Double valueTeacher) {
		this.valueTeacher = valueTeacher;
	}
	
	@Min(0)
	public Double getValueAcademy() {
		return valueAcademy;
	}
	public void setValueAcademy(Double valueAcademy) {
		this.valueAcademy = valueAcademy;
	}
	
	@Min(0)
	public Double getValueStudent() {
		return valueStudent;
	}
	public void setValueStudent(Double valueStudent) {
		this.valueStudent = valueStudent;
	}
	
	@Min(0)
	public Double getValueStandard() {
		return valueStandard;
	}
	public void setValueStandard(Double valueStandard) {
		this.valueStandard = valueStandard;
	}


	// Relationships ----------------------------------------------------------

}
