
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.CourseRepository;
import domain.Course;

@Service
@Transactional
public class CourseService {

	// Managed repository

	@Autowired
	CourseRepository	courseRepository;


	// Supporting services

	//Constructors
	public CourseService() {
		super();

	}

	// Simple CRUD methods
	public Course create() {
		Course result;
		result = new Course();
		return result;
	}

	public Collection<Course> findAll() {
		Collection<Course> result;
		result = courseRepository.findAll();
		return result;
	}

	public Course findOne(int id) {
		Course result;
		result = courseRepository.findOne(id);
		return result;
	}

	public Course save(Course course) {
		Course result;
		result = courseRepository.save(course);
		return result;

	}

	public void delete(Course course) {
		courseRepository.delete(course);
	}
}
