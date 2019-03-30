package se.miknel.worktimereportapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.miknel.worktimereportapp.model.Customer;
import se.miknel.worktimereportapp.services.CustomerService;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
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
}
