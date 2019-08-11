package se.miknel.services;

import se.miknel.model.Customer;

import java.util.Set;

public interface CustomerService extends CrudService<Customer, Long> {
    boolean existsByEmail(String email);

    boolean existsByTelephoneNumber(String number);

    Set<Customer> findAll(boolean active);
}
