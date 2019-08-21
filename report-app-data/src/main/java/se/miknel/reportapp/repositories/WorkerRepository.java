package se.miknel.reportapp.repositories;

import org.springframework.data.repository.CrudRepository;
import se.miknel.reportapp.model.Worker;

public interface WorkerRepository extends CrudRepository<Worker, Long> {

    Worker findByFirstName(String firstName);

    boolean existsByTelephoneNumber(String telephoneNumber);

    boolean existsByEmail(String email);
}
