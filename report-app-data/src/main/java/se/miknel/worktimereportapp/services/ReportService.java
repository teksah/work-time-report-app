package se.miknel.worktimereportapp.services;

import se.miknel.worktimereportapp.model.Project;
import se.miknel.worktimereportapp.model.Report;
import se.miknel.worktimereportapp.model.Worker;

import java.util.Set;


public interface ReportService extends CrudService<Report, Long> {
    Set<Report> findReportsByProject(Project project);
}
