
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;

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
		return this.city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	@Digits(fraction = 2, integer = 5)
	public Double getMinimumPrice() {
		return this.minimumPrice;
	}

	public void setMinimumPrice(final Double minimumPrice) {
		this.minimumPrice = minimumPrice;
	}

	@Digits(fraction = 2, integer = 5)
	public Double getMaximumPrice() {
		return this.maximumPrice;
	}

	public void setMaximumPrice(final Double maximumPrice) {
		this.maximumPrice = maximumPrice;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(final String keyword) {
		this.keyword = keyword;
	}

	@NotBlank
	public String getMatter() {
		return this.matter;
	}

	public void setMatter(final String matter) {
		this.matter = matter;
	}


	// Relationships ----------------------------------------------------------
	private Collection<RClass>	rClasses;


	@OneToMany
	public Collection<RClass> getResults() {
		return this.rClasses;
	}
	public void setResults(Collection<RClass> rClasses) {
		this.rClasses = rClasses;
	}
}
