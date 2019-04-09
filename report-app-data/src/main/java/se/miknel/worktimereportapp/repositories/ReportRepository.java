package se.miknel.worktimereportapp.repositories;

import org.springframework.data.repository.CrudRepository;
import se.miknel.worktimereportapp.model.Report;


public interface ReportRepository extends CrudRepository<Report, Long> {
}
