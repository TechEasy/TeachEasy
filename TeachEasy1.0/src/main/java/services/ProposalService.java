
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.ProposalRepository;
import domain.Proposal;

@Service
@Transactional
public class ProposalService {

	// Managed repository

	@Autowired
	ProposalRepository	proposalRepository;


	// Supporting services

	//Constructors
	public ProposalService() {
		super();

	}

	// Simple CRUD methods
	public Proposal create() {
		Proposal result;
		result = new Proposal();
		return result;
	}

	public Collection<Proposal> findAll() {
		Collection<Proposal> result;
		result = proposalRepository.findAll();
		return result;
	}

	public Proposal findOne(int id) {
		Proposal result;
		result = proposalRepository.findOne(id);
		return result;
	}

	public Proposal save(Proposal proposal) {
		Proposal result;
		result = proposalRepository.save(proposal);
		return result;

	}

	public void delete(Proposal proposal) {
		proposalRepository.delete(proposal);
	}
}
