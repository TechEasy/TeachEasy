
package services;

import java.util.Collection;

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

	public Request reconstruct(RequestForm requestForm, BindingResult binding) {

		Request result;

		Assert.isTrue(requestForm.getCheckIn().compareTo(requestForm.getCheckOut()) < 0, "notBeforeDate");
		Assert.isTrue(check(requestForm), "badDayDate");
		Assert.notNull(rClassService.findById(requestForm.getRclassId()), "badRClass");

		result = create();

		result.setCheckIn(requestForm.getCheckIn());
		result.setCheckOut(requestForm.getCheckOut());
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
	public Collection<Request> findCanceledAndPaid(){
		Collection<Request> requests;
		requests=requestRepository.findRequestCanceledAndPaid();
		return requests;
	}

}
