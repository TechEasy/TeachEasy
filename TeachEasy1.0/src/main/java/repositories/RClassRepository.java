
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Rclass;

@Repository
public interface RClassRepository extends JpaRepository<Rclass, Integer> {
	@Query("select c from RClass c where c.id=?1")
	Rclass findById(int id);
}
