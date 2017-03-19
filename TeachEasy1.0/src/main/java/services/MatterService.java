
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

	public SubjectMatter reconstruct(final SubjectMatter subjectMatter, final BindingResult binding) {
		SubjectMatter result;

		if (subjectMatter.getId() == 0) {
			result = subjectMatter;
			this.validator.validate(result, binding);

		} else {
			result = this.subjectMatterRepository.findOne(subjectMatter.getId());

			this.validator.validate(subjectMatter, binding);
		}

		return subjectMatter;
	}
}
