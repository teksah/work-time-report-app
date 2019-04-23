package se.miknel.worktimereportapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Project extends BaseEntity{

    private String projectName;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @ManyToOne
    private Customer customer;

    @ManyToMany(mappedBy = "projects")
    private Set<Worker> workers = new HashSet<>();

    @OneToMany(mappedBy = "project")
    private List<Report> reports = new ArrayList<>();

    public Project() {
    }

    public Project(String projectName, Address address, Customer customer) {
        this.projectName = projectName;
        this.address = address;
        this.customer = customer;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
