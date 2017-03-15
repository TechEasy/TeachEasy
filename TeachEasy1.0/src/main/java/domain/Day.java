
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Day extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public Day() {
		super();
	}


	// Attributes -------------------------------------------------------------
	private String	name;


	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	// Relationships ----------------------------------------------------------
	private WorkTime	workTime;

	@Valid
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	public WorkTime getWorkTime() {
		return workTime;
	}
	public void setWorkTime(WorkTime workTime) {
		this.workTime = workTime;
	}

}
