
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repositories.CommentableRepository;
import domain.Commentable;

@Service
@Transactional
public class CommentableService {

	// Managed repository

	@Autowired
	CommentableRepository	commentableRepository;


	// Supporting services

	//Constructors
	public CommentableService() {
		super();

	}

	public Collection<Commentable> findAll() {
		Collection<Commentable> result;
		result = this.commentableRepository.findAll();
		return result;
	}

	public Commentable findOne(final int id) {
		Commentable result;
		result = this.commentableRepository.findOne(id);
		return result;
	}
	public Commentable save(final Commentable commentable) {
		Commentable result;
		result = this.commentableRepository.save(commentable);
		return result;

	}
	public void delete(final Commentable commentable) {
		this.commentableRepository.delete(commentable);
	}

}
