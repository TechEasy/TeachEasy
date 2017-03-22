
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.RClass;

@Repository
public interface RClassRepository extends JpaRepository<RClass, Integer> {
	@Query("select c from RClass c where c.id=?1")
	RClass findById(int id);
}
