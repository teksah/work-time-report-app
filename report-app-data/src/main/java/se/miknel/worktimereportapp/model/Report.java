package se.miknel.worktimereportapp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
public class Report extends BaseEntity{

    @NotNull
    @ManyToOne
    private Worker worker;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate workDate;

    @NotNull
    @ManyToOne
    private Project project;

    @NotNull
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime startWork;

    @NotNull
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime finishWork;

    @NotNull
    @OneToOne
    private UnitOfRest unitOfRest;

    private BigDecimal totalHours;

    @Lob
    private String description;

    public Report() {
        this.startWork = LocalTime.of(7, 0);
        this.finishWork = LocalTime.of(16, 0);
        this.workDate = LocalDate.now();
    }

    public Report(Worker worker, LocalDate workDate, Project project, LocalTime startWork, LocalTime finishWork, UnitOfRest unitOfRest, String description) {
        this.worker = worker;
        this.workDate = workDate;
        this.project = project;
        this.startWork = startWork;
        this.finishWork = finishWork;
        this.unitOfRest = unitOfRest;
        this.description = description;
    }

    public void calculateTotalHours() {
        this.totalHours = BigDecimal.valueOf(Duration.between(startWork, finishWork).toHours()).subtract(this.unitOfRest.getValue());
    }

}
