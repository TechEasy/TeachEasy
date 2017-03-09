
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.FinderRepository;
import domain.Finder;

@Service
@Transactional
public class FinderService {

	// Managed repository

	@Autowired
	FinderRepository	finderRepository;


	// Supporting services

	//Constructors
	public FinderService() {
		super();

	}

	// Simple CRUD methods
	public Finder create() {
		Finder result;
		result = new Finder();
		return result;
	}

	public Collection<Finder> findAll() {
		Collection<Finder> result;
		result = finderRepository.findAll();
		return result;
	}

	public Finder findOne(int id) {
		Finder result;
		result = finderRepository.findOne(id);
		return result;
	}

	public Finder save(Finder finder) {
		Finder result;
		result = finderRepository.save(finder);
		return result;

	}

	public void delete(Finder finder) {
		finderRepository.delete(finder);
	}
}
