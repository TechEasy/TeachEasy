
package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.ProposalRepository;
import domain.Finder;
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
	public Collection<Proposal> findByFinder(Finder finder) {
		Collection<Proposal> result = new ArrayList<Proposal>();
		Collection<Proposal> aux;
		if (finder.getKeyword() == null && finder.getMatter()==null) {
			aux = proposalRepository.findByCity(finder.getCity());
		} else if(finder.getMatter()==null){
			aux = proposalRepository.findByKey(finder.getKeyword(), finder.getCity());
		}else if(finder.getKeyword()==null){
			aux = proposalRepository.findByMatter(finder.getMatter(), finder.getCity());
		}else{
			aux = proposalRepository.findByMatterAndKey(finder.getMatter(), finder.getCity(),finder.getKeyword());
		}
		if (finder.getMinimumPrice() == null && finder.getMaximumPrice() == null) {
			result = aux;
		} else if (finder.getMinimumPrice() == null) {
			for (Proposal p : aux) {
				if (p.getRate() <= finder.getMaximumPrice()) {
					result.add(p);
				}
			}
		} else if (finder.getMaximumPrice() == null) {
			for (Proposal p : aux) {
				if (p.getRate() >= finder.getMinimumPrice()) {
					result.add(p);
				}
			}
		} else {
			for (Proposal p : aux) {
				if (p.getRate() >= finder.getMinimumPrice() && p.getRate() <= finder.getMaximumPrice()) {
					result.add(p);
				}
			}
		}
		return result;

	}
}
