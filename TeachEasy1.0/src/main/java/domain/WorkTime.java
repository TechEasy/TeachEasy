
package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class WorkTime extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public WorkTime() {
		super();
	}


	// Attributes -------------------------------------------------------------
	private Date	checkin;
	private Date	checkout;
	private Boolean	available;


	@NotNull
	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	@NotNull
	@Future
	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	// Relationships ----------------------------------------------------------

}
