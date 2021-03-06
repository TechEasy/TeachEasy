
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

	@Query("select t from Teacher t where t.userAccount.id=?1")
	Teacher findByUserAccountId(int id);

	@Query("select 1.0*(select sum(c.stars) from Comment c where c.commentable=?1)/count(c1) from Comment c1 where c1.commentable=?1")
	Double fingAvgStars(Teacher teacher);
	
	@Query("select t from Teacher t where t.feeAmount!=0")
	Collection<Teacher> findTeachersToPay();
}
