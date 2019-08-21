package se.miknel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.miknel.model.Customer;

import java.util.Set;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByEmail(String email);

    boolean existsByTelephoneNumber(String number);

    Set<Customer> findAllByActiveFalse();

    Set<Customer> findAllByActiveTrue();

}
