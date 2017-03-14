
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.RClassRepository;
import domain.RClass;

@Service
@Transactional
public class Class_Service {

	// Managed repository

	@Autowired
	RClassRepository	class_Repository;


	// Supporting services

	//Constructors
	public Class_Service() {
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
		result = class_Repository.findAll();
		return result;
	}

	public RClass findOne(int id) {
		RClass result;
		result = class_Repository.findOne(id);
		return result;
	}

	public RClass save(RClass class_) {
		RClass result;
		result = class_Repository.save(class_);
		return result;

	}

	public void delete(RClass class_) {
		class_Repository.delete(class_);
	}
}
