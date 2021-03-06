package se.miknel.services;

import se.miknel.model.Project;
import se.miknel.model.Report;
import se.miknel.model.Worker;

import java.util.Set;


public interface ReportService extends CrudService<Report, Long> {
    Set<Report> findReportsByProject(Project project);
    Set<Report> findAllByWorker(Worker worker);
}
