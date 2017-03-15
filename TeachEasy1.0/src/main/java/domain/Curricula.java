
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

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
		return this.photo;
	}

	public void setPhoto(final String photo) {
		this.photo = photo;
	}

	@NotBlank
	public String getEducationSection() {
		return this.educationSection;
	}

	public void setEducationSection(final String educationSection) {
		this.educationSection = educationSection;
	}

	@NotBlank
	public String getExperienceSection() {
		return this.experienceSection;
	}

	public void setExperienceSection(final String experienceSection) {
		this.experienceSection = experienceSection;
	}

	@NotBlank
	public String getHobbiesSection() {
		return this.hobbiesSection;
	}

	public void setHobbiesSection(final String hobbiesSection) {
		this.hobbiesSection = hobbiesSection;
	}

	// Relationships ----------------------------------------------------------

}
