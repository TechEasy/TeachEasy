
package controllers.Academy;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.AcademyService;
import services.CourseService;
import services.RequestService;
import controllers.AbstractController;
import domain.Academy;
import domain.Course;
import domain.Request;

@Controller
@RequestMapping("/academy/request")
public class AcademyRequestController extends AbstractController {

	@Autowired
	private RequestService	requestService;

	@Autowired
	private AcademyService	academyService;

	@Autowired
	private CourseService	courseService;


	// Constructors -----------------------------------------------------------

	public AcademyRequestController() {
		super();
	}

	// Listing ----------------------------------------------------------------

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Request> requests = new ArrayList<Request>();

		Academy academy;
		academy = academyService.findByPrincipal();

		Collection<Course> courses = courseService.findByCreator(academy);
		for (Course c : courses) {
			for (Request r : c.getRequests()) {
				requests.add(r);
			}
		}
		result = new ModelAndView("request/list");
		result.addObject("requestURI", "request/request/list.do");
		result.addObject("requests", requests);

		return result;
	}

	// Accept -----------------------------------------------------------

	@RequestMapping(value = "/accept", method = RequestMethod.GET)
	public ModelAndView accept(@RequestParam int requestId) {

		Request request = requestService.findOne(requestId);
		request.setStatus("WAITING");
		requestService.save(request);

		return list();
	}

	// Deny -----------------------------------------------------------

	@RequestMapping(value = "/deny", method = RequestMethod.GET)
	public ModelAndView deny(@RequestParam int requestId) {

		Request request = requestService.findOne(requestId);
		request.setStatus("DENIED");
		requestService.save(request);

		return list();
	}

}
