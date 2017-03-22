
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Proposal;
import domain.Teacher;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Integer> {
	@Query("select distinct p from Proposal p where p.teacher.city=?2 and (p.title like %?1%)")
	Collection<Proposal> findByKey(String key, String city);

	@Query("select distinct v from Proposal v where v.teacher.city=?1")
	Collection<Proposal> findByCity(String city);
	
	@Query("select distinct p from Proposal p where p.teacher.city=?2 and (p.subjectMatter.name like %?1%)")
	Collection<Proposal> findByMatter(String matter, String city);
	
	@Query("select distinct p from Proposal p where p.teacher.city=?2 and (p.subjectMatter.name like %?1%) and (p.title like %?3%)")
	Collection<Proposal> findByMatterAndKey(String matter, String city,String keyword);
	
	@Query("select  p from Proposal p where p.teacher=?1")
	Collection<Proposal> findByCreator(Teacher teacher);
	
}
