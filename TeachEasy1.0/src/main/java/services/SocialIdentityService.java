
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import repositories.SocialIdentityRepository;
import domain.Actor;
import domain.SocialIdentity;

@Service
@Transactional
public class SocialIdentityService {

	// Managed repository

	@Autowired
	SocialIdentityRepository	socialIdentityRepository;

	// Supporting services
	@Autowired
	ActorService				actorService;


	//Constructors
	public SocialIdentityService() {
		super();

	}

	// Simple CRUD methods
	public SocialIdentity create() {
		SocialIdentity result;
		result = new SocialIdentity();
		return result;
	}

	public Collection<SocialIdentity> findAll() {
		Collection<SocialIdentity> result;
		result = socialIdentityRepository.findAll();
		return result;
	}

	public SocialIdentity findOne(int id) {
		SocialIdentity result;
		result = socialIdentityRepository.findOne(id);
		return result;
	}

	public SocialIdentity save(SocialIdentity socialIdentity) {
		SocialIdentity result;
		result = socialIdentityRepository.save(socialIdentity);
		return result;

	}

	public void delete(SocialIdentity socialIdentity) {
		socialIdentityRepository.delete(socialIdentity);
	}


	@Autowired
	private Validator	validator;


	public SocialIdentity reconstruct(SocialIdentity socialIdentity, BindingResult binding) {

		if (socialIdentity.getId() == 0) {
			Actor principal;

			principal = actorService.findByPrincipal();
			socialIdentity.setActor(principal);

			validator.validate(socialIdentity, binding);
		} else {
			SocialIdentity aux = socialIdentityRepository.findOne(socialIdentity.getId());
			socialIdentity.setId(aux.getId());
			socialIdentity.setVersion(aux.getVersion());
			socialIdentity.setActor(aux.getActor());
			validator.validate(socialIdentity, binding);
		}

		return socialIdentity;
	}

}
