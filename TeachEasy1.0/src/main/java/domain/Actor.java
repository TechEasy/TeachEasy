
package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import security.UserAccount;

@Entity
@Access(AccessType.PROPERTY)
public class Actor extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public Actor() {
		super();
	}


	// Attributes -------------------------------------------------------------
	private String		name;
	private String		surname;
	private String		email;
	private String		phone;
	private String		picture;
	private Date		date;
	private String		city;
	private String		address;
	private String 		iban;

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotBlank
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Email
	@NotBlank
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Pattern(regexp = "^([+]\\d{1,3})?[ ]?(\\d{9})")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@NotBlank
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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


	@Valid
	@OneToMany(mappedBy="actor")
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
}
