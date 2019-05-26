package se.miknel.worktimereportapp.repositories;

import org.springframework.data.repository.CrudRepository;
import se.miknel.worktimereportapp.model.Worker;

public interface WorkerRepository extends CrudRepository<Worker, Long> {

    Worker findByFirstName(String firstName);

    boolean existsByTelephoneNumber(String telephoneNumber);

    boolean existsByEmail(String email);
}
