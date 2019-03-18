package se.miknel.worktimereportapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
public class Report extends BaseEntity{

    private LocalTime workDate;

    @ManyToOne
    private Project project;

    private LocalDateTime startWork;

    private LocalDateTime finishWork;

    @Lob
    private String description;

    @ManyToOne
    private Worker worker;
}
