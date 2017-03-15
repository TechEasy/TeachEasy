
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Proposal;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Integer> {
	@Query("select distinct p from Proposal p where p.teacher.city=?2 and (p.title like %?1%)")
	Collection<Proposal> findByKey(String key, String city);

	@Query("select distinct v.teacher.city from Proposal v where v.teacher.city=?1")
	Collection<Proposal> findByCity(String city);
}
