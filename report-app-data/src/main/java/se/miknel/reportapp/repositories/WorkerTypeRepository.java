package se.miknel.reportapp.repositories;

import org.springframework.data.repository.CrudRepository;
import se.miknel.reportapp.model.WorkerType;

public interface WorkerTypeRepository extends CrudRepository<WorkerType, Long> {
}
