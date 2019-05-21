package se.miknel.worktimereportapp.repositories;

import org.springframework.data.repository.CrudRepository;
import se.miknel.worktimereportapp.model.Project;
import se.miknel.worktimereportapp.model.Report;

import java.util.Set;


public interface ReportRepository extends CrudRepository<Report, Long> {
    Set<Report> findReportsByProject(Project project);

    Set<Report> findAllByOrderByWorkDateDesc();
}
