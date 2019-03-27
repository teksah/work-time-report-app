package se.miknel.worktimereportapp.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Address extends BaseEntity{

    private String streetName;
    private String zipCode;
    private String city;

    @OneToOne(mappedBy = "address")
    private Project project;

    public Address() {
    }

    public Address(String streetName, String zipCode, String city) {
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
