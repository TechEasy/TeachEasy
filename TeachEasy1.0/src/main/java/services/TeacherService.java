
package services;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import repositories.TeacherRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;
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
	private Validator	validator;


	//Constructors
	public TeacherService() {
		super();

	}

	// Simple CRUD methods
	public Teacher create() {
		Teacher result;
		result = new Teacher();
		
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
		result.setIban(teacher.getIban());
		result.setEmail(teacher.getEmail());
		result.setDate(teacher.getDate());
		result.setCity(teacher.getCity());
		result.setAddress(teacher.getAddress());

		return result;
	}

	public Teacher reconstruct(TeacherForm teacherForm, BindingResult binding) {

		Teacher result;

		String password;
		password = teacherForm.getPassword();

		Assert.isTrue(teacherForm.getPassword2().equals(password), "notEqualPassword");
		Assert.isTrue(teacherForm.getAgreed(), "agreedNotAccepted");
		Assert.isTrue(validarCuentaBancaria(teacherForm.getIban()), "badCreditCard");

		if(teacherForm.getId()==0){
			result = create();
		}else{
			result = teacherRepository.findOne(teacherForm.getId());
		}
		UserAccount userAccount;
		userAccount = new UserAccount();
		userAccount.setUsername(teacherForm.getUsername());
		userAccount.setPassword(password);

		Authority authority;
		authority = new Authority();
		authority.setAuthority(Authority.TEACHER);
		userAccount.addAuthority(authority);
		result.setUserAccount(userAccount);

		result.setName(teacherForm.getName());
		result.setSurname(teacherForm.getSurname());
		result.setEmail(teacherForm.getEmail());
		result.setPhone(teacherForm.getPhone());
		result.setPicture(teacherForm.getPicture());
		result.setIban(teacherForm.getIban());
		result.setCity(teacherForm.getCity());
		result.setAddress(teacherForm.getAddress());
		result.setDate(teacherForm.getDate());

		validator.validate(result, binding);

		return result;

	}
	

	public static Boolean validarCuentaBancaria(String cuenta){
		Pattern cuentaPattern = Pattern.compile("\\d{20}");
		Matcher m = cuentaPattern.matcher(cuenta);
		if (m.matches()) {
		// cuenta cumple el patrón (20 dígitos)
			String banco = cuenta.substring(0, 4);
			String sucursal = cuenta.substring(4,8);
			String dC = cuenta.substring(8, 10);
			String CCC = cuenta.substring(10, 20); 
			if (!( obtenerDigito("00" + banco + sucursal ) == Integer.parseInt(String.valueOf(dC.charAt(0)))) 
					||!(obtenerDigito(CCC) == Integer.parseInt(String.valueOf(dC.charAt(1)))))
				return false;
			else
				return true;
		}
		return false; 
		
	} 
	
	
	public static int obtenerDigito(String valor){
		Integer[] valores = new Integer[]{1, 2, 4, 8, 5, 10, 9, 7, 3, 6};
	
		Integer control = 0;
		for (int i=0; i <=9; i++)
			control += Integer.parseInt(String.valueOf(valor.charAt(i))) * valores[i];
			control = 11 - (control % 11);
		if (control == 11) 
			control = 0;
		else if (control == 10) 
			control = 1;
		return control;
	}
	
	public Teacher findByPrincipal() {
		Teacher result;
		int userAccountId;

		userAccountId = LoginService.getPrincipal().getId();
		result = teacherRepository.findByUserAccountId(userAccountId);

		return result;
	}
}
