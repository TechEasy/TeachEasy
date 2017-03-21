
package controllers.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.RClassService;
import services.RequestService;
import services.StudentService;
import controllers.AbstractController;
import domain.RClass;
import domain.Request;

@Controller
@RequestMapping("/request/student")
public class StudentRequestController extends AbstractController {

	@Autowired
	private RequestService	requestService;

	@Autowired
	private StudentService	studentService;

	@Autowired
	private RClassService	rClassService;


	// Constructors -----------------------------------------------------------

	public StudentRequestController() {
		super();
	}

	// Request ----------------------------------------------------------------

	@RequestMapping(value = "/request", method = RequestMethod.GET)
	public ModelAndView request(@ModelAttribute Request request, @RequestParam int rClassId, BindingResult binding) {
		ModelAndView result;

		Request r;
		r = requestService.create();

		RClass rClass;
		rClass = rClassService.findOne(rClassId);

		r.setRClass(rClass);

		result = new ModelAndView("request/student/request");
		result.addObject("request", r);

		return result;
	}

	@RequestMapping(value = "/request", method = RequestMethod.POST, params = "save")
	public ModelAndView requestBook(Request r, BindingResult binding) {
		ModelAndView result;

		r = requestService.reconstruct(r, binding);
		if (binding.hasErrors()) {
			result = new ModelAndView("request/student/request");
			result.addObject("request", r);
		} else {
			try {

				Request res;
				res = requestService.save(r);

				result = new ModelAndView("redirect:/request/student/list.do");
			} catch (Throwable oops) {
				result = new ModelAndView("request/student/request");
				result.addObject("request", r);
				result.addObject("message", "request.commit.error");

			}
		}

		return result;
	}
}
