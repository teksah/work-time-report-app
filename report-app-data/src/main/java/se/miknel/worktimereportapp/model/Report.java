package se.miknel.worktimereportapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    private LocalDateTime startWork;

    private LocalDateTime finishWork;

    @Lob
    private String description;

    public Report(Worker worker, LocalDate workDate, Project project, LocalDateTime startWork, LocalDateTime finishWork, String description) {
        this.worker = worker;
        this.workDate = workDate;
        this.project = project;
        this.startWork = startWork;
        this.finishWork = finishWork;
        this.description = description;
    }
}
