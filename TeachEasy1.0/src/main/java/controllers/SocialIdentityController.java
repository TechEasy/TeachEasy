
package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import security.Authority;
import security.LoginService;
import services.AcademyService;
import services.ActorService;
import services.SocialIdentityService;
import services.TeacherService;
import domain.Academy;
import domain.Actor;
import domain.SocialIdentity;

@Controller
@RequestMapping("/socialIdentity")
public class SocialIdentityController extends AbstractController {

	@Autowired
	private SocialIdentityService	socialIdentityService;

	@Autowired
	private ActorService			actorService;

	@Autowired
	private AcademyService			academyService;
	
	@Autowired
	private TeacherService			teacherService;


	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView result;

		Collection<SocialIdentity> socialIdentity;

		Actor actor;
		actor = actorService.findByPrincipal();
		Academy academy;
		academy = academyService.findByPrincipal();

		Authority au = new Authority();
		au.setAuthority(Authority.STUDENT);

		Authority au1 = new Authority();
		au1.setAuthority(Authority.TEACHER);

		Authority au2 = new Authority();
		au2.setAuthority(Authority.ACADEMY);

		result = new ModelAndView("socialIdentity/list");
		if (LoginService.getPrincipal().getAuthorities().contains(au) || LoginService.getPrincipal().getAuthorities().contains(au1)) {
			socialIdentity = actor.getSocialIdentity();
			result.addObject("socialIdentity", socialIdentity);

		} else if (LoginService.getPrincipal().getAuthorities().contains(au2)) {
			socialIdentity = academy.getSocialIdentity();
			result.addObject("socialIdentity", socialIdentity);
		}
		return result;
	}

	@RequestMapping("/create")
	public ModelAndView create() {

		ModelAndView result;
		SocialIdentity socialIdentity;

		socialIdentity = socialIdentityService.create();

		result = createEditModelAndView(socialIdentity);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam String socialIdentityId) {
		ModelAndView result;
		SocialIdentity socialIdentity;		
		
		try{
			if(socialIdentityId.length()<10){
				int id = Integer.valueOf(socialIdentityId);
				socialIdentity = socialIdentityService.findOne(id);
			}else
				socialIdentity=null;
			
			
			if(academyService.findByPrincipal()!=null){
				if(socialIdentity==null || !academyService.findByPrincipal().equals(socialIdentity.getAcademy())){
					result = list();
					String msg = "socialIdentity.notYours";
					result.addObject("msg", msg);
				}else{
					result = createEditModelAndView(socialIdentity);
				}
			}else{
				if(socialIdentity==null || !teacherService.findByPrincipal().equals(socialIdentity.getActor())){
					result = list();
					String msg = "socialIdentity.notYours";
					result.addObject("msg", msg);
				}else{
					result = createEditModelAndView(socialIdentity);
				}
			}
			
		}catch (Throwable oops) {
			result = list();
			String msg = "socialIdentity.notYours";
			result.addObject("msg", msg);
		}

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(SocialIdentity socialIdentity, BindingResult binding) {
		ModelAndView result;

		
		if (binding.hasErrors()) {
			result = createEditModelAndView(socialIdentity);
		} else {
			try {
				socialIdentity = socialIdentityService.reconstruct(socialIdentity, binding);
				socialIdentityService.save(socialIdentity);

				result = new ModelAndView("redirect:/socialIdentity/list.do");
			} catch (Throwable oops) {

				String msgCode = "registerSocialIdentity.commit.error";
				
				if (oops.getMessage().equals("notYourSocial")){
					msgCode="socialIdentity.notYourSocial";
				}else if(oops.getMessage().equals("urlMustBeUnique")){
					msgCode="socialIdentity.urlExist";
				}
				result = createEditModelAndView(socialIdentity, msgCode);
			}
		}

		return result;
	}
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(SocialIdentity socialIdentity, BindingResult binding) {
		ModelAndView result;

		try {

			socialIdentityService.delete(socialIdentity);

			result = new ModelAndView("redirect:/socialIdentity/list.do");
		} catch (Throwable oops) {
			//System.out.println(oops.getMessage());
			result = createEditModelAndView(socialIdentity, "registerSocialIdentity.commit.error");
		}

		return result;
	}
	protected ModelAndView createEditModelAndView(SocialIdentity socialIdentity) {
		ModelAndView result;

		result = createEditModelAndView(socialIdentity, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(SocialIdentity socialIdentity, String message) {
		ModelAndView result;

		result = new ModelAndView("socialIdentity/edit");

		result.addObject("socialIdentity", socialIdentity);
		result.addObject("message", message);

		return result;
	}
}
