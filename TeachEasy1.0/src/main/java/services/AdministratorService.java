
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.AdministratorRepository;
import security.LoginService;
import security.UserAccount;
import domain.Administrator;

@Service
@Transactional
public class AdministratorService {

	// Managed repository

	@Autowired
	AdministratorRepository	administratorRepository;


	// Supporting services

	//Constructors
	public AdministratorService() {
		super();

	}

	// Simple CRUD methods
	public Administrator create() {
		Administrator result;
		result = new Administrator();
		return result;
	}

	public Collection<Administrator> findAll() {
		Collection<Administrator> result;
		result = administratorRepository.findAll();
		return result;
	}

	public Administrator findOne(int id) {
		Administrator result;
		result = administratorRepository.findOne(id);
		return result;
	}

	public Administrator save(Administrator administrator) {
		Administrator result;
		result = administratorRepository.save(administrator);
		return result;

	}

	public void delete(Administrator administrator) {
		administratorRepository.delete(administrator);
	}

	public Administrator findByPrincipal() {
		Administrator res;
		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();
		Assert.notNull(userAccount);

		res = this.administratorRepository.findActorByUserAccount(userAccount);
		Assert.notNull(res);

		return res;
	}
}
