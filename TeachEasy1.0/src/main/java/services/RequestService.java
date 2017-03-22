
package services;

import java.util.Calendar;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import repositories.RequestRepository;
import domain.CreditCard;
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
	private Validator validator;
	
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


	// Form methods ------------------------------------------------

			public RequestForm generateForm() {
				RequestForm result;

				result = new RequestForm();
				return result;
			}

			public Request reconstruct(RequestForm requestForm, BindingResult binding) {

				Request result;
				
				Assert.isTrue(checkC(studentService.findByPrincipal().getCreditCard()),"badCreditCard");
				Assert.isTrue(requestForm.getCheckIn().compareTo(requestForm.getCheckOut())<0, "notBeforeDate");
				Assert.isTrue(check(requestForm), "badDayDate");
				Assert.notNull(rClassService.findById(requestForm.getrClassId()), "badRClass");
				
				result = create();
				
				result.setCheckIn(requestForm.getCheckIn());
				result.setCheckOut(requestForm.getCheckOut());
				result.setrClass(rClassService.findById(requestForm.getrClassId()));
				
				validator.validate(result, binding);

				return result;

			}
	
			private boolean check(RequestForm request){
				String fecha1, fecha2;
				fecha1 = request.getCheckIn().substring(0, request.getCheckIn().indexOf(" "));
				fecha2 = request.getCheckOut().substring(0, request.getCheckIn().indexOf(" "));
				
				if(fecha1.equals(fecha2)){
					return true;
				}else{
					return false;
				}
			}
			
			public static boolean checkC(CreditCard creditCard) {
				boolean validador = false;
				int sum = 0;
				Calendar fecha = Calendar.getInstance();
				String numero = creditCard.getNumber();
				int mes = fecha.get(Calendar.MONTH) + 1;
				int año = fecha.get(Calendar.YEAR);

				if (creditCard.getExpirationYear() > año) {
					validador = true;
				} else if (creditCard.getExpirationYear() == año) {
					if (creditCard.getExpirationMonth() >= mes) {
						validador = true;
					}
				}

				if (validador) {
					validador = false;
					for (int i = numero.length() - 1; i >= 0; i--) {
						int n = Integer.parseInt(numero.substring(i, i + 1));
						if (validador) {
							n *= 2;
							if (n > 9) {
								n = (n % 10) + 1;
							}
						}
						sum += n;
						validador = !validador;
					}
					if (sum % 10 == 0) {
						validador = true;
					}
				}

				return validador;
			}
}
