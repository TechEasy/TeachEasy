
package controllers.Student;

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
import controllers.AbstractController;
import domain.RClass;
import domain.Request;
import domain.Student;

@Controller
@RequestMapping("/request/student")
public class StudentRequestController extends AbstractController {

	@Autowired
	private RequestService	requestService;

	@Autowired
	private StudentService	studentService;

	@Autowired
	private RClassService	rClassService;


	// Constructors -----------------------------------------------------------

	public StudentRequestController() {
		super();
	}

	// Listing ----------------------------------------------------------------

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Request> requests;
		Student student;
		student = studentService.findByPrincipal();

		requests = student.getRequests();

		result = new ModelAndView("request/list");
		result.addObject("requestURI", "request/student/list.do");
		result.addObject("requests", requests);

		return result;
	}

	// Request ----------------------------------------------------------------

	@RequestMapping(value = "/request", method = RequestMethod.GET)
	public ModelAndView request(@Valid Request request, BindingResult binding, @RequestParam(required = true) int rClassId) {
		ModelAndView result;

		Request r;
		r = requestService.create();

		RClass rClass;
		rClass = rClassService.findOne(rClassId);

		r.setrClass(rClass);

		result = new ModelAndView("request/student/request");
		result.addObject("request", r);

		return result;
	}

	@RequestMapping(value = "/request", method = RequestMethod.POST, params = "save")
	public ModelAndView requestBook(@Valid @ModelAttribute Request request, BindingResult binding, Integer rClassId) {
		ModelAndView result;

		request = requestService.reconstruct(request, binding);
		if (binding.hasErrors()) {
			result = new ModelAndView("request/student/request");
			result.addObject("request", request);
		} else {
			try {

				Request res;

				res = requestService.save(request);

				result = new ModelAndView("redirect:/request/student/list.do");
			} catch (Throwable oops) {
				result = new ModelAndView("request/student/request");
				result.addObject("request", request);
				result.addObject("message", "request.commit.error");
			}
		}

		return result;
	}
}
