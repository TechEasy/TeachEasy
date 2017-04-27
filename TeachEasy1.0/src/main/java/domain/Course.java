
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;

@Entity
@Access(AccessType.PROPERTY)
public class Course extends Rclass {

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

	@SafeHtml(whitelistType = WhiteListType.NONE)
	@NotBlank
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}


	// Relationships ----------------------------------------------------------
	private Academy	academy;


	@Valid
	@ManyToOne(optional = false)
	public Academy getAcademy() {
		return academy;
	}
	public void setAcademy(Academy academy) {
		this.academy = academy;
	}

}
