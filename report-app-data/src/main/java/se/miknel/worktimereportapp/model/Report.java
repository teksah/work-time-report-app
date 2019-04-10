package se.miknel.worktimereportapp.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Report extends BaseEntity{

    @ManyToOne
    private Worker worker;

    private LocalDate workDate;

    @ManyToOne
    private Project project;

    private LocalTime startWork;

    private LocalTime finishWork;

    @Enumerated(value = EnumType.STRING)
    private Lunch lunch;

    private BigDecimal totalHours;

    @Lob
    private String description;

    public Report() {
    }

    public Report(Worker worker, LocalDate workDate, Project project, LocalTime startWork, LocalTime finishWork, Lunch lunch, String description) {
        this.worker = worker;
        this.workDate = workDate;
        this.project = project;
        this.startWork = startWork;
        this.finishWork = finishWork;
        this.lunch = lunch;
        this.description = description;
    }

    public BigDecimal calculateTotalHours() {
            return this.totalHours = BigDecimal.valueOf(Duration.between(startWork, finishWork).toHours()).subtract(this.lunch.getTime());
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

    public Lunch getLunch() {
        return lunch;
    }

    public void setLunch(Lunch lunch) {
        this.lunch = lunch;
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
}
