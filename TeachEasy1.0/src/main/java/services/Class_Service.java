
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.Class_Repository;
import domain.Class_;

@Service
@Transactional
public class Class_Service {

	// Managed repository

	@Autowired
	Class_Repository	class_Repository;


	// Supporting services

	//Constructors
	public Class_Service() {
		super();

	}

	// Simple CRUD methods
	public Class_ create() {
		Class_ result;
		result = new Class_();
		return result;
	}

	public Collection<Class_> findAll() {
		Collection<Class_> result;
		result = class_Repository.findAll();
		return result;
	}

	public Class_ findOne(int id) {
		Class_ result;
		result = class_Repository.findOne(id);
		return result;
	}

	public Class_ save(Class_ class_) {
		Class_ result;
		result = class_Repository.save(class_);
		return result;

	}

	public void delete(Class_ class_) {
		class_Repository.delete(class_);
	}
}
