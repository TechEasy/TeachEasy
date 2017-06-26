
package services;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import repositories.TeacherRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;
import domain.Curricula;
import domain.Teacher;
import form.TeacherForm;

@Service
@Transactional
public class TeacherService {

	// Managed repository

	@Autowired
	private TeacherRepository	teacherRepository;

	// Supporting services

	@Autowired
	private Validator			validator;

	@Autowired
	private CurriculaService	curriculaService;


	//Constructors
	public TeacherService() {
		super();

	}

	// Simple CRUD methods
	public Teacher create() {
		Teacher result;
		Curricula curricula = curriculaService.create();
		curricula = curriculaService.save(curricula);
		result = new Teacher();

		result.setCurricula(curricula);
		result.setAvgStars(0.0);
		result.setFeeAmount(0.0);
		return result;
	}

	public Collection<Teacher> findAll() {
		Collection<Teacher> result;
		result = teacherRepository.findAll();
		return result;
	}

	public Teacher findOne(int id) {
		Teacher result;
		result = teacherRepository.findOne(id);
		return result;
	}

	public Teacher save(Teacher teacher) {
		Teacher result;

		String password = teacher.getUserAccount().getPassword();
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String md5 = encoder.encodePassword(password, null);
		teacher.getUserAccount().setPassword(md5);

		result = teacherRepository.save(teacher);
		return result;

	}
	
	public Teacher save2(Teacher teacher) {
		Teacher result;

		result = teacherRepository.save(teacher);
		return result;

	}

	public void delete(Teacher teacher) {
		teacherRepository.delete(teacher);
	}

	// Form methods ------------------------------------------------

	public TeacherForm generateForm() {
		TeacherForm result;

		result = new TeacherForm();
		return result;
	}

	public TeacherForm generateForm(Teacher teacher) {
		TeacherForm result;

		result = new TeacherForm();

		result.setId(teacher.getId());
		result.setUsername(teacher.getUserAccount().getUsername());
		result.setPassword(teacher.getUserAccount().getPassword());
		result.setPassword2(teacher.getUserAccount().getPassword());
		result.setName(teacher.getName());
		result.setAgreed(true);
		result.setSurname(teacher.getSurname());
		result.setPhone(teacher.getPhone());
		result.setPicture(teacher.getPicture());
		result.setPaypalMail(teacher.getPaypalMail());
		result.setEmail(teacher.getEmail());
		result.setDate(teacher.getDate());
		result.setCity(teacher.getCity());
		result.setAddress(teacher.getAddress());

		return result;
	}

	public Teacher reconstruct(TeacherForm teacherForm, BindingResult binding) {

		Teacher result;
		DateTime today = new DateTime();
		DateTime birthDate = new DateTime(teacherForm.getDate());

		String password;
		password = teacherForm.getPassword();

		Assert.isTrue(birthDate.isBefore(today.minusYears(18)), "not18Old");
		Assert.isTrue(teacherForm.getPassword2().equals(password), "notEqualPassword");
		Assert.isTrue(teacherForm.getAgreed(), "agreedNotAccepted");

		if (teacherForm.getId() == 0){
			result = create();
			UserAccount userAccount;
			userAccount = new UserAccount();
			userAccount.setUsername(teacherForm.getUsername());
			userAccount.setPassword(password);

			Authority authority;
			authority = new Authority();
			authority.setAuthority(Authority.TEACHER);
			userAccount.addAuthority(authority);
			result.setUserAccount(userAccount);
		}else{
			result = teacherRepository.findOne(teacherForm.getId());
		}
		
		result.setName(teacherForm.getName());
		result.setSurname(teacherForm.getSurname());
		result.setEmail(teacherForm.getEmail());
		result.setPhone(teacherForm.getPhone());
		result.setPicture(teacherForm.getPicture());
		result.setPaypalMail(teacherForm.getPaypalMail());
		result.setCity(teacherForm.getCity());
		result.setAddress(teacherForm.getAddress());
		result.setDate(teacherForm.getDate());

		validator.validate(result, binding);

		return result;

	}

	
	  public static Boolean validarCuentaBancaria(String cuenta){
	  
	  String A = cuenta.substring(0, 1);
	  String B = cuenta.substring(1, 2);
	  
	  List<String>letras = Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
	  Integer primero = 10+letras.indexOf(A);
	  Integer segundo = 10+letras.indexOf(B);
	  
	  cuenta = primero.toString()+segundo.toString()+cuenta.substring(2);
	  cuenta = cuenta.substring(6)+cuenta.substring(0, 6);
	  
	  BigInteger numero = new BigInteger(cuenta);
	  BigInteger v = new BigInteger("97");
	  BigInteger s = new BigInteger("1");
	  BigInteger validador = numero.mod(v);
	  
	  if (validador.compareTo(s)==0){
	  return true;
	  }else{
	  return false;
	  }
	  
	  }
	 

	public Teacher findByPrincipal() {
		Teacher result;
		int userAccountId;

		userAccountId = LoginService.getPrincipal().getId();
		result = teacherRepository.findByUserAccountId(userAccountId);

		return result;
	}

	public Double findAvgStars(Teacher teacher) {
		Double result;
		result = teacherRepository.fingAvgStars(teacher);
		return result;
	}

	public void updateAvgStars(Teacher teacher) {
		teacher.setAvgStars(teacherRepository.fingAvgStars(teacher));
		save2(teacher);
	}

	public Teacher findRandom() {
		Teacher t = new Teacher();
		Object[] ts = findAll().toArray();
		int min = 0;
		int max = ts.length;
		int randomNum = ThreadLocalRandom.current().nextInt(min, max);
		t = (Teacher) ts[randomNum];

		return t;
	}

	public Collection<Teacher> findTeachersToPay(){
		return teacherRepository.findTeachersToPay();
	}
	
	
}
