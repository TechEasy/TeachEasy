
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Course extends Class_ {

	// Constructors -----------------------------------------------------------

	public Course() {
		super();
	}


	// Attributes -------------------------------------------------------------
	private Integer	duration;
	private String	level;


	@NotNull
	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@NotBlank
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}


	// Relationships ----------------------------------------------------------
	private Academy				academy;
	private Collection<Matter>	matters;


	@NotNull
	@Valid
	@ManyToOne
	public Academy getAcademy() {
		return academy;
	}

	public void setAcademy(Academy academy) {
		this.academy = academy;
	}

	@ElementCollection
	@OneToMany(mappedBy = "course")
	public Collection<Matter> getMatters() {
		return matters;
	}

	public void setMatters(Collection<Matter> matters) {
		this.matters = matters;
	}

}
