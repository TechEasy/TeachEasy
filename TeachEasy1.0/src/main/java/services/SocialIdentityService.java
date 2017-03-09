
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.SocialIdentityRepository;
import domain.SocialIdentity;

@Service
@Transactional
public class SocialIdentityService {

	// Managed repository

	@Autowired
	SocialIdentityRepository	socialIdentityRepository;


	// Supporting services

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
}
