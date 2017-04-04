
package controllers;

import java.util.Collection;
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
import services.CommentableService;
import services.StudentService;
import services.TeacherService;
import domain.Academy;
import domain.Comment;
import domain.Commentable;
import domain.Teacher;

@Controller
@RequestMapping("/comment")
public class CommentController extends AbstractController {

	// Services ---------------------------------------------------------------

	@Autowired
	private CommentService		commentService;
	
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService		studentService;

	@Autowired
	private CommentableService	commentableService;

	@Autowired
	private AcademyService academyService;
	// Constructors -----------------------------------------------------------

	public CommentController() {
		super();
	}

	// Creation ---------------------------------------------------------------

	@RequestMapping("/create")
	public ModelAndView create(@RequestParam int idEntity) {
		ModelAndView result;

		Comment comment;
		Commentable commentable;

		comment = commentService.create();
		commentable = commentableService.findOne(idEntity);

		comment.setStudent(studentService.findByPrincipal());
		comment.setCommentable(commentable);
		comment.setCreateMoment(new Date());

		result = createEditModelAndView(comment);

		return result;
	}

	// Listing ----------------------------------------------------------------

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam int idEntity) {
		ModelAndView result;
		Commentable commentable;
		Collection<Comment> comments;

		commentable = commentableService.findOne(idEntity);

		comments = commentable.getComments();

		result = new ModelAndView("comment/list");

		result.addObject("requestURI", "comment/list.do");
		result.addObject("comments", comments);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid Comment comment, BindingResult bindingResult) {
		ModelAndView result;

		if (bindingResult.hasErrors()) {
			result = createEditModelAndView(comment);

		} else {
			try {
				commentService.save(comment);
				Teacher teacher;
				Academy academy;
				if(teacherService.findOne(comment.getCommentable().getId())!=null){
					teacher=teacherService.findOne(comment.getCommentable().getId());
					teacherService.updateAvgStars(teacher);
					result = new ModelAndView("redirect:../teacher/displayById.do?id=" + teacher.getId());
					
				}else{
					academy=academyService.findOne(comment.getCommentable().getId());
					academyService.updateAvgStars(academy);
					result = new ModelAndView("redirect:../academy/displayById.do?id=" + academy.getId());
				}
				
				
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
