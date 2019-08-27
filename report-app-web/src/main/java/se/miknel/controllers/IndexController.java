package se.miknel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String indexPage() {
        return "redirect:/reports/";
    }

    @GetMapping("/login")
    public String login(){return "security/login";}

}
