package se.miknel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.miknel.model.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

    Worker findByFirstName(String firstName);

    boolean existsByTelephoneNumber(String telephoneNumber);

    boolean existsByEmail(String email);
}
