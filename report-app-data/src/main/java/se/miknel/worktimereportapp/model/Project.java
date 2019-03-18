package se.miknel.worktimereportapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Project extends BaseEntity{

    private String projectName;

    @OneToOne
    private Address address;

    @ManyToOne
    private Customer customer;

    @ManyToMany(mappedBy = "projects")
    private Set<Worker> workers = new HashSet<>();

    @OneToMany(mappedBy = "project")
    private List<Report> reports = new ArrayList<>();
}
