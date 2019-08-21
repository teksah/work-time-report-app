package se.miknel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.miknel.model.Project;
import se.miknel.services.CustomerService;
import se.miknel.services.ProjectService;
import se.miknel.services.ReportService;

import javax.validation.Valid;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private final CustomerService customerService;
    private final ProjectService projectService;
    private final ReportService reportService;

    public ProjectController(CustomerService customerService, ProjectService projectService, ReportService reportService) {
        this.customerService = customerService;
        this.projectService = projectService;
        this.reportService = reportService;
    }

    @GetMapping("/new")
    public String showAddForm(Project project, Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "projects/add-update-project";
    }

    @PostMapping("/new")
    public String addProject(@Valid Project project, BindingResult result, Model model, RedirectAttributes redirectAttributes) {

        if (existByAddress(project)) {
            result.rejectValue("address.streetName", "error.address.streetName");
        }

        if (existByProjectName(project)) {
            result.rejectValue("projectName", "error.projectName");
        }

        if (result.hasErrors()) {
            model.addAttribute("customers", customerService.findAll());
            return "projects/add-update-project";
        }

        redirectAttributes.addFlashAttribute("success", "Added");
        projectService.save(project);

        return "redirect:/projects/" + project.getId() + "/show";

    }

    private boolean existByProjectName(@Valid Project project) {
        return projectService.existsByProjectName(project.getProjectName());
    }

    private boolean existByAddress(@Valid Project project) {
        return projectService.existsByAddress_StreetName(project.getAddress().getStreetName());
    }

    @RequestMapping("/")
    public String showAllReports(Model model) {
        model.addAttribute("projects", projectService.findAll());
        return "projects/list-projects";
    }

    @GetMapping("/{projectId}/show")
    public String showProject(@PathVariable("projectId") Long projectId, Model model) {
        model.addAttribute("project", projectService.findById(projectId));
        model.addAttribute("reports", reportService.findAll());

        return "projects/show-project";
    }

    @GetMapping("/{projectId}/edit")
    public String editProject(@PathVariable("projectId") Long projectId, Model model) {
        model.addAttribute("project", projectService.findById(projectId));
        model.addAttribute("customers", customerService.findAll());
        return "projects/add-update-project";
    }

    @PostMapping("/{projectId}/edit")
    public String updateCustomer(@PathVariable("projectId") Long projectId, @Valid Project project, BindingResult result, Model model, RedirectAttributes redirectAttributes) {

        if (!(projectService.findById(projectId).getAddress().getStreetName().equals(project.getAddress().getStreetName())) && (existByAddress(project))) {
            result.rejectValue("address.streetName", "error.address.streetName", "");
        }

        if (!(projectService.findById(projectId).getProjectName().equals(project.getProjectName())) && (existByProjectName(project))) {
            result.rejectValue("projectName", "error.projectName", "");
        }

        project.setId(projectId);

        if (result.hasErrors()) {
            model.addAttribute("customers", customerService.findAll());
            return "projects/add-update-project";
        }

        redirectAttributes.addFlashAttribute("success", "Updated");
        projectService.save(project);

        return "redirect:/projects/" + project.getId() + "/show";
    }


}
