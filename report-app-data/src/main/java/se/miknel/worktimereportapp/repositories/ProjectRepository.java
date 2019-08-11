package se.miknel.worktimereportapp.repositories;

import org.springframework.data.repository.CrudRepository;
import se.miknel.worktimereportapp.model.Customer;
import se.miknel.worktimereportapp.model.Project;

import java.util.Set;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    boolean existsByAddress_StreetName(String address);

    boolean existsByProjectName(String name);

    Set<Project> findAllByActiveTrue();

    Set<Project> findAllByActiveFalse();

    Set<Project> findAllByCustomer(Customer customer);
}
