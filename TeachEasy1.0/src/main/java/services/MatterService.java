
package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import repositories.SubjectMatterRepository;
import domain.SubjectMatter;

@Service
@Transactional
public class MatterService {

	// Managed repository

	@Autowired
	SubjectMatterRepository	subjectMatterRepository;

	@Autowired
	AdministratorService	administratorService;

	@Autowired
	private Validator		validator;


	// Supporting services

	//Constructors
	public MatterService() {
		super();

	}

	// Simple CRUD methods
	public SubjectMatter create() {
		SubjectMatter result;
		result = new SubjectMatter();
		result.setValidated(false);
		return result;
	}

	public Collection<SubjectMatter> findAll() {
		Collection<SubjectMatter> result;
		result = subjectMatterRepository.findAll();
		return result;
	}

	public SubjectMatter findOne(int id) {
		SubjectMatter result;
		result = subjectMatterRepository.findOne(id);
		return result;
	}

	public SubjectMatter save(SubjectMatter matter) {
		SubjectMatter result;
		result = subjectMatterRepository.save(matter);
		return result;

	}

	public void delete(SubjectMatter matter) {
		subjectMatterRepository.delete(matter);
	}

	public SubjectMatter reconstruct(SubjectMatter subjectMatter, BindingResult binding) {
		SubjectMatter result;
		Collection<SubjectMatter> col = new ArrayList<SubjectMatter>();
		
		col = findAll();
		
		for(SubjectMatter s : col){
			Assert.isTrue(!s.getName().equals(subjectMatter.getName()), "usedThisName");
		}

		
		
		if (subjectMatter.getId() == 0) {
			result = subjectMatter;
			result.setValidated(false);
			this.validator.validate(result, binding);

		} else {
			result = this.subjectMatterRepository.findOne(subjectMatter.getId());

			this.validator.validate(subjectMatter, binding);
		}

		return subjectMatter;
	}

	public Collection<SubjectMatter> findSubjectMatterValidated() {
		Collection<SubjectMatter> result;
		result = subjectMatterRepository.findSubjectMatterValidated();

		return result;
	}
}
