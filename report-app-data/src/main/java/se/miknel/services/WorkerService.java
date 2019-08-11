package se.miknel.services;

import se.miknel.model.Worker;

public interface WorkerService extends CrudService<Worker, Long> {
    Worker findByFirstName(String firstName);

    boolean existsByTelephoneNumber(String telephoneNumber);

    boolean existsByEmail(String email);
}