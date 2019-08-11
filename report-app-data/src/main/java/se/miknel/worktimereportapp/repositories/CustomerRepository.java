package se.miknel.worktimereportapp.repositories;

import org.springframework.data.repository.CrudRepository;
import se.miknel.worktimereportapp.model.Customer;

import java.util.Set;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
    boolean existsByEmail(String email);

    boolean existsByTelephoneNumber(String number);

    Set<Customer> findAllByActiveFalse();

    Set<Customer> findAllByActiveTrue();

}
