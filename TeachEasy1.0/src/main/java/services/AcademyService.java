
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.AcademyRepository;
import domain.Academy;

@Service
@Transactional
public class AcademyService {

	// Managed repository

	@Autowired
	AcademyRepository	academyRepository;


	// Supporting services

	//Constructors
	public AcademyService() {
		super();

	}

	// Simple CRUD methods
	public Academy create() {
		Academy result;
		result = new Academy();
		return result;
	}

	public Collection<Academy> findAll() {
		Collection<Academy> result;
		result = academyRepository.findAll();
		return result;
	}

	public Academy findOne(int id) {
		Academy result;
		result = academyRepository.findOne(id);
		return result;
	}

	public Academy save(Academy academy) {
		Academy result;
		result = academyRepository.save(academy);
		return result;

	}

	public void delete(Academy academy) {
		academyRepository.delete(academy);
	}
}
