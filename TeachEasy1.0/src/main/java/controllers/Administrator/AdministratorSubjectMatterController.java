
package controllers.Administrator;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.AdministratorService;
import services.MatterService;
import controllers.AbstractController;
import domain.Actor;
import domain.SubjectMatter;

@Controller
@RequestMapping("/subjectMatter/administrator")
public class AdministratorSubjectMatterController extends AbstractController {

	//Services-------------------------

	@Autowired
	private MatterService			matterService;

	@Autowired
	private AdministratorService	administratorService;


	//Constructor----------------------

	public AdministratorSubjectMatterController() {
		super();
	}

	//Listing ------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<SubjectMatter> subjectMatters = new ArrayList<SubjectMatter>();
		Actor actor;

		actor = this.administratorService.findByPrincipal();
		subjectMatters = this.matterService.findAll();
		result = new ModelAndView("subjectMatter/list");
		result.addObject("requestedURI", "subjectMatter/administrator/list.do");
		result.addObject("subjectMatters", subjectMatters);
		result.addObject("principal", actor);

		return result;
	}
	/***
	 * @RequestMapping(value = "/validate", method = RequestMethod.GET)
	 *                       public ModelAndView validate(@RequestParam final int subjectMatterId) {
	 *                       ModelAndView result;
	 *                       SubjectMatter subjectMatter;
	 *                       Administrator admin;
	 * 
	 *                       try {
	 *                       admin = this.administratorService.findByPrincipal();
	 *                       subjectMatter = this.subjectMatterService.findOne(subjectMatterId);
	 *                       subjectMatter.setValidated(true);
	 *                       this.subjectMatterService.save(subjectMatter);
	 *                       result = new ModelAndView("redirect:/subjectMatter/administrator/list.do");
	 * 
	 *                       } catch (final Throwable oops) {
	 *                       subjectMatter = this.subjectMatterService.findOne(subjectMatterId);
	 *                       result = createEditModelAndView(subjectMatter, "subjectMatter.error.editable");
	 *                       }
	 * 
	 *                       return result;
	 *                       }
	 */
	// Accept -----------------------------------------------------------

	@RequestMapping(value = "/accept", method = RequestMethod.GET)
	public ModelAndView accept(@RequestParam int subjectMatterId) {

		SubjectMatter subjectMatter = matterService.findOne(subjectMatterId);
		subjectMatter.setValidated(true);
		matterService.save(subjectMatter);

		return list();
	}

	// Deny -----------------------------------------------------------

	@RequestMapping(value = "/deny", method = RequestMethod.GET)
	public ModelAndView deny(@RequestParam int subjectMatterId) {

		SubjectMatter subjectMatter = matterService.findOne(subjectMatterId);
		subjectMatter.setValidated(false);
		matterService.delete(subjectMatter);

		return list();
	}

	//Ancillary Methods---------------------------
	/***
	 * protected ModelAndView createEditModelAndView(SubjectMatter subjectMatter) {
	 * 
	 * ModelAndView result;
	 * 
	 * result = createEditModelAndView(subjectMatter, null);
	 * 
	 * return result;
	 * }
	 * 
	 * protected ModelAndView createEditModelAndView(SubjectMatter subjectMatter, String message) {
	 * ModelAndView result;
	 * 
	 * result = new ModelAndView("subjectMatter/edit");
	 * result.addObject("subjectMatter", subjectMatter);
	 * 
	 * result.addObject("message", message);
	 * 
	 * return result;
	 * 
	 * }
	 */
}
