package se.miknel.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.miknel.model.Project;
import se.miknel.model.Report;
import se.miknel.model.Worker;
import se.miknel.repositories.ReportRepository;
import se.miknel.repositories.WorkerRepository;

import java.util.List;
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
    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    @Override
    public Report findById(Long aLong) {
        return reportRepository.findById(aLong).orElse(null);
    }

    @Transactional
    @Override
    public Report save(Report object) {
        Optional<Worker> workerOptional = workerRepository.findById(1L);

        if (workerOptional.isPresent()) {
            Worker worker = workerOptional.get();
            object.setWorker(worker);
            object.calculateTotalHours();
            worker.addProject(object.getProject());

            workerRepository.save(worker);
        }
        return reportRepository.save(object);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) {
        Report object = findById(aLong);
        Optional<Worker> workerOptional = workerRepository.findById(object.getWorker().getId());

        if (workerOptional.isPresent()) {
            Worker worker = workerOptional.get();
            worker.removeProject(object.getProject());
        }
        reportRepository.deleteById(aLong);
    }

    @Override
    public Set<Report> findReportsByProject(Project project) {
        return reportRepository.findReportsByProject(project);
    }

}
