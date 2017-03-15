package form;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;

@Embeddable
@Access(AccessType.PROPERTY)
public class FinderForm {
	// Attributes ------------------------------
	private String	city;
	private Double	minimumPrice;
	private Double	maximumPrice;
	private String	keyword;
	private String	matter;
	
	// Constructor --------------------------------------------------

		public FinderForm() {
			super();
		}
		@NotBlank
		@SafeHtml(whitelistType = WhiteListType.NONE)
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
		@SafeHtml(whitelistType = WhiteListType.NONE)
		public String getKeyword() {
			return keyword;
		}
		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}
		@NotBlank
		@SafeHtml(whitelistType = WhiteListType.NONE)
		public String getMatter() {
			return this.matter;
		}

		public void setMatter(final String matter) {
			this.matter = matter;
		}

		
}
