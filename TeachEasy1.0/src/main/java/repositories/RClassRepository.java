
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.RClass;

@Repository
public interface RClassRepository extends JpaRepository<RClass, Integer> {

}
