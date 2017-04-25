
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

	@Query("select c.requests from Rclass c where c.teacher.id = ?1")
	Collection<Request> findByTeacher(int id);
	
	@Query("select c.requests from Rclass c where c.academy.id = ?1")
	Collection<Request> findByAcademy(int id);
	
	@Query("select r from Request r where r.status='DENIED' and r.paid=true")
	Collection<Request> findRequestCanceledAndPaid();
}
