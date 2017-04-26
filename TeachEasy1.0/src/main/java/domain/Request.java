
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Request extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public Request() {
		super();
	}


	// Attributes -------------------------------------------------------------
	private String	status;
	private String	checkIn;
	private String	checkOut;
	private Boolean	paid;


	public Boolean getPaid() {
		return paid;
	}
	public void setPaid(Boolean paid) {
		this.paid = paid;
	}
	@NotBlank
	@Pattern(regexp = "^PENDING|ACCEPTED|DENIED$|WAITING$")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	public String getcheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}


	// Relationships ----------------------------------------------------------
	private Rclass	rclass;
	private Student	student;
	private Invoice	invoice;


	@Valid
	@OneToOne
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	@Valid
	@ManyToOne(optional = false)
	public Rclass getRclass() {
		return rclass;
	}
	public void setRclass(Rclass rclass) {
		this.rclass = rclass;
	}

	@Valid
	@ManyToOne(optional = false)
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

}
