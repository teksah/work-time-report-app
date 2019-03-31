package se.miknel.worktimereportapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import se.miknel.worktimereportapp.model.Customer;
import se.miknel.worktimereportapp.services.CustomerService;
import se.miknel.worktimereportapp.services.ProjectService;

@Controller
public class CustomerController {

    private final CustomerService customerService;
    private final ProjectService projectService;

    public CustomerController(CustomerService customerService, ProjectService projectService) {
        this.customerService = customerService;
        this.projectService = projectService;
    }

    @GetMapping("/customers/new")
    public String initCreationForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customers/add-customer";
    }

    @GetMapping("/customers")
    public String showAllCustomers(Model model) {
        model.addAttribute("customers", customerService.findAll());

        return "customers/list-customers";
    }

    @GetMapping("/customers/{customerId}")
    public String showCustomer(@PathVariable("customerId") Long customerId, Model model) {
        model.addAttribute("customer", customerService.findById(customerId));
        model.addAttribute("pageTitle", customerService.findById(customerId));

        return "/customers/show-customer";
    }
}
