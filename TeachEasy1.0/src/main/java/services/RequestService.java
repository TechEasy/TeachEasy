
package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import repositories.RequestRepository;
import domain.Request;
import form.RequestForm;

@Service
@Transactional
public class RequestService {

	// Managed repository

	@Autowired
	private RequestRepository	requestRepository;

	// Supporting services
	@Autowired
	private RClassService		rClassService;

	@Autowired
	private Validator			validator;

	@Autowired
	private StudentService		studentService;
	
	@Autowired
	private CourseService		courseService;
	
	


	//Constructors
	public RequestService() {
		super();

	}

	// Simple CRUD methods
	public Request create() {
		Request result;
		result = new Request();
		result.setPaid(false);
		result.setStudent(studentService.findByPrincipal());
		result.setStatus("PENDING");
		return result;
	}

	public Collection<Request> findAll() {
		Collection<Request> result;
		result = requestRepository.findAll();
		return result;
	}

	public Request findOne(int id) {
		Request result;
		result = requestRepository.findOne(id);
		return result;
	}

	public Request save(Request request) {

		Request result;
		result = requestRepository.save(request);

		return result;
	}

	public void delete(Request request) {
		requestRepository.delete(request);
	}

	public Collection<Request> findByTeacher(int id) {
		return requestRepository.findByTeacher(id);
	}

	public Collection<Request> findByAcademy(int id) {
		return requestRepository.findByAcademy(id);
	}

	// Form methods ------------------------------------------------

	public RequestForm generateForm() {
		RequestForm result;

		result = new RequestForm();
		return result;
	}

	public Request reconstruct(RequestForm requestForm, BindingResult binding) throws ParseException {
		Request result;
		SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		if(courseService.findOne(requestForm.getRclassId())==null){
			Assert.isTrue(!requestForm.getCheckIn().equals(""),"nullCheckIn");
			Assert.isTrue(!requestForm.getCheckOut().equals(""),"nullCheckOut");
			Assert.isTrue(check(requestForm), "badDayDate");
			Date sI,act,sO;
			sI = fecha.parse(requestForm.getCheckIn());
			act=new Date(System.currentTimeMillis()-1000);
			Assert.isTrue(sI.after(act),"classMustBeFuture");
			Assert.isTrue(check2(requestForm), "lesserOneHour");
			Assert.isTrue(requestForm.getCheckIn().compareTo(requestForm.getCheckOut()) < 0, "notBeforeDate");
			Assert.notNull(rClassService.findById(requestForm.getRclassId()), "badRClass");
		
			result = create();
	
			result.setCheckIn(requestForm.getCheckIn());
			result.setCheckOut(requestForm.getCheckOut());
		}else{
			result = create();
			result.setCheckIn(null);
			result.setCheckOut(null);
			//result.setCheckIn(fecha.format(act));
			//result.setCheckOut(fecha.format(act));
		}
			
		result.setRclass(rClassService.findById(requestForm.getRclassId()));

		validator.validate(result, binding);

		return result;

	}

	private boolean check(RequestForm request) {
			String fecha1, fecha2;
			fecha1 = request.getCheckIn().substring(0, request.getCheckIn().indexOf(" "));
			fecha2 = request.getCheckOut().substring(0, request.getCheckIn().indexOf(" "));
	
			if (fecha1.equals(fecha2))
				return true;
			else
				return false;
	}
	
	@SuppressWarnings("deprecation")
	private boolean check2(RequestForm r){		
		Boolean result = false;
		
			Date sI = new Date();
			Date sO = new Date();
			SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm");

			try {
				sI = fecha.parse(r.getCheckIn());
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
				
				if(valor>=1)
					result=true;
				
			} catch (ParseException e) {
				Assert.isTrue(false, "lesserOneHour");
			}
			
		return result;
	}
	
	public Collection<Request> findCanceledAndPaid(){
		Collection<Request> requests;
		requests=requestRepository.findRequestCanceledAndPaid();
		return requests;
	}

}
