package se.miknel.repositories;

import org.springframework.data.repository.CrudRepository;
import se.miknel.model.Customer;
import se.miknel.model.Project;

import java.util.Set;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    boolean existsByAddress_StreetName(String address);

    boolean existsByProjectName(String name);

    Set<Project> findAllByActiveTrue();

    Set<Project> findAllByActiveFalse();

    Set<Project> findAllByCustomer(Customer customer);
}
