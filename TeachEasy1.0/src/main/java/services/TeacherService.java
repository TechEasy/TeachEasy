
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.TeacherRepository;
import domain.Teacher;

@Service
@Transactional
public class TeacherService {

	// Managed repository

	@Autowired
	TeacherRepository	teacherRepository;


	// Supporting services

	//Constructors
	public TeacherService() {
		super();

	}

	// Simple CRUD methods
	public Teacher create() {
		Teacher result;
		result = new Teacher();
		return result;
	}

	public Collection<Teacher> findAll() {
		Collection<Teacher> result;
		result = teacherRepository.findAll();
		return result;
	}

	public Teacher findOne(int id) {
		Teacher result;
		result = teacherRepository.findOne(id);
		return result;
	}

	public Teacher save(Teacher teacher) {
		Teacher result;
		result = teacherRepository.save(teacher);
		return result;

	}

	public void delete(Teacher teacher) {
		teacherRepository.delete(teacher);
	}
}
