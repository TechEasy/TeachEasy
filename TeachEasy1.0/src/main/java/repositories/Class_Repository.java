
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Class_;

@Repository
public interface Class_Repository extends JpaRepository<Class_, Integer> {

}
