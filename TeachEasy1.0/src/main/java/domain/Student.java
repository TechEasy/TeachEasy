
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class Student extends Actor {

	// Constructors -----------------------------------------------------------

	public Student() {
		super();
	}


	// Attributes -------------------------------------------------------------

	// Relationships ----------------------------------------------------------
	private Finder				finder;
	private Collection<Request>	requests;
	private Collection<Comment>	comments;


	@Valid
	@OneToOne
	public Finder getFinder() {
		return finder;
	}
	public void setFinder(Finder finder) {
		this.finder = finder;
	}

	@Valid
	@OneToMany(mappedBy = "student")
	public Collection<Request> getRequests() {
		return requests;
	}

	public void setRequests(Collection<Request> requests) {
		this.requests = requests;
	}

	@Valid
	@OneToMany(mappedBy = "student")
	public Collection<Comment> getComments() {
		return comments;
	}

	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}

}
