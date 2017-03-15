
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Teacher extends Actor {

	// Constructors -----------------------------------------------------------

	public Teacher() {
		super();
	}


	// Attributes -------------------------------------------------------------
	private Double	avgStars;
	private Double	feeAmount;
	private String 	iban;


	public Double getAvgStars() {
		return avgStars;
	}

	public void setAvgStars(Double avgStars) {
		this.avgStars = avgStars;
	}

	public Double getFeeAmount() {
		return feeAmount;
	}

	public void setFeeAmount(Double feeAmount) {
		this.feeAmount = feeAmount;
	}

	@NotBlank
	@Pattern(regexp = "^ES\\d{22}$")
	public String getIban(){
		return iban;
	}
	public void setIban(String iban){
		this.iban=iban;
	}

	// Relationships ----------------------------------------------------------
	private Curricula			curricula;
	private Collection<Comment>	comments;
	private TimeTable			timeTable;


	@Valid
	@OneToMany(mappedBy = "teacher")
	public Collection<Comment> getComments() {
		return comments;
	}

	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}

	@Valid
	@OneToOne(optional = true, cascade = CascadeType.ALL)
	public TimeTable getTimeTable() {
		return timeTable;
	}

	public void setTimeTable(TimeTable timeTable) {
		this.timeTable = timeTable;
	}

	@Valid
	@OneToOne(optional = true, cascade = CascadeType.ALL)
	public Curricula getCurricula() {
		return curricula;
	}

	public void setCurricula(Curricula curricula) {
		this.curricula = curricula;
	}
}
