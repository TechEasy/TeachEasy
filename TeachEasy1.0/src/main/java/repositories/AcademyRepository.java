
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Academy;

@Repository
public interface AcademyRepository extends JpaRepository<Academy, Integer> {

	@Query("select t from Academy t where t.userAccount.id=?1")
	Academy findByUserAccountId(int id);

	@Query("select 1.0*(select sum(c.stars) from Comment c where c.commentable=?1)/count(c1) from Comment c1 where c1.commentable=?1")
	Double fingAvgStars(Academy academy);

}
