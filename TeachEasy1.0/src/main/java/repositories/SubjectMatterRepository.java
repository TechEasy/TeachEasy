
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.SubjectMatter;

@Repository
public interface SubjectMatterRepository extends JpaRepository<SubjectMatter, Integer> {

}
