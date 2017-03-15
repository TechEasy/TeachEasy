
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

import security.UserAccount;

@Entity
@Access(AccessType.PROPERTY)
public class Academy extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public Academy() {
		super();
	}


	// Attributes -------------------------------------------------------------
	private String	name;
	private String	city;
	private String	address;
	private String	description;
	private String	cif;
	private Double	avgStars;
	private Double	feeAmount;
	private String  iban;


	@NotBlank
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@NotBlank
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@NotBlank
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@NotBlank
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@NotBlank
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}

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
	private Collection<SocialIdentity>	socialIdentity;
	private UserAccount					userAccount;
	private Collection<Comment>			comments;
	private Collection<Course>			courses;


	@Valid
	@OneToMany(mappedBy="academy")
	public Collection<SocialIdentity> getSocialIdentity() {
		return socialIdentity;
	}
	public void setSocialIdentity(Collection<SocialIdentity> socialIdentity) {
		this.socialIdentity = socialIdentity;
	}

	@Valid
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	public UserAccount getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	@Valid
	@OneToMany(mappedBy = "academy")
	public Collection<Comment> getComments() {
		return comments;
	}
	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}

	@Valid
	@OneToMany(mappedBy = "academy")
	public Collection<Course> getCourses() {
		return courses;
	}

	public void setCourses(Collection<Course> courses) {
		this.courses = courses;
	}
}
