
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.FeeRepository;
import domain.Fee;

@Service
@Transactional
public class FeeService {

	// Managed repository

	@Autowired
	FeeRepository	feeRepository;


	// Supporting services

	//Constructors
	public FeeService() {
		super();

	}

	// Simple CRUD methods
	public Fee create() {
		Fee result;
		result = new Fee();
		return result;
	}

	public Collection<Fee> findAll() {
		Collection<Fee> result;
		result = feeRepository.findAll();
		return result;
	}

	public Fee findOne(int id) {
		Fee result;
		result = feeRepository.findOne(id);
		return result;
	}

	public Fee save(Fee Fee) {
		Fee result;
		result = feeRepository.save(Fee);
		return result;

	}

	public void delete(Fee Fee) {
		feeRepository.delete(Fee);
	}
	
	public Fee find() {
		Collection<Fee> result;
		result = feeRepository.findAll();
		return result.iterator().next();
	}
}
