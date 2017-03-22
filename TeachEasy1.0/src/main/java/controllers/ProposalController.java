
package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.ProposalService;
import domain.Proposal;

@Controller
@RequestMapping("/proposal")
public class ProposalController extends AbstractController {

	@Autowired
	ProposalService	proposalService;


	public ProposalController() {
		super();

	}

	@RequestMapping(value = "/browse", method = RequestMethod.GET)
	public ModelAndView browse() {
		ModelAndView result;
		Collection<Proposal> proposals;
		proposals = proposalService.findAll();
		result = new ModelAndView("proposal/list");
		result.addObject("proposals", proposals);

		return result;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Proposal> proposals;
		proposals = proposalService.findAll();
		result = new ModelAndView("proposal/list");
		result.addObject("proposals", proposals);

		return result;
	}
}
