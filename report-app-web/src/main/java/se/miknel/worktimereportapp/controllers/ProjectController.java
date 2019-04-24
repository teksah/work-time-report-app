package se.miknel.worktimereportapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/projects/new")
    public String showAddForm(Project project, Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "projects/add-project";
    }

    @PostMapping("/projects/add")
    public String addProject(Project project, BindingResult result) {
        if (result.hasErrors()) {
            return "projects/add-project";
        }

        projectService.save(project);

        return "redirect:/projects/"+project.getId()+"/show";

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

    @GetMapping("/projects/{projectId}/edit")
    public String editProject(@PathVariable("projectId") Long projectId, Model model) {
        model.addAttribute("project", projectService.findById(projectId));
        model.addAttribute("customers", customerService.findAll());

        return "projects/update-project";
    }

    @PostMapping("/projects/{projectId}/update")
    public String updateCustomer(@PathVariable("projectId") Long projectId, Project project, BindingResult result) {
        if (result.hasErrors()) {
            return "projects/update-project";
        }

        project.setId(projectId);
        projectService.save(project);

        return "redirect:/projects/" + project.getId() + "/show";
    }


}
