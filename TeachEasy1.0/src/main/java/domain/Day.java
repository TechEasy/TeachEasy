
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
	private Collection<WorkTime>	workTimes;

	@Valid
	@OneToMany(cascade = CascadeType.ALL)
	public Collection<WorkTime> getWorkTimes() {
		return workTimes;
	}
	public void setWorkTimes(Collection<WorkTime> workTimes) {
		this.workTimes = workTimes;
	}

}
