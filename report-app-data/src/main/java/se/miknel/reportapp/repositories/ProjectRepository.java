package se.miknel.reportapp.repositories;

import org.springframework.data.repository.CrudRepository;
import se.miknel.reportapp.model.Customer;
import se.miknel.reportapp.model.Project;

import java.util.Set;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    boolean existsByAddress_StreetName(String address);

    boolean existsByProjectName(String name);

    Set<Project> findAllByActiveTrue();

    Set<Project> findAllByActiveFalse();

    Set<Project> findAllByCustomer(Customer customer);
}
