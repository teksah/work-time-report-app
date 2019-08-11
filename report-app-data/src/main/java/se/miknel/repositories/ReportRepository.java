package se.miknel.repositories;

import org.springframework.data.repository.CrudRepository;
import se.miknel.model.Project;
import se.miknel.model.Report;

import java.util.Set;


public interface ReportRepository extends CrudRepository<Report, Long> {
    Set<Report> findReportsByProject(Project project);

    Set<Report> findAllByOrderByWorkDateDesc();
}
