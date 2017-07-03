
package controllers.Student;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.InvoiceService;
import services.StudentService;
import controllers.AbstractController;
import domain.Invoice;
import domain.Request;
import domain.Student;

@Controller
@RequestMapping("/student/invoice")
public class StudentInvoiceController extends AbstractController {

	//Services-----------------------------------
	@Autowired
	private StudentService	studentService;
	@Autowired
	private InvoiceService	invoiceService;


	//Constructor-------------------------------
	public StudentInvoiceController() {
		super();
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Student student;
		student = studentService.findByPrincipal();
		Collection<Invoice> invoices = new ArrayList<Invoice>();
		for (Request r : student.getRequests()) {
			invoices.add(r.getInvoice());
		}
		result = new ModelAndView("invoice/list");
		result.addObject("invoices", invoices);
		result.addObject("requestURI", "student/invoice/list.do");
		return result;
	}
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public ModelAndView display(@RequestParam String invoiceId) {

		ModelAndView result=new ModelAndView();
		Invoice invoice;
		Student student;
		Double aux;
		Double aux2;
		Double iva = 0.21;
		Double total;
		String msg=null;
		
		student = studentService.findByPrincipal();
		Collection<Invoice> invoices = new ArrayList<Invoice>();
		for (Request r : student.getRequests()) {
			invoices.add(r.getInvoice());
		}
		int id = Integer.valueOf(invoiceId);
		try{
			invoice = invoiceService.findOne(id);
			total = invoice.getTotal();
			aux = total * iva;
			aux2 = total - aux;
			if (invoices.contains(invoice)) {
				result = new ModelAndView("invoice/display");
				result.addObject("invoice", invoice);
				result.addObject("aux", aux);
				result.addObject("aux2", aux2);
			
			
				result.addObject("requestURI", "student/invoice/display.do");
			} else {
				msg="Not Yours";
				result = list();
				result.addObject("msg",msg);
		}
		}catch(Throwable oops){
			msg="Is null";
			result = list();
			result.addObject("msg",msg);
		}
		

		return result;
	}
}
