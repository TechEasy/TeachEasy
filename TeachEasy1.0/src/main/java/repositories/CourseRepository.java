
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Course;
import domain.Proposal;


@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	@Query("select distinct p from Course p where p.academy.city=?2 and (p.title like %?1%)")
	Collection<Course> findByKey(String key, String city);

	@Query("select distinct v.academy from Course v where v.academy.city=?1")
	Collection<Course> findByCity(String city);
	
	@Query("select distinct p from Course p where p.academy.city=?2 and (p.subjectMatter.name like %?1%)")
	Collection<Course> findByMatter(String matter, String city);
	
	@Query("select distinct p from Course p where p.academy.city=?2 and (p.subjectMatter.name like %?1%) and (p.title like %?3%)")
	Collection<Course> findByMatterAndKey(String matter, String city,String keyword);
}
