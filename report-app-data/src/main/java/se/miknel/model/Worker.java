package se.miknel.model;

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

    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "worker_role",
            joinColumns = @JoinColumn(name = "worker_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();

    public Worker(String firstName, String lastName, String telephoneNumber, String email, WorkerType type, String username, String password) {
        super(firstName, lastName, telephoneNumber, email);
        this.type = type;
        this.username = username;
        this.password = password;
    }

    public void addProject(Project project) {
        this.projects.add(project);
        project.getWorkers().add(this);
    }

    public void removeProject(Project project) {
        this.projects.remove(project);
        project.getWorkers().remove(this);
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
