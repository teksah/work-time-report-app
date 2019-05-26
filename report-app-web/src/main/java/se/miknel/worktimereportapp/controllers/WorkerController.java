package se.miknel.worktimereportapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.miknel.worktimereportapp.model.Worker;
import se.miknel.worktimereportapp.services.WorkerService;

import javax.validation.Valid;

@Controller
public class WorkerController {
    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    // CREATE WORKER
    @GetMapping("/workers/new")
    public String showAddForm(Worker worker) {
        return "workers/add-update-worker";
    }

    @PostMapping("/worker/new")
    public String addWorker(@Valid Worker worker, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (workerService.existsByEmail(worker.getEmail())) {
            result.rejectValue("email", "error.email", "");
        }

        if (workerService.existsByTelephoneNumber(worker.getTelephoneNumber())) {
            result.rejectValue("telephoneNumber", "error.telephone_number", "");
        }

        if (result.hasErrors()) {
            return "customers/add-update-customer";
        }

        redirectAttributes.addFlashAttribute("success", "Added");
        workerService.save(worker);

        return "redirect:/workers/" + worker.getId() + "/show";
    }

}
