package se.miknel.services;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.miknel.exceptions.NotFoundException;
import se.miknel.model.Project;
import se.miknel.model.Report;
import se.miknel.model.Worker;
import se.miknel.repositories.ReportRepository;
import se.miknel.repositories.WorkerRepository;

import java.util.List;
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
        return reportRepository.findById(aLong).orElseThrow(NotFoundException::new);
    }

    @Transactional
    @Override
    public Report save(Report object) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String currentUserName=null;
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }

        Worker worker = workerRepository.findByUsername(currentUserName);
        object.setWorker(worker);
        object.calculateTotalHours();
        worker.addProject(object.getProject());
        workerRepository.save(worker);

        return reportRepository.save(object);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) {
        Report object = findById(aLong);
        Worker worker = workerRepository.findById(object.getWorker().getId()).orElseThrow(NotFoundException::new);
        worker.removeProject(object.getProject());

        reportRepository.deleteById(aLong);
    }

    @Override
    public Set<Report> findReportsByProject(Project project) {
        return reportRepository.findReportsByProject(project);
    }

    @Override
    public Set<Report> findAllByWorker(Worker worker) {
        return reportRepository.findAllByWorker(worker);
    }

}
