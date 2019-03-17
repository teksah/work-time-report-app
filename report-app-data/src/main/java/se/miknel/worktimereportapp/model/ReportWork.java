package se.miknel.worktimereportapp.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Builder
public class ReportWork {
    private Worker worker;
    private LocalDate date;
    private Project project;
    private LocalDateTime startWork;
    private LocalDateTime stopWork;
    private BigDecimal totalHours;
    private String description;
}
