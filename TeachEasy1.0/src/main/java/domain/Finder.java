
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Finder extends DomainEntity {

	private String	city;
	private Double	minimumPrice;
	private Double	maximumPrice;
	private String	keyword;
	private String	matter;


	public Finder() {
		super();
	}

	@NotBlank
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Digits(fraction = 2, integer = 5)
	public Double getMinimumPrice() {
		return minimumPrice;
	}

	public void setMinimumPrice(Double minimumPrice) {
		this.minimumPrice = minimumPrice;
	}

	@Digits(fraction = 2, integer = 5)
	public Double getMaximumPrice() {
		return maximumPrice;
	}

	public void setMaximumPrice(Double maximumPrice) {
		this.maximumPrice = maximumPrice;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@NotBlank
	public String getMatter() {
		return matter;
	}

	public void setMatter(String matter) {
		this.matter = matter;
	}


	// Relationships ----------------------------------------------------------

	private Student				student;
	private Collection<Class_>	results;


	@Valid
	@NotNull
	@OneToOne(optional = true)
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToMany
	public Collection<Class_> getResults() {
		return results;
	}

	public void setResults(Collection<Class_> results) {
		this.results = results;
	}
}
