
package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.ProposalRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;
import domain.Finder;
import domain.Proposal;
import domain.Teacher;

@Service
@Transactional
public class ProposalService {

	// Managed repository

	@Autowired
	ProposalRepository	proposalRepository;

	// Supporting services

	@Autowired
	TeacherService		teacherService;


	//Constructors
	public ProposalService() {
		super();

	}

	// Simple CRUD methods
	public Proposal create() {
		Proposal result;
		Teacher t = teacherService.findByPrincipal();
		result = new Proposal();
		result.setTeacher(t);
		result.setCreateMoment(new Date());
		result.setUpdateMoment(new Date());
		result.setAvailable(true);
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
		Authority a = new Authority();
		a.setAuthority(Authority.TEACHER);
		UserAccount userAccount;
		userAccount = LoginService.getPrincipal();
		Proposal result;
		result = new Proposal();
		
	
		Assert.isTrue(userAccount.getAuthorities().contains(a) && 
				proposal.getTeacher().getUserAccount().getUsername().equals(userAccount.getUsername()), "notYourProposal");
		Date date = new Date(System.currentTimeMillis() - 1000);
		result.setUpdateMoment(date);
		result = proposalRepository.save(proposal);
		
		
		return result;

	}

	public void delete(Proposal proposal) {
		proposalRepository.delete(proposal);
	}
	public Collection<Proposal> findByFinder(Finder finder) {
		Collection<Proposal> result = new ArrayList<Proposal>();
		Collection<Proposal> aux;
		Collection<Proposal> aux2 = new ArrayList<Proposal>();
		if (finder.getKeyword() == null && finder.getMatter() == null) {
			aux = proposalRepository.findByCity(finder.getCity());
		} else if (finder.getMatter() == null) {
			aux = proposalRepository.findByKey(finder.getKeyword(), finder.getCity());
		} else if (finder.getKeyword() == null) {
			aux = proposalRepository.findByMatter(finder.getMatter(), finder.getCity());
		} else {
			aux = proposalRepository.findByMatterAndKey(finder.getMatter(), finder.getCity(), finder.getKeyword());
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
		for(Proposal p:result){
			if(p.getAvailable()==true){
				aux2.add(p);
			}
		}
		return aux2;

	}
	public Collection<Proposal> findByCreator(Teacher teacher) {
		Collection<Proposal> result = proposalRepository.findByCreator(teacher);
		return result;
	}

	public Collection<Proposal> findAvailable() {
		Collection<Proposal> result = proposalRepository.findAvailable();
		return result;
	}
}
