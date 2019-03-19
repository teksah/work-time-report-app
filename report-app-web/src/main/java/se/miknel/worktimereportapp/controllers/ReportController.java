package se.miknel.worktimereportapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import se.miknel.worktimereportapp.services.ReportService;

@Controller
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @RequestMapping("/reports")
    public String showAllReports(Model model) {
        model.addAttribute("reports", reportService.findAll());

        return "reports/list";
    }
}
