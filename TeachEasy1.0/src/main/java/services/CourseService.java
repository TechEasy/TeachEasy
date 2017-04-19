
package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.CourseRepository;
import domain.Academy;
import domain.Course;
import domain.Finder;

@Service
@Transactional
public class CourseService {

	// Managed repository

	@Autowired
	CourseRepository	courseRepository;

	// Supporting services

	@Autowired
	AcademyService		academyService;


	//Constructors
	public CourseService() {
		super();

	}

	// Simple CRUD methods
	public Course create() {
		Course result;
		Academy a = academyService.findByPrincipal();
		result = new Course();
		result.setAcademy(a);
		result.setCreateMoment(new Date());
		result.setUpdateMoment(new Date());
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
		result = new Course();
		Date date = new Date(System.currentTimeMillis() - 1000);
		result.setUpdateMoment(date);
		result = courseRepository.save(course);
		return result;

	}

	public void delete(Course course) {
		courseRepository.delete(course);
	}
	public Collection<Course> findByFinder(Finder finder) {
		Collection<Course> result = new ArrayList<Course>();
		Collection<Course> aux;
		if (finder.getKeyword() == null && finder.getMatter() == null) {
			aux = courseRepository.findByCity(finder.getCity());
		} else if (finder.getMatter() == null) {
			aux = courseRepository.findByKey(finder.getKeyword(), finder.getCity());
		} else if (finder.getKeyword() == null) {
			aux = courseRepository.findByMatter(finder.getMatter(), finder.getCity());
		} else {
			aux = courseRepository.findByMatterAndKey(finder.getMatter(), finder.getCity(), finder.getKeyword());
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

	public Collection<Course> findByCreator(Academy academy) {
		Collection<Course> result = courseRepository.findByCreator(academy);
		return result;
	}
}
