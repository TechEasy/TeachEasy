
package services;

import java.util.Collection;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import repositories.FinderRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;
import domain.Finder;
import domain.Student;
import form.FinderForm;

@Service
@Transactional
public class FinderService {

	// Managed repository

	@Autowired
	private FinderRepository	finderRepository;
	
	@Autowired
	private StudentService studentService;

	@Autowired
	private Validator validator;
	// Supporting services

	//Constructors
	public FinderService() {
		super();

	}

	// Simple CRUD methods
	public Finder create() {

		Finder result;
		result = new Finder();

		result.setCity("Ciudad");
		

		save2(result);

		return result;
	}

	public Collection<Finder> findAll() {
		Collection<Finder> result;
		result = finderRepository.findAll();
		return result;
	}

	public Finder findOne(int id) {
		Finder result;
		result = finderRepository.findOne(id);
		return result;
	}
	public Finder save(Finder finder) {

		UserAccount userAccount;
		userAccount = LoginService.getPrincipal();
		Authority au = new Authority();
		au.setAuthority("STUDENT");
		Assert.isTrue(userAccount.getAuthorities().contains(au));

		Assert.notNull(finder);

		Finder result;

		result = finderRepository.save(finder);

		return result;
	}
	public Finder save2(Finder finder) {
		Finder result;
		result = finderRepository.save(finder);
		return result;

	}

	public void delete(Finder finder) {
		finderRepository.delete(finder);
	}
	public Finder findByPrincipal() {
		Finder result;
		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();
		result = finderRepository.findByUserAccount(userAccount);

		return result;
	}
	public FinderForm generateForm() {
		FinderForm result;

		result = new FinderForm();
		return result;
	}
	
	public Finder reconstruct(FinderForm finderForm, BindingResult binding) {
		Student student=studentService.findByPrincipal();
		
		Finder result = student.getFinder();
		result.setCity(finderForm.getCity());
		result.setMinimumPrice(finderForm.getMinimumPrice());
		result.setMaximumPrice(finderForm.getMaximumPrice());
		result.setKeyword(finderForm.getKeyword());
		result.setMatter(finderForm.getMatter());
		validator.validate(result, binding);
		
		return result;
	}

	public FinderForm transform(Finder finder){
		FinderForm result=generateForm();
		result.setCity(finder.getCity());
		result.setMinimumPrice(finder.getMinimumPrice());
		result.setMaximumPrice(finder.getMaximumPrice());
		result.setKeyword(finder.getKeyword());
		result.setMatter(finder.getMatter());
		return result;
	}

}
