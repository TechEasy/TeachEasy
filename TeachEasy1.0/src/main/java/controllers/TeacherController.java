
package controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.ProposalService;
import services.TeacherService;
import domain.Proposal;
import domain.Teacher;
import form.TeacherForm;

@Controller
@RequestMapping("/teacher")
public class TeacherController extends AbstractController {

	// Services ------------------------------------------------

	@Autowired
	private TeacherService	teacherService;

	@Autowired
	private ProposalService	proposalService;


	// Constructor ---------------------------------------------

	public TeacherController() {
		super();
	}

	// Display ------------------------------------------------
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public ModelAndView display() {
		ModelAndView result;
		Teacher teacher;

		teacher = teacherService.findByPrincipal();
		result = new ModelAndView("teacher/display");
		result.addObject("teacher", teacher);
		result.addObject("commentable", teacher.getComments());
		result.addObject("requestURI", "teacher/display.do");
		result.addObject("socialIdentities", teacher.getSocialIdentity());

		return result;
	}

	// Display by Id ------------------------------------------------
	@RequestMapping(value = "/displayById", method = RequestMethod.GET)
	public ModelAndView displayById(@RequestParam int id) {
		ModelAndView result;
		Teacher teacher;
		if (proposalService.findOne(id) != null) {
			Proposal p = proposalService.findOne(id);
			teacher = p.getTeacher();
			result = new ModelAndView("teacher/display");
			result.addObject("teacher", teacher);
			result.addObject("commentable", teacher.getComments());
			result.addObject("requestURI", "teacher/display.do");
			result.addObject("socialIdentities", teacher.getSocialIdentity());
		} else {
			teacher = teacherService.findOne(id);
			result = new ModelAndView("teacher/display");
			result.addObject("teacher", teacher);
			result.addObject("commentable", teacher.getComments());
			result.addObject("requestURI", "teacher/display.do");
			result.addObject("socialIdentities", teacher.getSocialIdentity());
		}
		return result;
	}
	// Browse ------------------------------------------------
	@RequestMapping(value = "/browse", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Teacher> teachers;
		teachers = teacherService.findAll();
		result = new ModelAndView("teacher/browse");
		result.addObject("teachers", teachers);

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
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit() {
		ModelAndView result;
		TeacherForm teacherForm;

		teacherForm = teacherService.generateForm(teacherService.findByPrincipal());
		result = createEditModelAndView(teacherForm, null);

		return result;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid TeacherForm teacherForm, BindingResult binding) {
		ModelAndView result;
		Teacher teacher;

		if (binding.hasErrors())
			result = createEditModelAndView(teacherForm, null);
		else
			try {
				teacher = teacherService.reconstruct(teacherForm, binding);
				
				if(teacher.getId()==0){
					teacherService.save(teacher);
					result = new ModelAndView("redirect:../security/login.do");
				}else{
					teacherService.save2(teacher);
					result = display();
				}
				
			} catch (Throwable oops) {
				String msgCode = "teacher.register.error";
				if (oops.getMessage().equals("notEqualPassword"))
					msgCode = "teacher.register.notEqualPassword";
				else if (oops.getMessage().equals("agreedNotAccepted"))
					msgCode = "teacher.register.agreedNotAccepted";

				result = createEditModelAndView(teacherForm, msgCode);
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
