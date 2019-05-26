package se.miknel.worktimereportapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Worker extends Person {

    @OneToOne
    @NotNull
    private WorkerType type;

    @OneToMany(mappedBy = "worker")
    private List<Report> reports = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "worker_project",
            joinColumns = { @JoinColumn(name = "worker_id")},
            inverseJoinColumns = { @JoinColumn(name = "project_id")})
    private Set<Project> projects = new HashSet<>();

    public Worker(WorkerType type, String firstName, String lastName, String telephoneNumber, String email, Boolean active) {
        super(firstName, lastName, telephoneNumber, email, active);
        this.type = type;
    }

    public void addProject(Project project) {
        this.projects.add(project);
        project.getWorkers().add(this);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
