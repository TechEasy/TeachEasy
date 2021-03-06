
package controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
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
	private TeacherService		teacherService;
	@Autowired
	private StudentService		studentService;

	@Autowired
	private CommentableService	commentableService;

	@Autowired
	private AcademyService		academyService;

	@Autowired
	private Validator			validator;


	// Constructors -----------------------------------------------------------

	public CommentController() {
		super();
	}

	// Creation ---------------------------------------------------------------

	@RequestMapping("/edit")
	public ModelAndView create(String idEntity) {
		ModelAndView result;

		Comment comment = commentService.create();
		Commentable commentable;
		
		if(idEntity==null || idEntity.equals("")){
			result = new ModelAndView("redirect:../welcome/index.do");
		}else{
			if(idEntity.length()<10){
				int id = Integer.valueOf(idEntity);
				commentable = commentableService.findOne(id);
			}else
				commentable=null;
			
			if(commentable==null){
				result = new ModelAndView("redirect:../welcome/index.do");
			}else{

				comment.setStudent(studentService.findByPrincipal());
				comment.setCommentable(commentable);
				comment.setCreateMoment(new Date());
				result = createEditModelAndView(comment);
			}
		}

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
				if (teacherService.findOne(comment.getCommentable().getId()) != null) {
					teacher = teacherService.findOne(comment.getCommentable().getId());
					teacherService.updateAvgStars(teacher);
					result = new ModelAndView("redirect:../teacher/displayById.do?id=" + teacher.getId());

				} else {
					academy = academyService.findOne(comment.getCommentable().getId());
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
		Boolean aux;
		Collection<Integer> stars = new ArrayList<Integer>();
		stars.add(0);
		stars.add(1);
		stars.add(2);
		stars.add(3);
		stars.add(4);
		stars.add(5);
		
		if(teacherService.findOne(comment.getCommentable().getId())!=null){
			aux=true;
		}else{
			aux=false;
		}

		result = new ModelAndView("comment/edit");
		result.addObject("comment", comment);
		result.addObject("stars", stars);
		result.addObject("message", message);
		result.addObject("aux", aux);
		result.addObject("comId", comment.getCommentable().getId());

		return result;
	}

}
