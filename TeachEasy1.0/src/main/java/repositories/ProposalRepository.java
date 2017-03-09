
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Proposal;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Integer> {

}
