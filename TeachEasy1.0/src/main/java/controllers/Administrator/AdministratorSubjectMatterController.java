
package controllers.Administrator;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.AdministratorService;
import services.MatterService;
import controllers.AbstractController;
import domain.Administrator;
import domain.SubjectMatter;

@Controller
@RequestMapping("/administrator/subjectMatter")
public class AdministratorSubjectMatterController extends AbstractController {

	//Services-------------------------

	@Autowired
	private MatterService			subjectMatterService;

	@Autowired
	private AdministratorService	administratorService;


	//Constructor----------------------

	public AdministratorSubjectMatterController() {
		super();
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<SubjectMatter> subjectMatters;
		Administrator administrator;

		administrator = this.administratorService.findByPrincipal();
		subjectMatters = this.subjectMatterService.findAll();

		result = new ModelAndView("subjectMatter/list");
		result.addObject("requestedURI", "subjectMatter/administrator/list.do");
		result.addObject("subjectMatters", subjectMatters);
		result.addObject("administrator", administrator);

		return result;
	}

	// Creation ------------------------------------------------

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		SubjectMatter subjectMatter;

		subjectMatter = this.subjectMatterService.create();
		Assert.notNull(subjectMatter);

		result = this.createEditModelAndView(subjectMatter);

		return result;
	}

	// Edition ---------------------------------------------------------------

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam final int subjectMatterId) {
		ModelAndView result;
		SubjectMatter subjectMatter;
		Administrator administrator;

		subjectMatter = this.subjectMatterService.findOne(subjectMatterId);

		try {
			administrator = this.administratorService.findByPrincipal();
			result = this.createEditModelAndView(subjectMatter);

		} catch (final Throwable oops) {
			result = this.list();
			result.addObject("message", "offer.commit.error.editable");
		}

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(SubjectMatter subjectMatter, final BindingResult binding) {
		ModelAndView result;

		subjectMatter = this.subjectMatterService.reconstruct(subjectMatter, binding);

		if (binding.hasErrors())
			result = this.createEditModelAndView(subjectMatter);
		else
			try {
				this.subjectMatterService.save(subjectMatter);
				result = new ModelAndView("redirect:list.do");

			} catch (final Throwable oops) {
				result = this.createEditModelAndView(subjectMatter, "offer.commit.error");
			}

		return result;
	}

	//Ancillary Methods---------------------------

	protected ModelAndView createEditModelAndView(SubjectMatter subjectMatter) {

		ModelAndView result;

		result = createEditModelAndView(subjectMatter, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(SubjectMatter subjectMatter, String message) {
		ModelAndView result;

		result = new ModelAndView("subjectMatter/edit");
		result.addObject("subjectMatter", subjectMatter);

		result.addObject("message", message);

		return result;

	}

}
