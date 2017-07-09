
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.AcademyService;
import services.CourseService;
import services.FeeService;
import services.InvoiceService;
import services.ProposalService;
import services.RequestService;
import services.StudentService;
import services.TeacherService;
import controllers.AbstractController;
import domain.Academy;
import domain.Course;
import domain.Invoice;
import domain.Request;
import domain.Student;
import domain.Teacher;
import form.RequestForm;

@Controller
@RequestMapping("/student/request")
public class StudentRequestController extends AbstractController {

	@Autowired
	private RequestService	requestService;

	@Autowired
	private StudentService	studentService;

	@Autowired
	private InvoiceService	invoiceService;

	@Autowired
	private TeacherService	teacherService;

	@Autowired
	private AcademyService	academyService;

	@Autowired
	private FeeService		feeService;

	@Autowired
	private ProposalService	proposalService;

	@Autowired
	private CourseService	courseService;


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
		Map<Integer, Double> amount = new HashMap<Integer, Double>();
		Map<Integer, Boolean> oneDay = new HashMap<Integer, Boolean>();
		Student student;
		student = studentService.findByPrincipal();

		requests = student.getRequests();

		for (Request raux : requests) {
			if(raux.getcheckIn()!=null){
				Boolean b;
				Date d = new Date(), d2 = new Date();
				Integer actualDate, requestDate;
				actualDate = (int) (d.getTime() / 86400000);
				SimpleDateFormat fecha2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				d2 = fecha2.parse(raux.getcheckIn());
				requestDate = (int) (d2.getTime() / 86400000);
				if ((actualDate - requestDate) < 0)
					b = true;
				else
					b = false;
			
			oneDay.put(raux.getId(), b);
			}else{
				oneDay.put(raux.getId(), false);
			}
		}

		for (Request r : requests) {
			if(r.getcheckIn()!=null){
				
				Date sI, sO;
				SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
				sI = fecha.parse(r.getcheckIn());
				sO = fecha.parse(r.getCheckOut());
	
				Integer minutos;
				Integer horas;
	
				if (sO.getMinutes() > sI.getMinutes() || sO.getMinutes() == sI.getMinutes()) {
					minutos = sO.getMinutes() - sI.getMinutes();
					horas = sO.getHours() - sI.getHours();
				} else {
					minutos = 60 + sO.getMinutes() - sI.getMinutes();
					horas = sO.getHours() - sI.getHours() - 1;
				}
	
				Double valor = (horas + (1.0 * (minutos) / 60));
				Double value = valor * r.getRclass().getRate();
	
				amount.put(r.getId(), value);
			}else{
				amount.put(r.getId(), courseService.findOne(r.getRclass().getId()).getRate());
			}
		}

		result = new ModelAndView("request/list");
		result.addObject("requestURI", "request/request/list.do");
		result.addObject("requests", requests);
		result.addObject("amount", amount);
		result.addObject("oneDay", oneDay);

		return result;
	}

	// Creation ------------------------------------------------

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView create(@RequestParam int rClassId) {
		ModelAndView result;
		RequestForm requestForm;

		requestForm = requestService.generateForm();
		requestForm.setRclassId(rClassId);
		if(proposalService.findOne(rClassId)!=null){
			result = new ModelAndView("request/register");
			result.addObject("requestForm", requestForm);
			result.addObject("tipo","proposal");
		}else{
			result = new ModelAndView("request/register");
			result.addObject("requestForm", requestForm);
			result.addObject("tipo","course");
		}
		
		return result;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid RequestForm requestForm, BindingResult binding) {
		ModelAndView result;
		Request request;

		if (binding.hasErrors())
			result = createEditModelAndView(requestForm, null);
		else
			try {
				request = requestService.reconstruct(requestForm, binding);
				requestService.save(request);
				result = list();
			} catch (Throwable oops) {
				String msgCode = "request.register.error";
				if (oops.getMessage().equals("notBeforeDate"))
					msgCode = "request.register.notBeforeDate";
				else if (oops.getMessage().equals("lesserOneHour"))
					msgCode = "request.register.lesserOneHour";
				else if (oops.getMessage().equals("nullCheckIn"))
					msgCode = "request.register.nullCheckIn";
				else if (oops.getMessage().equals("nullCheckOut"))
					msgCode = "request.register.nullCheckOut";
				else if (oops.getMessage().equals("badDayDate"))
					msgCode = "request.register.badDayDate";
				else if (oops.getMessage().equals("badCreditCard"))
					msgCode = "request.register.badCreditCard";
				else if (oops.getMessage().equals("badRClass"))
					msgCode = "request.register.badRClass";
				else if(oops.getMessage().equals("classMustBeFuture"))
					msgCode = "request.register.classFuture";
				result = createEditModelAndView(requestForm, msgCode);
			}

		return result;

	}

	@RequestMapping(value = "/registerCourse", method = RequestMethod.GET)
	public ModelAndView createC(@RequestParam int rClassId) {
		ModelAndView result;
		RequestForm requestForm;

		requestForm = requestService.generateForm();
		requestForm.setRclassId(rClassId);
		result = createEditModelAndView(requestForm, null);

		return result;
	}

	@RequestMapping(value = "/registerCourse", method = RequestMethod.POST, params = "save")
	public ModelAndView saveC(@Valid RequestForm requestForm, BindingResult binding) {
		ModelAndView result;
		Request request;

		if (binding.hasErrors())
			result = createEditModelAndView(requestForm, null);
		else
			try {
				request = requestService.reconstruct(requestForm, binding);
				requestService.save(request);
				result = list();
			} catch (Throwable oops) {
				String msgCode = "request.register.error";
				if (oops.getMessage().equals("notBeforeDate"))
					msgCode = "request.register.notBeforeDate";
				else if (oops.getMessage().equals("badDayDate"))
					msgCode = "request.register.badDayDate";
				else if (oops.getMessage().equals("badCreditCard"))
					msgCode = "request.register.badCreditCard";
				else if (oops.getMessage().equals("badRClass"))
					msgCode = "request.register.badRClass";
				result = createEditModelAndView(requestForm, msgCode);
			}

		return result;

	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/paid", method = RequestMethod.GET)
	public ModelAndView paid(@RequestParam int requestId) throws ParseException {
		
		Request request = requestService.findOne(requestId);
		Teacher teacher;
		Academy academy;
		Invoice invoice = invoiceService.generateInvoice(requestId);
		request.setStatus("ACCEPTED");
		request.setInvoice(invoice);
		request.setPaid(true);
		requestService.save(request);


		if(proposalService.findOne(request.getRclass().getId())!=null){
			Date sI, sO;
			SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			
			// Calculo del amount que obtendra el profesor
			sI = fecha.parse(request.getcheckIn());
			sO = fecha.parse(request.getCheckOut());
	
			Integer minutos;
			Integer horas;
	
			if (sO.getMinutes() > sI.getMinutes() || sO.getMinutes() == sI.getMinutes()) {
				minutos = sO.getMinutes() - sI.getMinutes();
				horas = sO.getHours() - sI.getHours();
			} else {
				minutos = 60 + sO.getMinutes() - sI.getMinutes();
				horas = sO.getHours() - sI.getHours() - 1;
			}
	
			Double valor = (horas + (1.0 * (minutos) / 60));
			Double value = valor * request.getRclass().getRate();
			
			teacher = proposalService.findOne(request.getRclass().getId()).getTeacher();
			Double feeAmount = teacher.getFeeAmount();
			feeAmount += value - (value * (feeService.find().getValueTeacher() / 100));
			teacher.setFeeAmount(feeAmount);
			teacherService.save3(teacher);
		}else {
			Course c = courseService.findOne(request.getRclass().getId());
			academy = c.getAcademy();
			Double feeAmount = academy.getFeeAmount();
			feeAmount += c.getRate() - (c.getRate() * (feeService.find().getValueAcademy() / 100));
			academy.setFeeAmount(feeAmount);
			academyService.save3(academy);
		}

		return list();
	}
	// Cancel -----------------------------------------------------------

	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public ModelAndView cancel(@RequestParam String requestId) throws ParseException {
		String msg=null;
		Request request=null;
		Date f = new Date(System.currentTimeMillis());
		Teacher teacher;
		Academy academy;
		SimpleDateFormat fecha2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try {
			
			try{
				if(requestId.length()<10){
					int id = Integer.valueOf(requestId);
					request = requestService.findOne(id);
				}else{
					request=null;
					msg = "request.notYours";
				}
				
				if(request!=null){
					if(courseService.findOne(request.getRclass().getId())!=null){
						
						if(request.getStatus().equals("ACCEPTED")){
							Course c = courseService.findOne(request.getRclass().getId());
							academy = c.getAcademy();
							Double feeAmount = academy.getFeeAmount();
							feeAmount -= c.getRate() - (c.getRate() * (feeService.find().getValueAcademy() / 100));
							academy.setFeeAmount(feeAmount);
							academyService.save3(academy);
						}
						
						request.setStatus("DENIED");
						requestService.save(request);
						
					}else{
						Date f2 = fecha2.parse(request.getcheckIn());
					
						if(f.before(f2)){
							if(request.getStatus().equals("ACCEPTED")){
								Date sI, sO;
								SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm");
								
								// Calculo del amount que obtendra el profesor
								sI = fecha.parse(request.getcheckIn());
								sO = fecha.parse(request.getCheckOut());
						
								Integer minutos;
								Integer horas;
						
								if (sO.getMinutes() > sI.getMinutes() || sO.getMinutes() == sI.getMinutes()) {
									minutos = sO.getMinutes() - sI.getMinutes();
									horas = sO.getHours() - sI.getHours();
								} else {
									minutos = 60 + sO.getMinutes() - sI.getMinutes();
									horas = sO.getHours() - sI.getHours() - 1;
								}
						
								Double valor = (horas + (1.0 * (minutos) / 60));
								Double value = valor * request.getRclass().getRate();
								
								teacher = proposalService.findOne(request.getRclass().getId()).getTeacher();
								Double feeAmount = teacher.getFeeAmount();
								feeAmount -= value - (value * (feeService.find().getValueTeacher() / 100));
								teacher.setFeeAmount(feeAmount);
								teacherService.save3(teacher);
							}
							request.setStatus("DENIED");
							requestService.save(request);
						}else{
							msg = "request.notPast";
						}
					}
					
				}else{
					msg = "request.notYours";
				}
			}catch (Throwable oops) {
				ModelAndView result=list(); 
				msg = "request.notPast";
				result.addObject("msg",msg);
			}	
			
		} catch (Throwable oops) {
			msg = "request.register.error";
			if (oops.getMessage().equals("notYours")){
				msg = "request.notYours";
			}
		}

		ModelAndView result=list(); 
		result.addObject("msg",msg);
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
