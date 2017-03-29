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
public class StudentInvoiceController extends AbstractController{
	//Services-----------------------------------
	  @Autowired
	  private StudentService studentService;
	  @Autowired
	  private InvoiceService invoiceService;
	  
	 //Constructor-------------------------------
	  public StudentInvoiceController(){
		  super();
	  }
	  @RequestMapping(value = "/list", method = RequestMethod.GET)
		public ModelAndView list() {
			ModelAndView result;
			Student student;
			student=studentService.findByPrincipal();
			Collection<Invoice> invoices=new ArrayList<Invoice>();
			for(Request r:student.getRequests()){
				invoices.add(r.getInvoice());
			}
			result = new ModelAndView("invoice/list");
			result.addObject("invoices", invoices);
			result.addObject("requestURI","student/invoice/list.do");
			return result;
		}
	  @RequestMapping(value = "/display", method = RequestMethod.GET)
		public ModelAndView display(@RequestParam int invoiceId) {

			ModelAndView result;
			Invoice invoice;

			invoice = invoiceService.findOne(invoiceId);
			result = new ModelAndView("invoice/display");
			result.addObject("invoice", invoice);

			result.addObject("requestURI", "student/invoice/display.do");

			return result;
		}
}
