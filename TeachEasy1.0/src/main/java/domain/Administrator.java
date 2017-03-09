
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class Administrator extends Actor {

	// Constructors -----------------------------------------------------------

	public Administrator() {
		super();
	}


	// Attributes -------------------------------------------------------------

	// Relationships ----------------------------------------------------------
	private Collection<Matter>	matters;


	@Valid
	@OneToMany
	public Collection<Matter> getMatters() {
		return matters;
	}

	public void setMatters(Collection<Matter> matters) {
		this.matters = matters;
	}
}
