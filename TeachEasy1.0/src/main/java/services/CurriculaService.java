
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.CurriculaRepository;
import domain.Curricula;

@Service
@Transactional
public class CurriculaService {

	// Managed repository

	@Autowired
	CurriculaRepository	curriculaRepository;


	// Supporting services

	//Constructors
	public CurriculaService() {
		super();

	}

	// Simple CRUD methods
	public Curricula create() {
		Curricula result;
		result = new Curricula();
		return result;
	}

	public Collection<Curricula> findAll() {
		Collection<Curricula> result;
		result = curriculaRepository.findAll();
		return result;
	}

	public Curricula findOne(int id) {
		Curricula result;
		result = curriculaRepository.findOne(id);
		return result;
	}

	public Curricula save(Curricula curricula) {
		Curricula result;
		result = curriculaRepository.save(curricula);
		return result;

	}

	public void delete(Curricula curricula) {
		curriculaRepository.delete(curricula);
	}
}
