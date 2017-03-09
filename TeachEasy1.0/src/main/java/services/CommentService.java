
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.CommentRepository;
import domain.Comment;

@Service
@Transactional
public class CommentService {

	// Managed repository

	@Autowired
	CommentRepository	commentRepository;


	// Supporting services

	//Constructors
	public CommentService() {
		super();

	}

	// Simple CRUD methods
	public Comment create() {
		Comment result;
		result = new Comment();
		return result;
	}

	public Collection<Comment> findAll() {
		Collection<Comment> result;
		result = commentRepository.findAll();
		return result;
	}

	public Comment findOne(int id) {
		Comment result;
		result = commentRepository.findOne(id);
		return result;
	}

	public Comment save(Comment comment) {
		Comment result;
		result = commentRepository.save(comment);
		return result;

	}

	public void delete(Comment comment) {
		commentRepository.delete(comment);
	}
}
