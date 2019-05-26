package se.miknel.worktimereportapp.repositories;

import org.springframework.data.repository.CrudRepository;
import se.miknel.worktimereportapp.model.WorkerType;

public interface WorkerTypeRepository extends CrudRepository<WorkerType, Long> {
}
