package se.miknel.services;

import org.springframework.stereotype.Service;
import se.miknel.model.Project;
import se.miknel.model.Report;
import se.miknel.repositories.ReportRepository;

import java.util.Set;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Set<Report> findAll() {
        return reportRepository.findAllByOrderByWorkDateDesc();
    }

    @Override
    public Report findById(Long aLong) {
        return reportRepository.findById(aLong).orElse(null);
    }

    @Override
    public Report save(Report object) {
        return reportRepository.save(object);
    }

    @Override
    public void delete(Report object) {
        reportRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        reportRepository.deleteById(aLong);
    }

    @Override
    public Set<Report> findReportsByProject(Project project) {
        return reportRepository.findReportsByProject(project);
    }

}
