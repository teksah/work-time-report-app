package se.miknel.repositories;

import org.springframework.data.repository.CrudRepository;
import se.miknel.model.WorkerType;

public interface WorkerTypeRepository extends CrudRepository<WorkerType, Long> {
}
