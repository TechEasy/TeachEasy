
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Proposal extends RClass {

	// Constructors -----------------------------------------------------------

	public Proposal() {
		super();
	}


	// Attributes -------------------------------------------------------------

	// Relationships ----------------------------------------------------------
	private Collection<Matter>	matters;
	private Teacher				teacher;


	@Valid
	@OneToMany
	public Collection<Matter> getMatters() {
		return matters;
	}

	public void setMatters(Collection<Matter> matters) {
		this.matters = matters;
	}

	@NotNull
	@Valid
	@ManyToOne
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
