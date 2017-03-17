
package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.CourseService;
import domain.Course;

@Controller
@RequestMapping("/course")
public class CourseController extends AbstractController {

	@Autowired
	CourseService	courseService;


	public CourseController() {
		super();

	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Course> courses;
		courses = courseService.findAll();
		result = new ModelAndView("course/list");
		result.addObject("courses", courses);

		return result;
	}
}
