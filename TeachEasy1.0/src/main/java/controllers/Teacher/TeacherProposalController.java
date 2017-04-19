
package controllers.Teacher;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.MatterService;
import services.ProposalService;
import services.TeacherService;
import controllers.AbstractController;
import domain.Proposal;
import domain.SubjectMatter;
import domain.Teacher;

@Controller
@RequestMapping("/proposal/teacher")
public class TeacherProposalController extends AbstractController {

	@Autowired
	private ProposalService	proposalService;

	@Autowired
	private TeacherService	teacherService;

	@Autowired
	private MatterService	matterService;


	public TeacherProposalController() {
		super();

	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Proposal> proposals;
		Teacher teacher = teacherService.findByPrincipal();
		proposals = proposalService.findByCreator(teacher);
		result = new ModelAndView("proposal/list");
		result.addObject("proposals", proposals);

		return result;
	}

	// Creation ----------------------------------------------------------------
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		Proposal proposal;

		proposal = proposalService.create();
		result = createEditModelAndView(proposal);

		return result;
	}

	// Edition ----------------------------------------------------------------		
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int proposalId) {
		ModelAndView result;
		Proposal proposal;

		proposal = proposalService.findOne(proposalId);

		Assert.notNull(proposal);
		result = createEditModelAndView(proposal);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid @ModelAttribute Proposal proposal, BindingResult bindingResult) {
		ModelAndView result;

		if (bindingResult.hasErrors()) {
			result = createEditModelAndView(proposal);

		} else {

			try {

				proposalService.save(proposal);
				result = new ModelAndView("redirect:list.do");

			} catch (Throwable oops) {
				result = createEditModelAndView(proposal, "proposal.commit.error");
			}
		}

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(@ModelAttribute Proposal proposal, BindingResult bindingResult) {
		ModelAndView result;

		try {
			proposalService.delete(proposal);
			result = new ModelAndView("redirect:list.do");
		} catch (Throwable oops) {
			result = createEditModelAndView(proposal, "proposal.commit.error");
		}

		return result;
	}

	public ModelAndView createEditModelAndView(Proposal proposal) {
		ModelAndView result;

		result = createEditModelAndView(proposal, null);

		return result;
	}

	public ModelAndView createEditModelAndView(Proposal proposal, String message) {
		ModelAndView result;
		result = new ModelAndView("proposal/edit");
		result.addObject("proposal", proposal);
		result.addObject("message", message);
		result.addObject("matters", getMatters());

		return result;
	}

	private Map<Integer, String> getMatters() {
		Collection<SubjectMatter> cs;
		cs = matterService.findAll();

		Map<Integer, String> matters = new HashMap<Integer, String>();
		for (SubjectMatter s : cs) {
			matters.put(s.getId(), s.getName());
		}
		return matters;
	}

}
