package se.miknel.worktimereportapp.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ReportWork extends BaseEntity{
    private LocalTime workDate;
    private Project project;
    private LocalDateTime startWork;
    private LocalDateTime finishWork;
    private BigDecimal totalHours;
    private String description;
    private Worker worker;
}
