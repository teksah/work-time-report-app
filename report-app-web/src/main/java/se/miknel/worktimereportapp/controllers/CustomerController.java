package se.miknel.worktimereportapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.miknel.worktimereportapp.model.Customer;

@Controller
public class CustomerController {

    @GetMapping("/customers/new")
    public String initCreationForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customers/add-customer";
    }
}
