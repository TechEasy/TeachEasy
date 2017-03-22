package controllers.Teacher;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.RClassService;
import services.RequestService;
import services.StudentService;
import services.TeacherService;
import controllers.AbstractController;
import domain.Rclass;
import domain.Request;
import domain.Student;
import domain.Teacher;
import form.RequestForm;
import form.StudentForm;

@Controller
@RequestMapping("/teacher/request")
public class TeacherRequestController extends AbstractController {

	@Autowired
	private RequestService	requestService;

	@Autowired
	private TeacherService	teacherService;


	// Constructors -----------------------------------------------------------

	public TeacherRequestController() {
		super();
	}

	// Listing ----------------------------------------------------------------

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Request> requests;
		Teacher teacher;
		teacher = teacherService.findByPrincipal();

		requests = requestService.findByTeacher(teacher.getId());

		result = new ModelAndView("request/list");
		result.addObject("requestURI", "request/request/list.do");
		result.addObject("requests", requests);

		return result;
	}

	// Accept -----------------------------------------------------------
	
	@RequestMapping(value = "/accept", method = RequestMethod.GET)
	public ModelAndView accept(@RequestParam int requestId) {

		Request request = requestService.findOne(requestId);
		request.setStatus("ACCEPTED");
		requestService.save(request);
		
		return list();
	}
	
	// Deny -----------------------------------------------------------
	
	@RequestMapping(value = "/deny", method = RequestMethod.GET)
	public ModelAndView deny(@RequestParam int requestId) {

		Request request = requestService.findOne(requestId);
		request.setStatus("DENIED");
		requestService.save(request);
		
		return list();
	}
	
}
