
package controllers.Teacher;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.ProposalService;
import services.RequestService;
import services.TeacherService;
import controllers.AbstractController;
import domain.Proposal;
import domain.Request;
import domain.Teacher;

@Controller
@RequestMapping("/teacher/request")
public class TeacherRequestController extends AbstractController {

	@Autowired
	private RequestService	requestService;

	@Autowired
	private TeacherService	teacherService;
	@Autowired
	private ProposalService	proposalService;


	// Constructors -----------------------------------------------------------

	public TeacherRequestController() {
		super();
	}

	// Listing ----------------------------------------------------------------

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Request> requests = new ArrayList<Request>();
		;
		Teacher teacher;
		teacher = teacherService.findByPrincipal();

		Collection<Proposal> proposals = proposalService.findByCreator(teacher);
		for (Proposal p : proposals)
			for (Request r : p.getRequests())
				requests.add(r);
		result = new ModelAndView("request/list");
		result.addObject("requestURI", "teacher/request/list.do");
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
