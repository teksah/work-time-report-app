package se.miknel.worktimereportapp.repositories;

import org.springframework.data.repository.CrudRepository;
import se.miknel.worktimereportapp.model.Project;
import se.miknel.worktimereportapp.model.Report;
import se.miknel.worktimereportapp.model.Worker;

import java.util.List;
import java.util.Set;


public interface ReportRepository extends CrudRepository<Report, Long> {
    Set<Report> findReportsByProject(Project project);
}
