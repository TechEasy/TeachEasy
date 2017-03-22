
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.RclassRepository;
import domain.Rclass;

@Service
@Transactional
public class RClassService {

	// Managed repository

	@Autowired
	private RclassRepository	rclassRepository;


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
		result = rclassRepository.findAll();
		return result;
	}

	public Rclass findOne(int id) {
		Rclass result;
		result = rclassRepository.findOne(id);
		return result;
	}

	public Rclass save(Rclass rclass) {
		Rclass result;
		result = rclassRepository.save(rclass);
		return result;

	}
	
	public Rclass findById(int id){
		return rclassRepository.findById(id);
	}

	public void delete(Rclass rclass) {
		rclassRepository.delete(rclass);
	}
}
