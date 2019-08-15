package se.miknel.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.miknel.model.Project;
import se.miknel.model.Report;
import se.miknel.model.Worker;
import se.miknel.repositories.ReportRepository;
import se.miknel.repositories.WorkerRepository;

import java.util.Optional;
import java.util.Set;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;
    private final WorkerRepository workerRepository;

    public ReportServiceImpl(ReportRepository reportRepository, WorkerRepository workerRepository) {
        this.reportRepository = reportRepository;
        this.workerRepository = workerRepository;
    }

    @Override
    public Set<Report> findAll() {
        return reportRepository.findAllByOrderByWorkDateDesc();
    }

    @Override
    public Report findById(Long aLong) {
        return reportRepository.findById(aLong).orElse(null);
    }

    @Transactional
    @Override
    public Report save(Report object) {

        Optional<Worker> workerOptional = workerRepository.findById(object.getWorker().getId());

        if (workerOptional.isPresent()) {
            Worker worker = workerOptional.get();
            worker.addProject(object.getProject());
        }

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
