
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.MatterRepository;
import domain.Matter;

@Service
@Transactional
public class MatterService {

	// Managed repository

	@Autowired
	MatterRepository	matterRepository;


	// Supporting services

	//Constructors
	public MatterService() {
		super();

	}

	// Simple CRUD methods
	public Matter create() {
		Matter result;
		result = new Matter();
		return result;
	}

	public Collection<Matter> findAll() {
		Collection<Matter> result;
		result = matterRepository.findAll();
		return result;
	}

	public Matter findOne(int id) {
		Matter result;
		result = matterRepository.findOne(id);
		return result;
	}

	public Matter save(Matter matter) {
		Matter result;
		result = matterRepository.save(matter);
		return result;

	}

	public void delete(Matter matter) {
		matterRepository.delete(matter);
	}
}
