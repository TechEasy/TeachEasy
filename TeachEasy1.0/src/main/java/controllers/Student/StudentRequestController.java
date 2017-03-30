package controllers.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
import domain.Rclass;
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

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() throws ParseException {
		ModelAndView result;
		Collection<Request> requests;
		Map<Integer,Double> amount = new HashMap<Integer,Double>();
		Student student;
		student = studentService.findByPrincipal();

		requests = student.getRequests();

		for(Request r : requests){
			
			Date sI, sO;
			SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			
			sI = fecha.parse(r.getcheckIn());
			sO = fecha.parse(r.getCheckOut());
			
			Integer minutos;
			Integer horas;
			
			if(sO.getMinutes()>sI.getMinutes()||sO.getMinutes()==sI.getMinutes()){
				minutos = sO.getMinutes()-sI.getMinutes();
				horas = sO.getHours()-sI.getHours();
			}else{
				minutos = 60+sI.getMinutes()-sO.getMinutes();
				horas = sO.getHours()-sI.getHours()-1;
			}
			
			Double valor = (horas+(1.0*(minutos)/60));
			Double value = valor*r.getRclass().getRate();
			
			amount.put(r.getId(), value);
		}
		
		result = new ModelAndView("request/list");
		result.addObject("requestURI", "request/request/list.do");
		result.addObject("requests", requests);
		result.addObject("amount", amount);

		return result;
	}

	// Creation ------------------------------------------------

		@RequestMapping(value = "/register", method = RequestMethod.GET)
		public ModelAndView create(@RequestParam int rClassId) {
			ModelAndView result;
			RequestForm requestForm;

			requestForm = requestService.generateForm();
			requestForm.setRclassId(rClassId);
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
					}else if (oops.getMessage().equals("badRClass")) {
						msgCode = "request.register.badRClass";
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
