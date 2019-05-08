package se.miknel.worktimereportapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.miknel.worktimereportapp.model.Project;
import se.miknel.worktimereportapp.model.Report;
import se.miknel.worktimereportapp.model.Worker;
import se.miknel.worktimereportapp.services.ProjectService;
import se.miknel.worktimereportapp.services.ReportService;
import se.miknel.worktimereportapp.services.UnitOfRestService;
import se.miknel.worktimereportapp.services.WorkerService;

import javax.validation.Valid;
import java.util.Set;

@Slf4j
@Controller
public class ReportController {
    private final ReportService reportService;
    private final ProjectService projectService;
    private final UnitOfRestService unitOfRestService;
    private final WorkerService workerService;

    public ReportController(ReportService reportService, ProjectService projectService, UnitOfRestService unitOfRestService, WorkerService workerService) {
        this.reportService = reportService;
        this.projectService = projectService;
        this.unitOfRestService = unitOfRestService;
        this.workerService = workerService;
    }

    @RequestMapping("/reports")
    public String showAllReports(Model model) {
        model.addAttribute("reports", reportService.findAll());
        return "reports/list-reports";
    }

    @RequestMapping("/reports/{reportId}/show")
    public String showReport(@PathVariable Long reportId, Model model) {
        Report report = reportService.findById(reportId);

        model.addAttribute("report", report);

        Project project = reportService.findById(reportId).getProject();

        Set<Report> reportsByProject = reportService.findReportsByProject(project);
        reportsByProject.remove(report);

        model.addAttribute("reports", reportsByProject);

        return "reports/show-report";
    }

    @GetMapping("/reports/new")
    public String showAddForm(Report report, Model model) {
        model.addAttribute("units", unitOfRestService.findAll());
        model.addAttribute("projects", projectService.findAll());
        return "reports/add-update-report";
    }

    @PostMapping("/reports/new")
    public String addReport(@Valid Report report, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("units", unitOfRestService.findAll());
            model.addAttribute("projects", projectService.findAll());
            return "reports/add-update-report";
        }

        Worker worker = workerService.findByFirstName("Sebastian");
        report.setWorker(worker);
        report.calculateTotalHours();

        log.info(report.getWorker().toString());

        reportService.save(report);

        return "redirect:/reports/" + report.getId() + "/show";
    }

    @GetMapping("/reports/{reportId}/edit")
    public String editReport(@PathVariable("reportId") Long reportId, Model model) {
        model.addAttribute("units", unitOfRestService.findAll());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("report", reportService.findById(reportId));

        return "reports/add-update-report";
    }

    @PostMapping("/reports/{reportId}/edit")
    public String updateReport(@PathVariable("reportId") Long reportId, @Valid Report report, BindingResult result, Model model) {

        report.setId(reportId);
        if (result.hasErrors()) {
            model.addAttribute("units", unitOfRestService.findAll());
            model.addAttribute("projects", projectService.findAll());
            return "reports/add-update-report";
        }

        report.setWorker(reportService.findById(reportId).getWorker());
        report.calculateTotalHours();
        reportService.save(report);
        return "redirect:/reports/" + report.getId() + "/show";
    }
}
