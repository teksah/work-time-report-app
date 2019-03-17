package se.miknel.worktimereportapp.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReportWork {
    private Worker worker;
    private LocalDate date;
    private Project project;
    private LocalDate startWork;
    private LocalDate stopWork;
    private BigDecimal totalHours;
    private String description;
}
