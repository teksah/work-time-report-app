package se.miknel.worktimereportapp.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import se.miknel.worktimereportapp.model.Customer;
import se.miknel.worktimereportapp.model.Project;
import se.miknel.worktimereportapp.repositories.CustomerRepository;
import se.miknel.worktimereportapp.repositories.ProjectRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final ProjectRepository projectRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, ProjectRepository projectRepository) {
        this.customerRepository = customerRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public Set<Customer> findAll() {

        Set<Customer> customers = new HashSet<>();

        customerRepository.findAll().iterator().forEachRemaining(customers::add);

        return customers;
    }

    @Override
    public Set<Customer> findAll(boolean active) {
        Set<Customer> customers = new HashSet<>();

        if (!active) {
            customerRepository.findAllByActiveFalse().iterator().forEachRemaining(customers::add);
            return customers;
        }

        customerRepository.findAllByActiveTrue().iterator().forEachRemaining(customers::add);
        return customers;
    }

    @Override
    public Customer findById(Long aLong) {
        return customerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {

        if (!customer.getActive()) {
            log.info("CUSTOMER NIE ACTYWNY");

            List<Project> projects = Objects.requireNonNull(customerRepository.findById(customer.getId()).orElse(null)).getProjects();

            for (Project project : projects) {
                project.setActive(false);
            }

            System.out.println("projekty " + projects);

        }

        return customerRepository.save(customer);
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
