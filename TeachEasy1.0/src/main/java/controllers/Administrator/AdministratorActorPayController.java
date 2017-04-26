package controllers.Administrator;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.AcademyService;
import services.TeacherService;

import controllers.AbstractController;

import domain.Academy;
import domain.Teacher;

@Controller
@RequestMapping("/administrator")
public class AdministratorActorPayController extends AbstractController{
	@Autowired
	private TeacherService	teacherService;
	
	@Autowired
	private AcademyService	academyService;
	
	public AdministratorActorPayController(){
		super();
	}
	// Listing ----------------------------------------------------------------

		@RequestMapping(value = "/listToPay", method = RequestMethod.GET)
		public ModelAndView list(){
			ModelAndView result;
			Collection<Teacher> teachers;
			Collection<Academy> academies;
			
			teachers = teacherService.findTeachersToPay();
			academies = academyService.findAcademysToPay();

			result = new ModelAndView("administrator/listToPay");
			result.addObject("requestURI", "administrator/listToPay.do");
			result.addObject("teachers", teachers);
			result.addObject("academies", academies);

			return result;
		}
		
	// Pay --------------------------
		// TEACHER -------------------------------------------
	@RequestMapping(value = "/teacherPay", method = RequestMethod.GET)
	public ModelAndView teacherPay(@RequestParam int teacherId){

		Teacher teacher = teacherService.findOne(teacherId);
		teacher.setFeeAmount(0.0);
		teacherService.save(teacher);
		
		return list();
	}
	
	// ACADEMY -------------------------------------------
		@RequestMapping(value = "/academyPay", method = RequestMethod.GET)
		public ModelAndView academyPay(@RequestParam int academyId){

			Academy academy = academyService.findOne(academyId);
			academy.setFeeAmount(0.0);
			academyService.save(academy);
			
			return list();
		}
}
