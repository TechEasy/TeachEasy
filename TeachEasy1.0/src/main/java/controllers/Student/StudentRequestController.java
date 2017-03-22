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
import form.RequestForm;
import form.StudentForm;

@Controller
@RequestMapping("/student/request")
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
		result.addObject("requestURI", "request/request/list.do");
		result.addObject("requests", requests);

		return result;
	}

	// Creation ------------------------------------------------

		@RequestMapping(value = "/register", method = RequestMethod.GET)
		public ModelAndView create(@RequestParam int rClassId) {
			ModelAndView result;
			RequestForm requestForm;

			requestForm = requestService.generateForm();
			requestForm.setRClassId(rClassId);
			result = createEditModelAndView(requestForm, null);

			return result;
		}

		@RequestMapping(value = "/register", method = RequestMethod.POST, params = "save")
		public ModelAndView save(@Valid RequestForm requestForm, BindingResult binding) {
			ModelAndView result;
			Request request;

			if (binding.hasErrors()) {
				result = createEditModelAndView(requestForm, null);
			} else {
				try {
					request = requestService.reconstruct(requestForm, binding);
					requestService.save(request);
					result = list();
				} catch (Throwable oops) {
					String msgCode = "request.register.error";
					if (oops.getMessage().equals("notBeforeDate")) {
						msgCode = "request.register.notBeforeDate";
					}else if (oops.getMessage().equals("badDayDate")) {
							msgCode = "request.register.badDayDate";
					}else if (oops.getMessage().equals("badCreditCard")) {
						msgCode = "request.register.badCreditCard";
					}
					result = createEditModelAndView(requestForm, msgCode);
				}
			}

			return result;

		}

		// Ancillary methods ---------------------------------------------------

		protected ModelAndView createEditModelAndView(RequestForm requestForm, String message) {
			ModelAndView result;

			result = new ModelAndView("request/register");
			result.addObject("requestForm", requestForm);
			result.addObject("message", message);

			return result;
		}
}
