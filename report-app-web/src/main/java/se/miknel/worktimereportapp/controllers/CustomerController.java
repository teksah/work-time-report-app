package se.miknel.worktimereportapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import se.miknel.worktimereportapp.model.Customer;
import se.miknel.worktimereportapp.services.CustomerService;
import se.miknel.worktimereportapp.services.ProjectService;

import javax.validation.Valid;

@Controller
public class CustomerController {

    private final CustomerService customerService;
    private final ProjectService projectService;

    public CustomerController(CustomerService customerService, ProjectService projectService) {
        this.customerService = customerService;
        this.projectService = projectService;
    }

    @GetMapping("/customers")
    public String showAllCustomers(Model model) {
        model.addAttribute("customers", customerService.findAll());

        return "customers/list-customers";
    }

    @GetMapping("/customers/{customerId}/show")
    public String showCustomer(@PathVariable("customerId") Long customerId, Model model) {
        model.addAttribute("customer", customerService.findById(customerId));

        return "customers/show-customer";
    }

    @GetMapping("/customers/new")
    public String initCreationForm(Customer customer) {
        return "customers/add-customer";
    }

    @PostMapping("/customers/add")
    public String addCustomer(@Valid Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return "customers/add-customer";
        }

        customerService.save(customer);

        return "redirect:/customers/"+customer.getId()+"/show";
    }
}
