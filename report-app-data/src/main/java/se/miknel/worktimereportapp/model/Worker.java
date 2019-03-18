package se.miknel.worktimereportapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Worker extends Person {

    @OneToMany(mappedBy = "worker")
    private List<Report> reports = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "worker_project",
            joinColumns = { @JoinColumn(name = "worker_id")},
            inverseJoinColumns = { @JoinColumn(name = "project_id")})
    private Set<Project> projects = new HashSet<>();




}
