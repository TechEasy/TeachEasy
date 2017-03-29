
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Invoice;
import domain.Student;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
	
}
