package se.miknel.worktimereportapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Worker extends Person {

    @OneToMany(mappedBy = "worker")
    private List<Report> reports = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "worker_project",
            joinColumns = { @JoinColumn(name = "worker_id")},
            inverseJoinColumns = { @JoinColumn(name = "project_id")})
    private Set<Project> projects = new HashSet<>();

    public Worker() {

    }

    public Worker(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void addProject(Project project) {
        this.projects.add(project);
        project.getWorkers().add(this);
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
