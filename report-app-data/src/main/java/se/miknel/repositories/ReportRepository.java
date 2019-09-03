package se.miknel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.miknel.model.Project;
import se.miknel.model.Report;
import se.miknel.model.Worker;

import java.util.Set;


public interface ReportRepository extends JpaRepository<Report, Long> {
    Set<Report> findReportsByProject(Project project);

    Set<Report> findAllByWorker(Worker worker);

    Set<Report> findAllByOrderByWorkDateDesc();
}
