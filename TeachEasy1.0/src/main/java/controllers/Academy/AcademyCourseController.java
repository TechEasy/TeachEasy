
package controllers.Academy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.AcademyService;
import services.CourseService;
import services.MatterService;
import services.RClassService;
import controllers.AbstractController;
import domain.Academy;
import domain.Course;
import domain.SubjectMatter;

@Controller
@RequestMapping("/course/academy")
public class AcademyCourseController extends AbstractController {

	//Services-------------------------

	@Autowired
	private AcademyService	academyService;

	@Autowired
	private RClassService	rClassService;

	@Autowired
	private CourseService	courseService;

	@Autowired
	private MatterService	matterService;


	//Constructor----------------------

	public AcademyCourseController() {
		super();
	}

	// Listing ----------------------------------------------------------------		
	@RequestMapping(value = "/listCourse", method = RequestMethod.GET)
	public ModelAndView listCourse() {
		ModelAndView result;
		Collection<Course> courses;
		Academy academy;
		academy = academyService.findByPrincipal();

		courses = academy.getCourses();

		result = new ModelAndView("course/listCourse");
		result.addObject("requestURI", "course/academy/listCourse.do");
		result.addObject("courses", courses);

		return result;
	}

	// Creation ----------------------------------------------------------------
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		Course course;

		course = courseService.create();
		result = createEditModelAndView(course);

		return result;
	}

	// Edition ----------------------------------------------------------------		
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam String courseId) {
		ModelAndView result;
		Course course;

		try{
			if(courseId.length()<10){
				int id = Integer.valueOf(courseId);
				course = courseService.findOne(id);
			}else
				course=null;
			
			if(course==null || !academyService.findByPrincipal().equals(course.getAcademy())){
				result = listCourse();
				String msg = "course.notYours";
				result.addObject("msg", msg);
			}else{
				result = createEditModelAndView(course);
			}
		}catch (Throwable oops) {
			result = listCourse();
			String msg = "course.notYours";
			result.addObject("msg", msg);
		}

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid @ModelAttribute Course course, BindingResult bindingResult) {
		ModelAndView result;

		if (bindingResult.hasErrors()) {
			result = createEditModelAndView(course);

		} else {
			try {
				courseService.save(course);
				result = new ModelAndView("redirect:listCourse.do");
			} catch (Throwable oops) {
				String msgCode = "course.commit.error";
				
				if (oops.getMessage().equals("notYourCourse")){
					msgCode="course.notYourCourse";
				}
				result = createEditModelAndView(course, msgCode);
			}
		}

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(@ModelAttribute Course course, BindingResult bindingResult) {
		ModelAndView result;

		try {
			courseService.delete(course);
			result = new ModelAndView("redirect:listCourse.do");
		} catch (Throwable oops) {
			result = createEditModelAndView(course, "course.commit.error");
		}

		return result;
	}

	@RequestMapping(value = "/enableDisable", method = RequestMethod.GET)
	public ModelAndView enableDisable(@RequestParam int courseId) {
		ModelAndView result;
		Course c = courseService.findOne(courseId);
		try {
			rClassService.enableDisable(c);
			result = listCourse();
		} catch (Throwable oops) {
			result = listCourse();
			result.addObject("message", "proposal.commit.error");
		}

		return result;
	}

	public ModelAndView createEditModelAndView(Course course) {
		ModelAndView result;

		result = createEditModelAndView(course, null);

		return result;
	}

	public ModelAndView createEditModelAndView(Course course, String message) {
		ModelAndView result;
		result = new ModelAndView("course/edit");
		result.addObject("course", course);
		result.addObject("message", message);
		result.addObject("matters", getMatters());

		return result;
	}

	private Map<Integer, String> getMatters() {
		Collection<SubjectMatter> cs;
		cs = matterService.findSubjectMatterValidated();

		Map<Integer, String> matters = new HashMap<Integer, String>();
		for (SubjectMatter s : cs) {
			matters.put(s.getId(), s.getName());
		}
		return matters;
	}

}
