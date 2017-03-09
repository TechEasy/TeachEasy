
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Matter;

@Repository
public interface MatterRepository extends JpaRepository<Matter, Integer> {

}
