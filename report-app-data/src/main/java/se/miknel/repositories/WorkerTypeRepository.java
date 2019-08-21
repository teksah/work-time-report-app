package se.miknel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.miknel.model.WorkerType;

public interface WorkerTypeRepository extends JpaRepository<WorkerType, Long> {
}
