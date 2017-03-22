
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.RClassRepository;
import domain.RClass;

@Service
@Transactional
public class RClassService {

	// Managed repository

	@Autowired
	private RClassRepository	rClassRepository;


	// Supporting services

	//Constructors
	public RClassService() {
		super();

	}

	// Simple CRUD methods
	public RClass create() {
		RClass result;
		result = new RClass();
		return result;
	}

	public Collection<RClass> findAll() {
		Collection<RClass> result;
		result = rClassRepository.findAll();
		return result;
	}

	public RClass findOne(int id) {
		RClass result;
		result = rClassRepository.findOne(id);
		return result;
	}

	public RClass save(RClass rClass) {
		RClass result;
		result = rClassRepository.save(rClass);
		return result;

	}
	
	public RClass findById(int id){
		return rClassRepository.findById(id);
	}

	public void delete(RClass rClass) {
		rClassRepository.delete(rClass);
	}
}
