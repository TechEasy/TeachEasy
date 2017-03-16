package controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Teacher;

import form.TeacherForm;
import services.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController extends AbstractController {

	// Services ------------------------------------------------

	@Autowired
	private TeacherService	teacherService;


	// Constructor ---------------------------------------------

	public TeacherController() {
		super();
	}

	// Display ------------------------------------------------
	@RequestMapping(value="/display", method=RequestMethod.GET)
	public ModelAndView display() {
			ModelAndView result;
			Teacher teacher;

			teacher = teacherService.findByPrincipal();
			teacher = teacherService.encryptCreditCard(teacher);
			result=new ModelAndView("teacher/display");
			result.addObject("teacher", teacher);
			result.addObject("comments", teacher.getComments());
			result.addObject("requestURI", "teacher/display.do");
			result.addObject("socialIdentities", teacher.getSocialIdentity());
			
			return result;
		}
	
	
	
	
	// Creation ------------------------------------------------

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		TeacherForm teacherForm;

		teacherForm = teacherService.generateForm();
		result = createEditModelAndView(teacherForm, null);

		return result;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid TeacherForm teacherForm, BindingResult binding) {
		ModelAndView result;
		Teacher teacher;

		if (binding.hasErrors()) {
			result = createEditModelAndView(teacherForm, null);
		} else {
			try {
				teacher = teacherService.reconstruct(teacherForm, binding);
				teacherService.save(teacher);
				result = new ModelAndView("redirect:../security/login.do");
			} catch (Throwable oops) {
				String msgCode = "teacher.register.error";
				if (oops.getMessage().equals("notEqualPassword")) {
					msgCode = "teacher.register.notEqualPassword";
				}else if (oops.getMessage().equals("agreedNotAccepted")) {
						msgCode = "teacher.register.agreedNotAccepted";
				}
				if (oops.getMessage().equals("badIban")) {
					msgCode = "teacher.badIban";
				}
				result = createEditModelAndView(teacherForm, msgCode);
			}
		}

		return result;

	}

	// Ancillary methods ---------------------------------------------------

	protected ModelAndView createEditModelAndView(TeacherForm teacherForm, String message) {
		ModelAndView result;

		result = new ModelAndView("teacher/register");
		result.addObject("teacherForm", teacherForm);
		result.addObject("message", message);

		return result;
	}

}

