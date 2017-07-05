
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import repositories.CurriculaRepository;
import security.LoginService;
import security.UserAccount;
import domain.Curricula;
import domain.Teacher;
import form.CurriculaForm;

@Service
@Transactional
public class CurriculaService {

	// Managed repository

	@Autowired
	CurriculaRepository		curriculaRepository;

	// Supporting services

	@Autowired
	private TeacherService	teacherService;

	@Autowired
	private Validator		validator;


	//Constructors
	public CurriculaService() {
		super();

	}

	// Simple CRUD methods
	public Curricula create() {
		Curricula result;
		result = new Curricula();
		result.setEducationSection("");
		result.setExperienceSection("");
		result.setHobbiesSection("");
		return result;
	}

	public Collection<Curricula> findAll() {
		Collection<Curricula> result;
		result = curriculaRepository.findAll();
		return result;
	}

	public Curricula findOne(int id) {
		Curricula result;
		result = curriculaRepository.findOne(id);
		return result;
	}

	public Curricula save(Curricula curricula) {
		UserAccount userAccount=LoginService.getPrincipal();
		Curricula result;
		Assert.isTrue(curricula.getTeacher().getUserAccount().getUsername().equals(userAccount.getUsername()),"notYourCurricula");
		result = curriculaRepository.save(curricula);
		return result;

	}
	public Curricula save2(Curricula curricula) {
		Curricula result;
		result = curriculaRepository.save(curricula);
		return result;

	}

	public void delete(Curricula curricula) {
		curriculaRepository.delete(curricula);
	}

	public CurriculaForm generateForm() {
		CurriculaForm result;

		result = new CurriculaForm();
		return result;
	}

	public Curricula reconstruct(CurriculaForm curriculaForm, BindingResult binding) {
		Teacher teacher = teacherService.findByPrincipal();

		Curricula result = teacher.getCurricula();
		result.setEducationSection(curriculaForm.getEducationSection());
		result.setExperienceSection(curriculaForm.getExperienceSection());
		result.setHobbiesSection(curriculaForm.getHobbiesSection());
		validator.validate(result, binding);

		return result;
	}

	public CurriculaForm transform(Curricula curricula) {
		CurriculaForm result = generateForm();
		result.setEducationSection(curricula.getEducationSection());
		result.setExperienceSection(curricula.getExperienceSection());
		result.setHobbiesSection(curricula.getHobbiesSection());
		return result;
	}

	public Curricula findByPrincipal() {
		Curricula result;
		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();
		result = curriculaRepository.findByUserAccount(userAccount);

		return result;
	}
}
