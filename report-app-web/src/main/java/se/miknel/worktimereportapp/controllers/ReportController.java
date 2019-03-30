package se.miknel.worktimereportapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.miknel.worktimereportapp.model.Report;
import se.miknel.worktimereportapp.services.ProjectService;
import se.miknel.worktimereportapp.services.ReportService;

import javax.validation.Valid;

@Controller
public class ReportController {
    private final ReportService reportService;
    private final ProjectService projectService;

    public ReportController(ReportService reportService, ProjectService projectService) {
        this.reportService = reportService;
        this.projectService = projectService;
    }

    @RequestMapping("/reports")
    public String showAllReports(Model model) {
        model.addAttribute("reports", reportService.findAll());

        return "reports/list-reports";
    }

    @GetMapping("/reports/new")
    public String initCreationForm(Model model) {
        model.addAttribute("report", new Report());
        model.addAttribute("projects", projectService.findAll());
        return "reports/add-report";
    }

    @PostMapping("/reports/add")
    public String processCreationForm(@Valid Report report, BindingResult result) {
        if (result.hasErrors()) {
            return "/reports/add-report";
        } else {
            reportService.save(report);
            return "reports/list-reports";
        }
    }
}
