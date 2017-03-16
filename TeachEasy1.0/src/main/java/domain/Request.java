
package domain;

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
	private String	checkin;
	private String	checkout;
	private String	day;


	@NotBlank
	@Pattern(regexp = "^PENDING$|^ACCEPTED$|^DENIED$)")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@NotNull
	@Pattern(regexp = "^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$")
	public String getCheckin(){
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	@NotNull
	@Pattern(regexp = "^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$")
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	@NotBlank
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}


	// Relationships ----------------------------------------------------------
	private RClass	rClass;
	private Student	student;

	@Valid
	@ManyToOne(optional=false)
	public RClass getRClass(){
		return rClass;
	}
	public void setRClass(RClass rClass){
		this.rClass = rClass;
	}

	@Valid
	@ManyToOne(optional=false)
	public Student getStudent(){
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

}
