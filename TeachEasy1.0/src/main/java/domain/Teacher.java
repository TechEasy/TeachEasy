
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.Email;

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
	private String	paypalMail;


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

	@Email
	public String getPaypalMail() {
		return paypalMail;
	}
	public void setPaypalMail(String paypalMail) {
		this.paypalMail = paypalMail;
	}


	// Relationships ----------------------------------------------------------
	private Curricula				curricula;
	private Collection<Proposal>	proposals;

	@Valid
	@OneToOne(optional = true, cascade = CascadeType.ALL)
	public Curricula getCurricula() {
		return curricula;
	}

	public void setCurricula(Curricula curricula) {
		this.curricula = curricula;
	}

	@Valid
	@OneToMany(mappedBy = "teacher")
	public Collection<Proposal> getProposals() {
		return proposals;
	}

	public void setProposals(Collection<Proposal> proposals) {
		this.proposals = proposals;
	}
}
