package se.miknel.worktimereportapp.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReportWork extends BaseEntity{
    private Worker worker;
    private LocalDate date;
    private Project project;
    private LocalDateTime startWork;
    private LocalDateTime stopWork;
    private BigDecimal totalHours;
    private String description;
}
