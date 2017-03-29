
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.InvoiceRepository;
import domain.Invoice;
import domain.Student;

@Service
@Transactional
public class InvoiceService {

	// Managed repository

	@Autowired
	InvoiceRepository	invoiceRepository;


	// Supporting services

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
	
}
