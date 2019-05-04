package se.miknel.worktimereportapp.services;

import org.springframework.stereotype.Service;
import se.miknel.worktimereportapp.model.Customer;
import se.miknel.worktimereportapp.repositories.CustomerRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Set<Customer> findAll() {

        Set<Customer> customers = new HashSet<>();

        customerRepository.findAll().iterator().forEachRemaining(customers::add);

        return customers;
    }

    @Override
    public Customer findById(Long aLong) {
        return customerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Customer save(Customer object) {
        return customerRepository.save(object);
    }

    @Override
    public void delete(Customer object) {
        customerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        customerRepository.deleteById(aLong);
    }


    @Override
    public boolean existsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByTelephoneNumber(String number) {
        return customerRepository.existsByTelephoneNumber(number);
    }

}
