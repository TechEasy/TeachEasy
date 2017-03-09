
package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Request extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public Request() {
		super();
	}


	// Attributes -------------------------------------------------------------
	private String	status;
	private Date	checkin;
	private Date	checkout;
	private String	day;


	@NotBlank
	@Pattern(regexp = "^PENDING$|^ACCEPTED$|^DENIED$)")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}


	// Relationships ----------------------------------------------------------
	private Class_	class_;
	private Student	student;


	@NotNull
	@Valid
	@ManyToOne
	public Class_ getClass_() {
		return class_;
	}

	public void setClass_(Class_ class_) {
		this.class_ = class_;
	}

	@NotNull
	@Valid
	@ManyToOne
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
