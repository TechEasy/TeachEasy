
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Query("select t from Student t where t.userAccount.id=?1")
	Student findByUserAccountId(int id);
}
