package se.miknel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.miknel.model.Customer;
import se.miknel.model.Project;

import java.util.Set;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    boolean existsByAddress_StreetName(String address);

    boolean existsByProjectName(String name);

    Set<Project> findAllByActiveTrue();

    Set<Project> findAllByActiveFalse();

    Set<Project> findAllByCustomer(Customer customer);
}
