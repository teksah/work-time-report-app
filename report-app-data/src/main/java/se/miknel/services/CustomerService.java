package se.miknel.services;

import se.miknel.model.Customer;

public interface CustomerService extends CrudService<Customer, Long> {
    boolean existsByEmail(String email);

    boolean existsByTelephoneNumber(String number);
}
