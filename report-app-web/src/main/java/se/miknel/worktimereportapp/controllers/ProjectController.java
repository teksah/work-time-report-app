package se.miknel.worktimereportapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import se.miknel.worktimereportapp.model.Project;
import se.miknel.worktimereportapp.services.CustomerService;
import se.miknel.worktimereportapp.services.ProjectService;

@Controller
public class ProjectController {

    private final CustomerService customerService;
    private final ProjectService projectService;

    public ProjectController(CustomerService customerService, ProjectService projectService) {
        this.customerService = customerService;
        this.projectService = projectService;
    }

    @RequestMapping("/projects")
    public String showAllReports(Model model) {
        model.addAttribute("projects", projectService.findAll());

        return "projects/list-projects";
    }

    @GetMapping("/projects/{projectId}/show")
    public String showProject(@PathVariable("projectId") Long projectId, Model model) {
        model.addAttribute("project", projectService.findById(projectId));

        return "projects/show-project";
    }

    @GetMapping("/projects/new")
    public String initCreationForm(Model model) {
        model.addAttribute("project", new Project());
        model.addAttribute("customers", customerService.findAll());
        return "projects/add-project";
    }
}
