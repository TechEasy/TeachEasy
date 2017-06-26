package controllers.Student;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.CourseService;
import services.FinderService;


import domain.Course;
import domain.Finder;
import form.FinderForm;
@Controller
@RequestMapping("/student/finder/course")
public class StudentFindCourseController {
	//Services-------------------------

			@Autowired
			private FinderService	finderService;
			
			
			
			@Autowired
			private CourseService courseService;
			
		//Constructor----------------------

			public StudentFindCourseController() {
				super();
			}
	//Display--------------------------

	@RequestMapping(value = "/display2", method = RequestMethod.GET)
	public ModelAndView display2() {

		ModelAndView result;
		Finder finder;
		
		finder = finderService.findByPrincipal();
		result = new ModelAndView("finder/display2");
		result.addObject("finder", finder);
		
		result.addObject("requestURI", "student/finder/course/display2.do");

		return result;
	}

	

	//Edition--------------------------

	@RequestMapping(value = "/edit2", method = RequestMethod.GET)
	public ModelAndView edit2(@RequestParam int finderId) {

		ModelAndView result;
		Finder finder;
		
		finder = finderService.findOne(finderId);
		FinderForm finderform=finderService.transform(finder);
		Assert.notNull(finderform);
		result = createEditModelAndView(finderform);

		return result;

	}

	@RequestMapping(value = "/edit2", method = RequestMethod.POST, params = "save")
	public ModelAndView save2(@Valid FinderForm finderForm, BindingResult binding) {

		ModelAndView result;
		Finder finder;
		if (binding.hasErrors()) {
			result = createEditModelAndView(finderForm);
		} else {
			try {
				finder=finderService.reconstruct(finderForm, binding);
				Collection<Course>courses=courseService.findByFinder(finder);
				Boolean aux=false;
				if(courses.isEmpty()){
					aux=true;
				}
				finderService.save(finder);
				result = display2();
				result.addObject("aux",aux);
				result.addObject("courses",courses);
			} catch (Throwable oops) {
				String msgCode = "finder.commit.error";
				if(oops.getMessage().equals("cityNotNull")){
					msgCode="finder.cityNotNull";
				}
				result = createEditModelAndView(finderForm, msgCode);
		}

		
		}
		return result;
	}
	
	

//Ancillary Methods---------------------------

protected ModelAndView createEditModelAndView(FinderForm finderForm) {

ModelAndView result;

result = createEditModelAndView(finderForm, null);

return result;
}

protected ModelAndView createEditModelAndView(FinderForm finderForm, String message) {
ModelAndView result;

result = new ModelAndView("finder/display2");
result.addObject("finder", finderForm);

result.addObject("message", message);

return result;

}



}
