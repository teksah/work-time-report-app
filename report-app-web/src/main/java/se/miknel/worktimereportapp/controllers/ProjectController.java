package se.miknel.worktimereportapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.miknel.worktimereportapp.model.Project;
import se.miknel.worktimereportapp.services.CustomerService;

@Controller
public class ProjectController {

    private final CustomerService customerService;

    public ProjectController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/projects/new")
    public String initCreationForm(Model model) {
        model.addAttribute("project", new Project());
        model.addAttribute("customers", customerService.findAll());
        return "projects/add-project";
    }
}
