package se.miknel.reportapp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
public class Report extends BaseEntity{
    @ManyToOne
    private Worker worker;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "{field.notNull}")
    private LocalDate workDate;

    @ManyToOne
    @NotNull(message = "{field.option.notNull}")
    private Project project;

    @DateTimeFormat(pattern = "HH:mm")
    @NotNull(message = "{field.notNull}")
    private LocalTime startWork;

    @DateTimeFormat(pattern = "HH:mm")
    @NotNull(message = "{field.notNull}")
    private LocalTime finishWork;

    @OneToOne
    @NotNull(message = "{field.option.notNull}")
    private UnitOfRest unitOfRest;

    private BigDecimal totalHours;

    @NotBlank(message = "{field.notBlank}")
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
