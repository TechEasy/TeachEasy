
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Fee extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public Fee() {
		super();
	}


	// Attributes -------------------------------------------------------------
	private Double	value;


	@NotBlank
	@Min(0)
	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}


	// Relationships ----------------------------------------------------------

}
