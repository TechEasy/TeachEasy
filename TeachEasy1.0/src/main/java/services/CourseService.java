
package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.CourseRepository;
import domain.Course;
import domain.Finder;

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
	public Collection<Course> findByFinder(Finder finder) {
		Collection<Course> result = new ArrayList<Course>();
		Collection<Course> aux;
		if (finder.getKeyword() == null) {
			aux = courseRepository.findByCity(finder.getCity());
		} else {
			aux = courseRepository.findByKey(finder.getKeyword(), finder.getCity());
		}
		if (finder.getMinimumPrice() == null && finder.getMaximumPrice() == null) {
			result = aux;
		} else if (finder.getMinimumPrice() == null) {
			for (Course p : aux) {
				if (p.getRate() <= finder.getMaximumPrice()) {
					result.add(p);
				}
			}
		} else if (finder.getMaximumPrice() == null) {
			for (Course p : aux) {
				if (p.getRate() >= finder.getMinimumPrice()) {
					result.add(p);
				}
			}
		} else {
			for (Course p : aux) {
				if (p.getRate() >= finder.getMinimumPrice() && p.getRate() <= finder.getMaximumPrice()) {
					result.add(p);
				}
			}
		}
		return result;

	}
}
