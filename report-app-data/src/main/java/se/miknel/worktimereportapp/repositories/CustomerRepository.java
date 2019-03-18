package se.miknel.worktimereportapp.repositories;

import org.springframework.data.repository.CrudRepository;
import se.miknel.worktimereportapp.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
