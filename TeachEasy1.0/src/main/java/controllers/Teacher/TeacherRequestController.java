
package controllers.Teacher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.ProposalService;
import services.RequestService;
import services.TeacherService;
import controllers.AbstractController;
import domain.Proposal;
import domain.Request;
import domain.Teacher;

@Controller
@RequestMapping("/teacher/request")
public class TeacherRequestController extends AbstractController {

	@Autowired
	private RequestService	requestService;

	@Autowired
	private TeacherService	teacherService;
	@Autowired
	private ProposalService	proposalService;


	// Constructors -----------------------------------------------------------

	public TeacherRequestController() {
		super();
	}

	// Listing ----------------------------------------------------------------

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() throws ParseException {
		ModelAndView result;
		Collection<Request> requests = new ArrayList<Request>();
		Map<Integer, Double> amount = new HashMap<Integer, Double>();
		Teacher teacher;
		teacher = teacherService.findByPrincipal();

		Collection<Proposal> proposals = proposalService.findByCreator(teacher);
		for (Proposal p : proposals) {
			for (Request r : p.getRequests()) {
				requests.add(r);
			}
		}

		for (Request r : requests) {
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
			value = Math.floor(value * 100) / 100;
			amount.put(r.getId(), value);
		}

		result = new ModelAndView("request/list");
		result.addObject("requestURI", "teacher/request/list.do");
		result.addObject("requests", requests);
		result.addObject("amount", amount);

		return result;
	}

	// Accept -----------------------------------------------------------

	@RequestMapping(value = "/accept", method = RequestMethod.GET)
	public ModelAndView accept(@RequestParam int requestId) throws ParseException {
		String msg=null;
		try {
			Request request = requestService.findOne(requestId);
			request.setStatus("AWAITING PAYMENT");
			requestService.save(request);
		} catch (Throwable oops) {
			String msgCode = "request.register.error";
			if (oops.getMessage().equals("notYours")){
				msgCode = "request.notYours";
				msg="This request is not yours,it has been redirected to your list";
			}
				
		}

		ModelAndView result=list();
		result.addObject("msg",msg);
		return result;
	}

	// Deny -----------------------------------------------------------

	@RequestMapping(value = "/deny", method = RequestMethod.GET)
	public ModelAndView deny(@RequestParam String requestId) throws ParseException {
		String msg=null;
		Request request=null;
		try {
			
			try{
				if(requestId.length()<10){
					int id = Integer.valueOf(requestId);
					 request = requestService.findOne(id);
				}else
					request=null;
				
				if(request==null){
					 msg = "request.notYours";
				}else{
					request.setStatus("DENIED");
					requestService.save(request);
				}
			}catch (Throwable oops) {
				ModelAndView result=list(); 
				 msg = "request.notYours";
				result.addObject("msg",msg);
			}	
			
		} catch (Throwable oops) {
			String msgCode = "request.register.error";
			if (oops.getMessage().equals("notYours")){
				msgCode = "request.notYours";
				msg="This request is not yours,it has been redirected to your list";
			}
				
		}

		ModelAndView result=list(); 
		result.addObject("msg",msg);
		return result;
	}

}
