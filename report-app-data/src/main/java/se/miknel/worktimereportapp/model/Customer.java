package se.miknel.worktimereportapp.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends Person {

    private String telephoneNumber;
    private String companyName;

    private boolean company;
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Project> projects = new ArrayList<>();;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String telephoneNumber, boolean company, String email) {
        super(firstName, lastName);
        this.telephoneNumber = telephoneNumber;
        this.company = company;
        this.email = email;
    }

    public Customer(String firstName, String lastName, String telephoneNumber, String companyName, boolean company, String email) {
        super(firstName, lastName);
        this.telephoneNumber = telephoneNumber;
        this.companyName = companyName;
        this.company = company;
        this.email = email;
    }

    @Override
    public String toString() {
        if (this.company) {
            return this.companyName;
        } else {
            return super.toString();
        }

    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public boolean isCompany() {
        return company;
    }

    public void setCompany(boolean company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
