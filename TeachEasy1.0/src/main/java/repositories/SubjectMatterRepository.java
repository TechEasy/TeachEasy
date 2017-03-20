
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.SubjectMatter;

@Repository
public interface SubjectMatterRepository extends JpaRepository<SubjectMatter, Integer> {

	@Query("select s from SubjectMatter s where s.validated = true")
	Collection<SubjectMatter> findSubjectMatterValidated();

}
