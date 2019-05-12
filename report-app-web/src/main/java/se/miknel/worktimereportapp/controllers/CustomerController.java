package se.miknel.worktimereportapp.controllers;

import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@Controller
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService, ProjectService projectService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers/new")
    public String showAddForm(Customer customer) {
        return "customers/add-update-customer";
    }

    @PostMapping("/customers/new")
    public String addCustomer(@Valid Customer customer, BindingResult result) {

        if (existByEmail(customer)) {
            result.rejectValue("email", "error.email", "");
        }

        if (existByPhoneNumber(customer)) {
            result.rejectValue("telephoneNumber", "error.telephone_number", "");
        }

        if (result.hasErrors()) {
            return "customers/add-update-customer";
        }


        customerService.save(customer);

        return "redirect:/customers/"+customer.getId()+"/show";
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

    @GetMapping("/customers/{customerId}/edit")
    public String showUpdateForm(@PathVariable("customerId") Long customerId, Model model) {
        model.addAttribute("customer", customerService.findById(customerId));
        return "customers/add-update-customer";
    }

    @PostMapping("/customers/{customerId}/edit")
    public String updateCustomer(@PathVariable("customerId") Long customerId, @Valid Customer customer, BindingResult result, Model model) {

        if (!(customerService.findById(customerId).getEmail().equals(customer.getEmail())) && (existByEmail(customer))) {
            result.rejectValue("email", "error.email", "");
        }

        if (!(customerService.findById(customerId).getTelephoneNumber().equals(customer.getTelephoneNumber())) && (existByPhoneNumber(customer))) {
            result.rejectValue("telephoneNumber", "error.telephone_number", "");
        }

        customer.setId(customerId);
        if (result.hasErrors()) {
            return "customers/add-update-customer";
        }

        customerService.save(customer);

        return "redirect:/customers/" + customer.getId() + "/show";
    }

    private boolean existByPhoneNumber(@Valid Customer customer) {
        return customerService.existsByTelephoneNumber(customer.getTelephoneNumber());
    }

    private boolean existByEmail(@Valid Customer customer) {
        return customerService.existsByEmail(customer.getEmail());
    }


}
