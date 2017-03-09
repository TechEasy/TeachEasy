
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.TimeTableRepository;
import domain.TimeTable;

@Service
@Transactional
public class TimeTableService {

	// Managed repository

	@Autowired
	TimeTableRepository	timeTableRepository;


	// Supporting services

	//Constructors
	public TimeTableService() {
		super();

	}

	// Simple CRUD methods
	public TimeTable create() {
		TimeTable result;
		result = new TimeTable();
		return result;
	}

	public Collection<TimeTable> findAll() {
		Collection<TimeTable> result;
		result = timeTableRepository.findAll();
		return result;
	}

	public TimeTable findOne(int id) {
		TimeTable result;
		result = timeTableRepository.findOne(id);
		return result;
	}

	public TimeTable save(TimeTable timeTable) {
		TimeTable result;
		result = timeTableRepository.save(timeTable);
		return result;

	}

	public void delete(TimeTable timeTable) {
		timeTableRepository.delete(timeTable);
	}
}
