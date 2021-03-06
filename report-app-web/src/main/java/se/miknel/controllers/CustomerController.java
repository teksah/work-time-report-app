package se.miknel.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.miknel.exceptions.NotFoundException;
import se.miknel.model.Customer;
import se.miknel.services.CustomerService;
import se.miknel.services.ProjectService;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService, ProjectService projectService) {
        this.customerService = customerService;
    }

    @GetMapping("/new")
    public String showAddForm(Customer customer) {
        return "customers/add-update-customer";
    }

    @PostMapping("/new")
    public String addCustomer(@Valid Customer customer, BindingResult result, RedirectAttributes redirectAttributes) {

        if (existByEmail(customer)) {
            result.rejectValue("email", "error.email", "");
        }

        if (existByPhoneNumber(customer)) {
            result.rejectValue("telephoneNumber", "error.telephone_number", "");
        }

        if (result.hasErrors()) {
            return "customers/add-update-customer";
        }

        redirectAttributes.addFlashAttribute("success", "Added");
        customerService.save(customer);

        return "redirect:/customers/"+customer.getId()+"/show";
    }

    @GetMapping("/")
    public String showAllCustomers(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customers/list-customers";
    }

    @GetMapping("/{customerId}/show")
    public String showCustomer(@PathVariable("customerId") Long customerId, Model model) {
        model.addAttribute("customer", customerService.findById(customerId));

        return "customers/show-customer";
    }

    @GetMapping("/{customerId}/edit")
    public String showUpdateForm(@PathVariable("customerId") Long customerId, Model model) {
        model.addAttribute("customer", customerService.findById(customerId));
        return "customers/add-update-customer";
    }

    @PostMapping("/{customerId}/edit")
    public String updateCustomer(@PathVariable("customerId") Long customerId, @Valid Customer customer, BindingResult result, Model model, RedirectAttributes redirectAttributes) {

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

        redirectAttributes.addFlashAttribute("success", "Updated");

        customerService.save(customer);


        return "redirect:/customers/" + customer.getId() + "/show";
    }

    private boolean existByPhoneNumber(@Valid Customer customer) {

        return customerService.existsByTelephoneNumber(customer.getTelephoneNumber());
    }

    private boolean existByEmail(@Valid Customer customer) {
        return customerService.existsByEmail(customer.getEmail());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("404error");

        return modelAndView;
    }


}
