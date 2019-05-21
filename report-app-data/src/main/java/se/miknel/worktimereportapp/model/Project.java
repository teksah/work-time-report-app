package se.miknel.worktimereportapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Project extends BaseEntity{

    @NotEmpty
    private String projectName;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    private Address address;

    @ManyToOne
    @NotNull
    private Customer customer;

    private boolean active;

    @ManyToMany(mappedBy = "projects")
    private Set<Worker> workers = new HashSet<>();

    @OneToMany(mappedBy = "project")
    private List<Report> reports = new ArrayList<>();

    public Project() {
        this.active = true;
    }

    public Project(String projectName, Address address, Customer customer) {
        this.projectName = projectName;
        this.address = address;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return this.projectName;
    }
}
