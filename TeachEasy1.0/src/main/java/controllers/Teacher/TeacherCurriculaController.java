
package controllers.Teacher;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.CurriculaService;
import controllers.AbstractController;
import domain.Curricula;
import form.CurriculaForm;

@Controller
@RequestMapping("/teacher/curricula")
public class TeacherCurriculaController extends AbstractController {

	@Autowired
	private CurriculaService	curriculaService;


	public TeacherCurriculaController() {
		super();

	}

	// Edition ----------------------------------------------------------------		
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit() {
		ModelAndView result;
		CurriculaForm curriculaForm;

		curriculaForm = curriculaService.generateForm();
		result = createEditModelAndView(curriculaForm, null);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid CurriculaForm curriculaForm, BindingResult binding) {

		ModelAndView result;
		Curricula curricula;
		if (binding.hasErrors()) {
			result = createEditModelAndView(curriculaForm);
		} else {
			try {
				curricula = curriculaService.reconstruct(curriculaForm, binding);
				curriculaService.save(curricula);
				result = new ModelAndView("welcome/index");
			} catch (Throwable oops) {
				result = createEditModelAndView(curriculaForm, "master.page.commit.error");
			}

		}
		return result;
	}

	protected ModelAndView createEditModelAndView(CurriculaForm curriculaForm) {

		ModelAndView result;

		result = createEditModelAndView(curriculaForm, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(CurriculaForm curriculaForm, String message) {
		ModelAndView result;

		result = new ModelAndView("curricula/edit");
		result.addObject("curricula", curriculaForm);

		result.addObject("message", message);

		return result;

	}

}
