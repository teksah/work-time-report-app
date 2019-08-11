package se.miknel.worktimereportapp.services;

import se.miknel.worktimereportapp.model.Customer;

import java.util.Set;

public interface CustomerService extends CrudService<Customer, Long> {
    boolean existsByEmail(String email);

    boolean existsByTelephoneNumber(String number);

    Set<Customer> findAll(boolean active);
}
