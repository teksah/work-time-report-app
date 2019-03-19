package se.miknel.worktimereportapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Report extends BaseEntity{

    @ManyToOne
    private Worker worker;

    private LocalDate workDate;

    @ManyToOne
    private Project project;

    private LocalTime startWork;

    private LocalTime finishWork;

    private boolean lunch;

    private Long totalHours;

    @Lob
    private String description;

    public Report(Worker worker, LocalDate workDate, Project project, LocalTime startWork, LocalTime finishWork, boolean lunch, String description) {
        this.worker = worker;
        this.workDate = workDate;
        this.project = project;
        this.startWork = startWork;
        this.finishWork = finishWork;
        this.lunch = lunch;
        this.description = description;
    }

    public Long calculateTotalHours() {

        if (!lunch) {
            return this.totalHours = Duration.between(startWork, finishWork).toHours();
        }

        return this.totalHours = Duration.between(startWork, finishWork).toHours() - 1;
    }
}
