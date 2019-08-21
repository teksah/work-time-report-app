package se.miknel.reportapp.services;

import se.miknel.reportapp.model.Project;
import se.miknel.reportapp.model.Report;

import java.util.Set;


public interface ReportService extends CrudService<Report, Long> {
    Set<Report> findReportsByProject(Project project);
}
