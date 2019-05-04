package se.miknel.worktimereportapp.services;

import se.miknel.worktimereportapp.model.Customer;

public interface CustomerService extends CrudService<Customer, Long> {
    boolean existsByEmail(String email);

    boolean existsByTelephoneNumber(String number);
}
