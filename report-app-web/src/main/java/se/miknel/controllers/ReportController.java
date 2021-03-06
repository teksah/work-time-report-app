package se.miknel.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.miknel.exceptions.NotFoundException;
import se.miknel.model.Project;
import se.miknel.model.Report;
import se.miknel.services.ProjectService;
import se.miknel.services.ReportService;
import se.miknel.services.UnitOfRestService;
import se.miknel.services.WorkerService;

import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/reports")
public class ReportController {
    private final ReportService reportService;
    private final ProjectService projectService;
    private final UnitOfRestService unitOfRestService;

    public ReportController(ReportService reportService, ProjectService projectService, UnitOfRestService unitOfRestService, WorkerService workerService) {
        this.reportService = reportService;
        this.projectService = projectService;
        this.unitOfRestService = unitOfRestService;
    }

    @GetMapping("/new")
    public String showAddForm(Report report, Model model) {
        model.addAttribute("units", unitOfRestService.findAll());
        model.addAttribute("projects", projectService.findAll());
        return "reports/add-update-report";
    }

    @PostMapping("/new")
    public String addReport(@Valid Report report, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("units", unitOfRestService.findAll());
            model.addAttribute("projects", projectService.findAll());
            return "reports/add-update-report";
        }

        redirectAttributes.addFlashAttribute("success", "Added");
        reportService.save(report);

        return "redirect:/reports/" + report.getId() + "/show";
    }

    @RequestMapping("/all")
    public String showAllReports(Model model) {
        model.addAttribute("reports", reportService.findAll());
        return "reports/list-reports";
    }

    @RequestMapping("/my")
    public String showMyReports(Model model, Authentication authentication) {
        String currentUser = authentication.getName();

        Set<Report> myReports = reportService.findAll().stream()
                .filter(report -> report.getWorker().getUsername().equals(currentUser))
                .collect(Collectors.toSet());

        model.addAttribute("reports", myReports);
        return "reports/list-reports";
    }

    @RequestMapping("/{reportId}/show")
    public String showReport(@PathVariable Long reportId, Model model) {
        Report report = reportService.findById(reportId);
        model.addAttribute("report", report);

        Project project = reportService.findById(reportId).getProject();
        Set<Report> reportsByProject = reportService.findReportsByProject(project);
        reportsByProject.remove(report);

        model.addAttribute("reports", reportsByProject);

        return "reports/show-report";
    }

    @GetMapping("/{reportId}/edit")
    public String editReport(@PathVariable("reportId") Long reportId, Model model) {
        model.addAttribute("units", unitOfRestService.findAll());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("report", reportService.findById(reportId));

        return "reports/add-update-report";
    }

    @PostMapping("/{reportId}/edit")
    public String updateReport(@PathVariable("reportId") Long reportId, @Valid Report report, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        report.setId(reportId);

        if (result.hasErrors()) {
            model.addAttribute("units", unitOfRestService.findAll());
            model.addAttribute("projects", projectService.findAll());
            return "reports/add-update-report";
        }

        redirectAttributes.addFlashAttribute("success", "Updated");
        reportService.save(report);

        return "redirect:/reports/" + report.getId() + "/show";
    }

    @GetMapping("/{reportId}/remove")
    public String removeReport(@PathVariable("reportId") Long reportId, RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("success", "Deleted");
        reportService.deleteById(reportId);

        return "redirect:/reports/";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("404error");

        return modelAndView;
    }

}
