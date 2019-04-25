package se.miknel.worktimereportapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Report extends BaseEntity{

    @ManyToOne
    private Worker worker;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate workDate;

    @ManyToOne
    private Project project;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime startWork;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime finishWork;

    @OneToOne
    private UnitOfRest unitOfRest;

    private BigDecimal totalHours;

    @Lob
    private String description;

    public Report() {
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

    public BigDecimal calculateTotalHours() {
        return this.totalHours = BigDecimal.valueOf(Duration.between(startWork, finishWork).toHours()).subtract(this.unitOfRest.getValue());
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public LocalDate getWorkDate() {
        return workDate;
    }

    public void setWorkDate(LocalDate workDate) {
        this.workDate = workDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public LocalTime getStartWork() {
        return startWork;
    }

    public void setStartWork(LocalTime startWork) {
        this.startWork = startWork;
    }

    public LocalTime getFinishWork() {
        return finishWork;
    }

    public void setFinishWork(LocalTime finishWork) {
        this.finishWork = finishWork;
    }

    public BigDecimal getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(BigDecimal totalHours) {
        this.totalHours = totalHours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UnitOfRest getUnitOfRest() {
        return unitOfRest;
    }

    public void setUnitOfRest(UnitOfRest unitOfRest) {
        this.unitOfRest = unitOfRest;
    }
}
