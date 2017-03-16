
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import domain.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

	@Query("select t from Teacher t where t.userAccount.id=?1")
	Teacher findByUserAccountId(int id);

	@Query("select 1.0*(select sum(c.stars) from Comment c where c.teacher=?1)/count(c1) from Comment c1 where c1.teacher=?1")
	Double fingAvgStars(Teacher teacher);
}
