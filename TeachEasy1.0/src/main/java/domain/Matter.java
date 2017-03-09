
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Matter extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public Matter() {
		super();
	}


	// Attributes -------------------------------------------------------------
	private String	name;
	private String	description;
	private Boolean	validated;


	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotBlank
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getValidated() {
		return validated;
	}

	public void setValidated(Boolean validated) {
		this.validated = validated;
	}

	// Relationships ----------------------------------------------------------

}
