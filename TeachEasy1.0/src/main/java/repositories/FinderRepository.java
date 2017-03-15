
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import security.UserAccount;

import domain.Finder;

@Repository
public interface FinderRepository extends JpaRepository<Finder, Integer> {
	@Query("select t.finder from Student t where t.userAccount = ?1")
	 Finder findByUserAccount(UserAccount userAccount);
}
