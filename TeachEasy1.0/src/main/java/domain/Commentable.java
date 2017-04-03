
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public abstract class Commentable extends DomainEntity {

	public Commentable() {
		super();

	}


	//RelationShips
	private Collection<Comment>	comments;


	@Valid
	@OneToMany(mappedBy = "commentable")
	public Collection<Comment> getComments() {
		return this.comments;
	}

	public void setComments(final Collection<Comment> comments) {
		this.comments = comments;
	}

}
