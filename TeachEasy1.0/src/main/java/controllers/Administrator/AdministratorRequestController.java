package controllers.Administrator;

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

import services.RClassService;
import services.RequestService;

import controllers.AbstractController;

import domain.Rclass;
import domain.Request;

@Controller
@RequestMapping("/administrator/request")
public class AdministratorRequestController extends AbstractController{
	@Autowired
	private RequestService	requestService;
	
	@Autowired
	private RClassService	rclassService;
	public AdministratorRequestController(){
		super();
	}
	// Listing ----------------------------------------------------------------

		@SuppressWarnings("deprecation")
		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public ModelAndView list() throws ParseException {
			ModelAndView result;
			Collection<Request> requests=new ArrayList<Request>();
			Map<Integer, Double> amount = new HashMap<Integer, Double>();
			Map<Integer, Boolean> oneDay = new HashMap<Integer, Boolean>();
			
			Collection<Rclass>aux=rclassService.findAll();
			for(Rclass r:aux){
				for(Request req:r.getRequests()){
					if(req.getStatus().equals("DENIED") && req.getPaid()){
						requests.add(req);
					}
				}
			}
			

			for (Request raux : requests) {
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

				amount.put(r.getId(), value);
			}

			result = new ModelAndView("request/list");
			result.addObject("requestURI", "request/cancelList.do");
			result.addObject("requests", requests);
			result.addObject("amount", amount);
			result.addObject("oneDay", oneDay);

			return result;
		}
		@RequestMapping(value = "/manage", method = RequestMethod.GET)
		public ModelAndView manage(@RequestParam int requestId) throws ParseException {

			Request request = requestService.findOne(requestId);
			request.setPaid(false);
			requestService.save(request);

			return list();
		}

}
