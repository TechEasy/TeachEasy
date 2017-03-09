
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.ActorRepository;
import security.LoginService;
import domain.Actor;

@Service
@Transactional
public class ActorService {

	// Managed repository

	@Autowired
	ActorRepository	actorRepository;


	// Supporting services

	//Constructors
	public ActorService() {
		super();

	}

	// Simple CRUD methods
	public Actor create() {
		Actor result;
		result = new Actor();
		return result;
	}

	public Collection<Actor> findAll() {
		Collection<Actor> result;
		result = actorRepository.findAll();
		return result;
	}

	public Actor findOne(int id) {
		Actor result;
		result = actorRepository.findOne(id);
		return result;
	}

	public Actor save(Actor actor) {
		Actor result;
		result = actorRepository.save(actor);
		return result;

	}

	public void delete(Actor actor) {
		actorRepository.delete(actor);
	}

	// Other business methods

	public Actor findByActorId(Integer id) {
		Actor result;
		result = actorRepository.findByActorId(id);
		return result;
	}

	public Actor findByPrincipal() {
		Actor result;
		Integer principalId;

		principalId = LoginService.getPrincipal().getId();
		result = findByActorId(principalId);

		return result;
	}
}
