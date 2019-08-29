package se.miknel.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import se.miknel.model.Customer;
import se.miknel.repositories.CustomerRepository;
import se.miknel.repositories.ProjectRepository;

import java.util.List;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, ProjectRepository projectRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long aLong) {
        return customerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
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
