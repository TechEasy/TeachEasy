
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	@Query("select distinct p from Course p where p.academy.city=?2 and (p.title like %?1%)")
	Collection<Course> findByKey(String key, String city);

	@Query("select distinct v.academy.city from Course v where v.teacher.city=?1")
	Collection<Course> findByCity(String city);
}
