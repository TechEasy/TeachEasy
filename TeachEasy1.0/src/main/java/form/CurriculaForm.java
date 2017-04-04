
package form;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;

@Embeddable
@Access(AccessType.PROPERTY)
public class CurriculaForm {

	// Attributes -------------------------------------------------------------

	private String	educationSection;
	private String	experienceSection;
	private String	hobbiesSection;


	// Constructor --------------------------------------------------

	public CurriculaForm() {
		super();
	}

	// Getters and Setters ------------------------------------------

	@NotBlank
	@SafeHtml(whitelistType = WhiteListType.NONE)
	public String getEducationSection() {
		return educationSection;
	}

	public void setEducationSection(String educationSection) {
		this.educationSection = educationSection;
	}

	@NotBlank
	@SafeHtml(whitelistType = WhiteListType.NONE)
	public String getExperienceSection() {
		return experienceSection;
	}

	public void setExperienceSection(String experienceSection) {
		this.experienceSection = experienceSection;
	}

	@NotBlank
	@SafeHtml(whitelistType = WhiteListType.NONE)
	public String getHobbiesSection() {
		return hobbiesSection;
	}

	public void setHobbiesSection(String hobbiesSection) {
		this.hobbiesSection = hobbiesSection;
	}

}
