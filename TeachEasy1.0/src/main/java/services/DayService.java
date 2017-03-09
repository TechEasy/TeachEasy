
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.DayRepository;
import domain.Day;

@Service
@Transactional
public class DayService {

	// Managed repository

	@Autowired
	DayRepository	dayRepository;


	// Supporting services

	//Constructors
	public DayService() {
		super();

	}

	// Simple CRUD methods
	public Day create() {
		Day result;
		result = new Day();
		return result;
	}

	public Collection<Day> findAll() {
		Collection<Day> result;
		result = dayRepository.findAll();
		return result;
	}

	public Day findOne(int id) {
		Day result;
		result = dayRepository.findOne(id);
		return result;
	}

	public Day save(Day day) {
		Day result;
		result = dayRepository.save(day);
		return result;

	}

	public void delete(Day day) {
		dayRepository.delete(day);
	}
}
