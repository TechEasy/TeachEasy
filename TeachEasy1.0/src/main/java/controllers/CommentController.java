
package controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.AcademyService;
import services.CommentService;
import services.StudentService;
import services.TeacherService;
import domain.Academy;
import domain.Comment;
import domain.Teacher;

@Controller
@RequestMapping("/comment")
public class CommentController extends AbstractController {

	// Services ---------------------------------------------------------------

	@Autowired
	private TeacherService	teacherService;

	@Autowired
	private AcademyService	academyService;

	@Autowired
	private CommentService	commentService;

	@Autowired
	private StudentService	studentService;


	// Constructors -----------------------------------------------------------

	public CommentController() {
		super();
	}
	// Creation ---------------------------------------------------------------

	@RequestMapping("/createT")
	public ModelAndView createCommentTeacher(@RequestParam int teacherId) {
		ModelAndView result;
		Teacher teacher;
		Comment comment;

		comment = commentService.create();
		teacher = teacherService.findOne(teacherId);

		comment.setStudent(studentService.findByPrincipal());
		comment.setTeacher(teacher);
		comment.setCreateMoment(new Date(System.currentTimeMillis() - 1000));

		result = createEditModelAndView(comment);

		return result;
	}

	@RequestMapping("/createA")
	public ModelAndView createCommentAcademy(@RequestParam int academyId) {
		ModelAndView result;
		Academy academy;
		Comment comment;

		comment = commentService.create();
		academy = academyService.findOne(academyId);

		comment.setStudent(studentService.findByPrincipal());
		comment.setAcademy(academy);
		comment.setCreateMoment(new Date(System.currentTimeMillis() - 1000));

		result = createEditModelAndView(comment);

		return result;
	}
	// Listing ----------------------------------------------------------------

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid Comment comment, BindingResult bindingResult) {
		ModelAndView result;

		if (bindingResult.hasErrors()) {
			result = createEditModelAndView(comment);

		} else {
			try {
				commentService.save(comment);
				result = new ModelAndView("redirect:index.do");
			} catch (Throwable oops) {
				result = createEditModelAndView(comment, "comment.commit.error");
			}
		}
		return result;
	}

	protected ModelAndView createEditModelAndView(Comment comment) {
		ModelAndView result;
		result = createEditModelAndView(comment, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(Comment comment, String message) {

		ModelAndView result;

		result = new ModelAndView("comment/edit");
		result.addObject("comment", comment);
		result.addObject("message", message);

		return result;
	}

}
