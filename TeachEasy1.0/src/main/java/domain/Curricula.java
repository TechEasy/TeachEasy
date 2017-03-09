
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class Curricula extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public Curricula() {
		super();
	}


	// Attributes -------------------------------------------------------------
	private String	photo;

	private String	educationSection;

	private String	experienceSection;

	private String	hobbiesSection;


	@URL
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@NotBlank
	public String getEducationSection() {
		return educationSection;
	}

	public void setEducationSection(String educationSection) {
		this.educationSection = educationSection;
	}

	@NotBlank
	public String getExperienceSection() {
		return experienceSection;
	}

	public void setExperienceSection(String experienceSection) {
		this.experienceSection = experienceSection;
	}

	@NotBlank
	public String getHobbiesSection() {
		return hobbiesSection;
	}

	public void setHobbiesSection(String hobbiesSection) {
		this.hobbiesSection = hobbiesSection;
	}


	// Relationships ----------------------------------------------------------
	private Teacher	teacher;


	@Valid
	@OneToOne(optional = false)
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
