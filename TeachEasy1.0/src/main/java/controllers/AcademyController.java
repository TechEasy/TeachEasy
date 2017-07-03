
package controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.AcademyService;
import services.CourseService;
import domain.Academy;
import domain.Course;
import domain.Teacher;
import form.AcademyForm;
import form.TeacherForm;

@Controller
@RequestMapping("/academy")
public class AcademyController extends AbstractController {

	// Services ------------------------------------------------

	@Autowired
	private AcademyService	academyService;

	@Autowired
	private CourseService	courseService;


	// Constructor ---------------------------------------------

	public AcademyController() {
		super();
	}
	// Display by Id ------------------------------------------------
	@RequestMapping(value = "/displayById", method = RequestMethod.GET)
	public ModelAndView displayById(@RequestParam int id) {
		ModelAndView result;
		Academy academy;
		if (courseService.findOne(id) != null) {
			Course p = courseService.findOne(id);
			academy = p.getAcademy();
			result = new ModelAndView("academy/display");
			result.addObject("academy", academy);
			result.addObject("commentable", academy.getComments());
			result.addObject("requestURI", "academy/display.do");
			result.addObject("socialIdentities", academy.getSocialIdentity());
		} else {
			academy = academyService.findOne(id);
			result = new ModelAndView("academy/display");
			result.addObject("academy", academy);
			result.addObject("commentable", academy.getComments());
			result.addObject("requestURI", "academy/display.do");
			result.addObject("socialIdentities", academy.getSocialIdentity());
		}
		return result;
	}
	// Display ------------------------------------------------
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public ModelAndView display() {
		ModelAndView result;
		Academy academy;

		academy = academyService.findByPrincipal();
		result = new ModelAndView("academy/display");
		result.addObject("academy", academy);
		result.addObject("commentable", academy.getComments());
		result.addObject("requestURI", "academy/display.do");
		result.addObject("socialIdentities", academy.getSocialIdentity());

		return result;
	}

	// Browse ------------------------------------------------
	@RequestMapping(value = "/browse", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Academy> academies;
		academies = academyService.findAll();
		result = new ModelAndView("academy/browse");
		result.addObject("academies", academies);
		result.addObject("requestURI", "academy/browse.do");

		return result;
	}

	// Creation ------------------------------------------------

		@RequestMapping(value = "/register", method = RequestMethod.GET)
		public ModelAndView create() {
			ModelAndView result;
			AcademyForm academyForm;

			academyForm = academyService.generateForm();
			result = createEditModelAndView(academyForm, null);

			return result;
		}
		
		@RequestMapping(value = "/edit", method = RequestMethod.GET)
		public ModelAndView edit() {
			ModelAndView result;
			AcademyForm academyForm;

			academyForm = academyService.generateForm(academyService.findByPrincipal());
			result = new ModelAndView("academy/edit");
			result.addObject("academyForm", academyForm);

			return result;
		}

		@RequestMapping(value = "/register", method = RequestMethod.POST, params = "save")
		public ModelAndView save(@Valid AcademyForm academyForm, BindingResult binding) {
			ModelAndView result;
			Academy academy;

			if (binding.hasErrors())
				result = createEditModelAndView(academyForm, null);
			else
				try {
					academy = academyService.reconstruct(academyForm, binding);
					
					if(academy.getId()==0){
						academyService.save(academy);
						result = new ModelAndView("redirect:../security/login.do");
					}else{
						academyService.save2(academy);
						result = display();
					}
					
				} catch (Throwable oops) {
					String msgCode = "academy.register.error";
					if (oops.getMessage().equals("notEqualPassword"))
						msgCode = "academy.register.notEqualPassword";
					else if (oops.getMessage().equals("agreedNotAccepted"))
						msgCode = "academy.register.agreedNotAccepted";
					else if(oops.getMessage().equals("notYou")){
						msgCode="academy.notYou";
					}
					result = createEditModelAndView(academyForm, msgCode);
				}

			return result;

		}

	// Ancillary methods ---------------------------------------------------

	public ModelAndView createEditModelAndView(AcademyForm academyForm) {
		ModelAndView result;
		result = createEditModelAndView(academyForm, null);

		return result;
	}

	public ModelAndView createEditModelAndView(AcademyForm academyForm, String message) {
		ModelAndView result;

		result = new ModelAndView("academy/register");
		result.addObject("academyForm", academyForm);
		result.addObject("message", message);

		return result;
	}

}
