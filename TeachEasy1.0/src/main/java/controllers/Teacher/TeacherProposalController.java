package controllers.Teacher;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;

import services.ProposalService;
import services.TeacherService;

import domain.Proposal;
import domain.Teacher;
@Controller
@RequestMapping("/teacher/proposal")
public class TeacherProposalController extends AbstractController {
	
	@Autowired
	private ProposalService proposalService;
	

	@Autowired
	private TeacherService teacherService;
	
	public TeacherProposalController() {
		super();

	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Proposal> proposals;
		Teacher teacher=teacherService.findByPrincipal();
		proposals = proposalService.findByCreator(teacher);
		result = new ModelAndView("proposal/list");
		result.addObject("proposals", proposals);

		return result;
	}
}
