
package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import repositories.SocialIdentityRepository;
import security.Authority;
import security.LoginService;
import domain.Academy;
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

	@Autowired
	AcademyService				academyService;


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
		
		if(socialIdentity.getActor()!=null){
			Assert.isTrue(socialIdentity.getActor().getUserAccount().getUsername().equals(LoginService.getPrincipal().getUsername()), "notYourSocial");
		}else{
			Assert.isTrue(socialIdentity.getAcademy().getUserAccount().getUsername().equals(LoginService.getPrincipal().getUsername()), "notYourSocial");
		}
		
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
			Academy academy;
			academy = academyService.findByPrincipal();
			principal = actorService.findByPrincipal();

			Authority au = new Authority();
			au.setAuthority(Authority.STUDENT);

			Authority au1 = new Authority();
			au1.setAuthority(Authority.TEACHER);

			Authority au2 = new Authority();
			au2.setAuthority(Authority.ACADEMY);

			if (LoginService.getPrincipal().getAuthorities().contains(au) || LoginService.getPrincipal().getAuthorities().contains(au1)) {
				socialIdentity.setActor(principal);

			} else if (LoginService.getPrincipal().getAuthorities().contains(au2)) {
				socialIdentity.setAcademy(academy);
			}
			Collection<SocialIdentity>aux=socialIdentityRepository.findAll();
			Collection<String> all=new ArrayList<String>();
			for(SocialIdentity s:aux){
				all.add(s.getProfileUrl());
			}
			Assert.isTrue(!all.contains(socialIdentity.getProfileUrl()),"urlMustBeUnique");
			validator.validate(socialIdentity, binding);
		} else {
		SocialIdentity aux = socialIdentityRepository.findOne(socialIdentity.getId());

			socialIdentity.setId(aux.getId());
			socialIdentity.setVersion(aux.getVersion());

			if (aux.getActor()!=null) {
				socialIdentity.setActor(aux.getActor());

			} else{
				socialIdentity.setAcademy(aux.getAcademy());
			}
			Collection<SocialIdentity>aux2=socialIdentityRepository.findAll();
			aux2.remove(socialIdentity);
			Collection<String> all=new ArrayList<String>();
			for(SocialIdentity s:aux2){
				
				all.add(s.getProfileUrl());
			}
			
			Assert.isTrue(!all.contains(socialIdentity.getProfileUrl()),"urlMustBeUnique");
			validator.validate(socialIdentity, binding);
		}

		return socialIdentity;
	}

}
