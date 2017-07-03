
package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.InvoiceRepository;
import domain.Invoice;
import domain.Request;

@Service
@Transactional
public class InvoiceService {

	// Managed repository

	@Autowired
	private InvoiceRepository	invoiceRepository;

	// Supporting services

	@Autowired
	private RequestService		requestService;

	@Autowired
	private ProposalService		proposalService;
	
	@Autowired
	private CourseService		courseService;

	//Constructors
	public InvoiceService() {
		super();

	}

	// Simple CRUD methods
	public Invoice create() {
		Invoice result;
		result = new Invoice();
		return result;
	}

	public Collection<Invoice> findAll() {
		Collection<Invoice> result;
		result = invoiceRepository.findAll();
		return result;
	}

	public Invoice findOne(int id) {
		Invoice result;
		result = invoiceRepository.findOne(id);
		
		return result;
	}

	public Invoice save(Invoice invoice) {
		Invoice result;
		result = invoiceRepository.save(invoice);
		return result;

	}

	public void delete(Invoice invoice) {
		invoiceRepository.delete(invoice);
	}

	@SuppressWarnings("deprecation")
	public Invoice generateInvoice(int requestId) throws ParseException {

		Invoice result;
		Double value = 0.0;
		Request request = requestService.findOne(requestId);
		String details = "Factura de la clase: " + request.getRclass().getTitle() + ".";
		String tenantInfo = "Factura de : " + request.getStudent().getName() + " " + request.getStudent().getSurname();
		Date date = new Date(System.currentTimeMillis() - 1);
		
		if(proposalService.findOne(request.getRclass().getId())!=null){
			Date sI, sO;
			SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
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
			value = valor * request.getRclass().getRate();
		}else{
			value = courseService.findOne(request.getRclass().getId()).getRate();
		}
		result = create();
		result.setVatNumber("ES-78451578");
		result.setDetails(details);
		result.setInformation(tenantInfo);
		result.setAuthoredMoment(date);
		result.setTotal(value);

		return save(result);

	}

}
