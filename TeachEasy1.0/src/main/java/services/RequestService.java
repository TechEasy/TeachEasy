
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import repositories.RequestRepository;
import domain.Request;
import domain.Student;

@Service
@Transactional
public class RequestService {

	// Managed repository

	@Autowired
	RequestRepository	requestRepository;

	@Autowired
	RClassService		rClassService;

	// Supporting services
	@Autowired
	StudentService		studentService;


	//Constructors
	public RequestService() {
		super();

	}

	// Simple CRUD methods
	public Request create() {
		Request result;
		result = new Request();
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

		/***
		 * Assert.isTrue(book.getCheckin().before(book.getCheckout()));
		 * 
		 * CreditCard cc;
		 * cc = book.getCreditcard();
		 * LocalDate localDate = new LocalDate(cc.getExpirationYear(), cc.getExpirationMonth(), 1);
		 * Date ccd = localDate.toDate();
		 * Date now = new Date();
		 * long startTime = now.getTime();
		 * long endTime = ccd.getTime();
		 * long diffTime = endTime - startTime;
		 * long diffDays = diffTime / (1000 * 60 * 60 * 24);
		 * Assert.isTrue(diffDays > 7, "The expired date of Credit Card should be higher than 7 days.");
		 */

		return result;
	}

	public void delete(Request request) {
		requestRepository.delete(request);
	}


	@Autowired
	private Validator	validator;


	public Request reconstruct(Request request, BindingResult binding) {
		Request result;

		if (request.getId() == 0) {

			Student student;
			student = studentService.findByPrincipal();

			request.setStudent(student);
			request.setStatus("PENDING");

			result = request;
			validator.validate(result, binding);

		} else {
			result = requestRepository.findOne(request.getId());
			//Diferentes sets

			result.setCheckin(request.getCheckin());
			result.setCheckout(request.getCheckout());
			result.setDay(request.getDay());
			result.setStatus(request.getStatus());

			validator.validate(result, binding);
		}

		return result;
	}
}
