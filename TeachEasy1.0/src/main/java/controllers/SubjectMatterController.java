
package controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.ActorService;
import services.MatterService;
import services.TeacherService;
import domain.Actor;
import domain.SubjectMatter;

@Controller
@RequestMapping("/subjectMatter")
public class SubjectMatterController extends AbstractController {

	//Services-------------------------

	@Autowired
	private MatterService	subjectMatterService;

	@Autowired
	private TeacherService	teacherService;

	@Autowired
	private ActorService	actorService;


	//Constructor----------------------

	public SubjectMatterController() {
		super();
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<SubjectMatter> subjectMatters = new ArrayList<SubjectMatter>();
		Actor actor;

		actor = this.actorService.findByPrincipal();
		subjectMatters = this.subjectMatterService.findSubjectMatterValidated();
		result = new ModelAndView("subjectMatter/list");
		result.addObject("requestedURI", "subjectMatter/list.do");
		result.addObject("subjectMatters", subjectMatters);
		result.addObject("principal", actor);

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
		Actor actor;
		subjectMatter = this.subjectMatterService.findOne(subjectMatterId);

		try {
			actor = this.actorService.findByPrincipal();
			result = this.createEditModelAndView(subjectMatter);

		} catch (final Throwable oops) {
			result = this.createEditModelAndView(subjectMatter);
			result.addObject("message", "subjectMatter.error.editable");
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
				result = new ModelAndView("redirect:/subjectMatter/list.do");

			} catch (final Throwable oops) {
				result = this.createEditModelAndView(subjectMatter, "subjectMatter.commit.error");
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