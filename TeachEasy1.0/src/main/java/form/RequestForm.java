
package form;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
@Access(AccessType.PROPERTY)
public class RequestForm {

	// Attributes ----------------------------------------------------

	private int			rClassId;
	private String		checkIn;
	private String		checkOut;


	// Constructor --------------------------------------------------

	public RequestForm() {
		super();
	}

	// Getters and Setters ------------------------------------------

	public int getrClassId() {
		return rClassId;
	}
	public void setrClassId(int rClassId) {
		this.rClassId = rClassId;
	}

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
}
