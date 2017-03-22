
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.RClassRepository;
import domain.Rclass;

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
	public Rclass create() {
		Rclass result;
		result = new Rclass();
		return result;
	}

	public Collection<Rclass> findAll() {
		Collection<Rclass> result;
		result = rClassRepository.findAll();
		return result;
	}

	public Rclass findOne(int id) {
		Rclass result;
		result = rClassRepository.findOne(id);
		return result;
	}

	public Rclass save(Rclass rclass) {
		Rclass result;
		result = rClassRepository.save(rclass);
		return result;

	}
	
	public Rclass findById(int id){
		return rClassRepository.findById(id);
	}

	public void delete(Rclass rclass) {
		rClassRepository.delete(rclass);
	}
}
