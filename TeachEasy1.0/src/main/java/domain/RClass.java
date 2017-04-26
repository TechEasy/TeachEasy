
package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Rclass extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public Rclass() {
		super();
	}


	// Attributes -------------------------------------------------------------
	private String	title;
	private Date	createMoment;
	private Date	updateMoment;
	private Double	rate;
	private Boolean	available;


	@NotBlank
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	public Date getCreateMoment() {
		return createMoment;
	}
	public void setCreateMoment(Date createMoment) {
		this.createMoment = createMoment;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	public Date getUpdateMoment() {
		return updateMoment;
	}
	public void setUpdateMoment(Date updateMoment) {
		this.updateMoment = updateMoment;
	}

	@NotNull
	@Min(0)
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}


	// Relationships ----------------------------------------------------------
	private Collection<Request>	requests;
	private SubjectMatter		subjectMatter;


	@OneToMany(mappedBy = "rclass")
	public Collection<Request> getRequests() {
		return requests;
	}
	public void setRequests(Collection<Request> requests) {
		this.requests = requests;
	}

	@Valid
	@ManyToOne(optional = false)
	public SubjectMatter getSubjectMatter() {
		return subjectMatter;
	}
	public void setSubjectMatter(SubjectMatter subjectMatter) {
		this.subjectMatter = subjectMatter;
	}

}
