
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

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		SubjectMatter subjectMatter;

		subjectMatter = this.subjectMatterService.create();
	

		result = createEditModelAndView(subjectMatter);

		return result;
	}

	// Edition ---------------------------------------------------------------
/*
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(String subjectMatterId) {
		ModelAndView result;
		SubjectMatter subjectMatter;
		Actor actor;
		

		try {
			actor = this.actorService.findByPrincipal();
			result = this.createEditModelAndView(subjectMatter);
			
			if(subjectMatterId==null || subjectMatterId.equals("")){
				result = list();
			}else{
				if(subjectMatterId.length()<10){
					int id = Integer.valueOf(subjectMatterId);
					subjectMatter = subjectMatterService.findOne(id);
				}else
					subjectMatter=null;
				
				if(subjectMatter==null){
					result = list();
					String msg = "proposal.notYours";
					result.addObject("msg", msg);
				}else{
					result = createEditModelAndView(proposal);
				}

		} catch (Throwable oops) {
			result = this.createEditModelAndView(subjectMatter);
		}

		return result;
	}*/

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(SubjectMatter subjectMatter, BindingResult binding) {
		ModelAndView result;

		

		if (binding.hasErrors())
			result = this.createEditModelAndView(subjectMatter);
		else
			try {
				subjectMatter = this.subjectMatterService.reconstruct(subjectMatter, binding);
				this.subjectMatterService.save(subjectMatter);
				result = list();
				result.addObject("msgSaved", "subjectMatter.msgSaved");

			} catch (Throwable oops) {
				String msgCode = "subjectMatter.commit.error";
				if (oops.getMessage().equals("usedThisName"))
					msgCode = "subjectMatter.usedThisName";
			
				result = this.createEditModelAndView(subjectMatter, msgCode);
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
