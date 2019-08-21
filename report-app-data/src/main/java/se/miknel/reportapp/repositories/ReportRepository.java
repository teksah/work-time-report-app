package se.miknel.reportapp.repositories;

import org.springframework.data.repository.CrudRepository;
import se.miknel.reportapp.model.Project;
import se.miknel.reportapp.model.Report;

import java.util.Set;


public interface ReportRepository extends CrudRepository<Report, Long> {
    Set<Report> findReportsByProject(Project project);

    Set<Report> findAllByOrderByWorkDateDesc();
}
