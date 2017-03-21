
package controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.AcademyService;
import domain.Academy;
import form.AcademyForm;

@Controller
@RequestMapping("/academy")
public class AcademyController extends AbstractController {

	// Services ------------------------------------------------

	@Autowired
	private AcademyService	academyService;


	// Constructor ---------------------------------------------

	public AcademyController() {
		super();
	}

	// Display ------------------------------------------------
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public ModelAndView display() {
		ModelAndView result;
		Academy academy;

		academy = academyService.findByPrincipal();
		academy = academyService.encryptCreditCard(academy);
		result = new ModelAndView("academy/display");
		result.addObject("academy", academy);
		result.addObject("comments", academy.getComments());
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

	@RequestMapping(value = "/register", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid AcademyForm academyForm, BindingResult binding) {
		ModelAndView result;
		Academy academy;

		if (binding.hasErrors()) {
			result = createEditModelAndView(academyForm, null);
		} else {
			try {
				academy = academyService.reconstruct(academyForm, binding);
				academyService.save(academy);
				result = new ModelAndView("redirect:../security/login.do");
			} catch (Throwable oops) {
				String msgCode = "academy.register.error";
				if (oops.getMessage().equals("notEqualPassword")) {
					msgCode = "academy.register.notEqualPassword";
				} else if (oops.getMessage().equals("agreedNotAccepted")) {
					msgCode = "academy.register.agreedNotAccepted";
				}
				if (oops.getMessage().equals("badIban")) {
					msgCode = "academy.badIban";
				}
				result = createEditModelAndView(academyForm, msgCode);
			}
		}

		return result;

	}

	// Ancillary methods ---------------------------------------------------

	protected ModelAndView createEditModelAndView(AcademyForm academyForm, String message) {
		ModelAndView result;

		result = new ModelAndView("academy/register");
		result.addObject("academyForm", academyForm);
		result.addObject("message", message);

		return result;
	}

}
