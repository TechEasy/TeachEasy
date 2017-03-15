
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.SubjectMatterRepository;
import domain.SubjectMatter;

@Service
@Transactional
public class MatterService {

	// Managed repository

	@Autowired
	SubjectMatterRepository	matterRepository;


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
		result = matterRepository.findAll();
		return result;
	}

	public SubjectMatter findOne(int id) {
		SubjectMatter result;
		result = matterRepository.findOne(id);
		return result;
	}

	public SubjectMatter save(SubjectMatter matter) {
		SubjectMatter result;
		result = matterRepository.save(matter);
		return result;

	}

	public void delete(SubjectMatter matter) {
		matterRepository.delete(matter);
	}
}
