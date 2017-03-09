
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.WorkTimeRepository;
import domain.WorkTime;

@Service
@Transactional
public class WorkTimeService {

	// Managed repository

	@Autowired
	WorkTimeRepository	workTimeRepository;


	// Supporting services

	//Constructors
	public WorkTimeService() {
		super();

	}

	// Simple CRUD methods
	public WorkTime create() {
		WorkTime result;
		result = new WorkTime();
		return result;
	}

	public Collection<WorkTime> findAll() {
		Collection<WorkTime> result;
		result = workTimeRepository.findAll();
		return result;
	}

	public WorkTime findOne(int id) {
		WorkTime result;
		result = workTimeRepository.findOne(id);
		return result;
	}

	public WorkTime save(WorkTime workTime) {
		WorkTime result;
		result = workTimeRepository.save(workTime);
		return result;

	}

	public void delete(WorkTime workTime) {
		workTimeRepository.delete(workTime);
	}
}
