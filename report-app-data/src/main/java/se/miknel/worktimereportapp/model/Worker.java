package se.miknel.worktimereportapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Worker extends Person {

    @OneToMany(mappedBy = "worker")
    private List<Report> reports;

    @ManyToMany
    @JoinTable(name = "worker_project",
            joinColumns = { @JoinColumn(name = "worker_id")},
            inverseJoinColumns = { @JoinColumn(name = "project_id")})
    private Set<Project> projects;

    public Worker(String firstName, String lastName) {
        super(firstName, lastName);
        reports = new ArrayList<>();
        projects = new HashSet<>();
    }

    public void addProject(Project project) {
        this.projects.add(project);
        project.getWorkers().add(this);
    }
}
