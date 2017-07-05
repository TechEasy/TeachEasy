
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Curricula extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public Curricula() {
		super();
	}


	// Attributes -------------------------------------------------------------
	private String	educationSection;
	private String	experienceSection;
	private String	hobbiesSection;

	@NotNull
	public String getEducationSection() {
		return this.educationSection;
	}

	public void setEducationSection(final String educationSection) {
		this.educationSection = educationSection;
	}

	@NotNull
	public String getExperienceSection() {
		return this.experienceSection;
	}

	public void setExperienceSection(final String experienceSection) {
		this.experienceSection = experienceSection;
	}

	@NotNull
	public String getHobbiesSection() {
		return this.hobbiesSection;
	}

	public void setHobbiesSection(final String hobbiesSection) {
		this.hobbiesSection = hobbiesSection;
	}

	// Relationships ----------------------------------------------------------
	private Teacher	teacher;
	
	@OneToOne(optional= false)
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
}
