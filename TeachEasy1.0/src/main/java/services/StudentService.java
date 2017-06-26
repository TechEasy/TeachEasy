
package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import repositories.StudentRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;
import domain.Comment;
import domain.Finder;
import domain.Request;
import domain.SocialIdentity;
import domain.Student;
import form.StudentForm;

@Service
@Transactional
public class StudentService {

	// Managed repository

	@Autowired
	private StudentRepository	studentRepository;

	// Supporting services

	@Autowired
	private Validator			validator;

	@Autowired
	private FinderService		finderService;


	//Constructors
	public StudentService() {
		super();

	}

	// Simple CRUD methods
	public Student create() {
		Student result;
		Collection<SocialIdentity> socialIdentity = new ArrayList<SocialIdentity>();
		Collection<Comment> comments = new ArrayList<Comment>();
		Collection<Request> requests = new ArrayList<Request>();
		result = new Student();

		Finder finder = finderService.create();

		Finder f2 = finderService.save2(finder);
		result.setRequests(requests);
		result.setSocialIdentity(socialIdentity);
		result.setFinder(f2);
		return result;
	}

	public Collection<Student> findAll() {
		Collection<Student> result;
		result = studentRepository.findAll();
		return result;
	}

	public Student findOne(int id) {
		Student result;
		result = studentRepository.findOne(id);
		return result;
	}

	public Student save(Student student) {
		Student result;

		String password = student.getUserAccount().getPassword();
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String md5 = encoder.encodePassword(password, null);
		student.getUserAccount().setPassword(md5);

		result = studentRepository.save(student);
		return result;

	}

	public Student save2(Student student) {
		Student result;

		result = studentRepository.save(student);
		return result;

	}

	public void delete(Student student) {
		studentRepository.delete(student);
	}

	// Form methods ------------------------------------------------

	public StudentForm generateForm() {
		StudentForm result;

		result = new StudentForm();
		return result;
	}

	public StudentForm generateForm(Student student) {
		StudentForm result;

		result = new StudentForm();

		result.setId(student.getId());
		result.setUsername(student.getUserAccount().getUsername());
		result.setPassword(student.getUserAccount().getPassword());
		result.setPassword2(student.getUserAccount().getPassword());
		result.setName(student.getName());
		result.setAgreed(true);
		result.setSurname(student.getSurname());
		result.setPhone(student.getPhone());
		result.setPicture(student.getPicture());
		result.setEmail(student.getEmail());
		result.setDate(student.getDate());
		result.setCity(student.getCity());
		result.setAddress(student.getAddress());

		return result;
	}

	public Student reconstruct(StudentForm studentForm, BindingResult binding) {

		Student result;
		DateTime today = new DateTime();
		DateTime birthDate = new DateTime(studentForm.getDate());
		String password;
		password = studentForm.getPassword();

		Assert.isTrue(birthDate.isBefore(today.minusYears(18)), "not18Old");
		Assert.isTrue(studentForm.getPassword2().equals(password), "notEqualPassword");
		Assert.isTrue(studentForm.getAgreed(), "agreedNotAccepted");

		if (studentForm.getId() == 0) {
			result = create();
			UserAccount userAccount;
			userAccount = new UserAccount();
			userAccount.setUsername(studentForm.getUsername());
			userAccount.setPassword(password);

			Authority authority;
			authority = new Authority();
			authority.setAuthority(Authority.STUDENT);
			userAccount.addAuthority(authority);
			result.setUserAccount(userAccount);
		} else {
			result = studentRepository.findOne(studentForm.getId());
		}

		result.setName(studentForm.getName());
		result.setSurname(studentForm.getSurname());
		result.setEmail(studentForm.getEmail());
		result.setPhone(studentForm.getPhone());
		result.setPicture(studentForm.getPicture());
		result.setCity(studentForm.getCity());
		result.setAddress(studentForm.getAddress());
		result.setDate(studentForm.getDate());

		validator.validate(result, binding);

		return result;

	}

	public Student findByPrincipal() {
		Student result;
		int userAccountId;

		userAccountId = LoginService.getPrincipal().getId();
		result = studentRepository.findByUserAccountId(userAccountId);

		return result;
	}

}
