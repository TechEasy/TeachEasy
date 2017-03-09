
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.StudentRepository;
import domain.Student;

@Service
@Transactional
public class StudentService {

	// Managed repository

	@Autowired
	StudentRepository	studentRepository;


	// Supporting services

	//Constructors
	public StudentService() {
		super();

	}

	// Simple CRUD methods
	public Student create() {
		Student result;
		result = new Student();
		return result;
	}

	public Collection<Student> findAll() {
		Collection<Student> result;
		result = studentRepository.findAll();
		return result;
	}

	public Student findOne(int id) {
		Student result;
		result = studentRepository.findOne(id);
		return result;
	}

	public Student save(Student student) {
		Student result;
		result = studentRepository.save(student);
		return result;

	}

	public void delete(Student student) {
		studentRepository.delete(student);
	}
}
