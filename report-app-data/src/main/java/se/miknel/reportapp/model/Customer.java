package se.miknel.reportapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Customer extends Person {

    @OneToMany(mappedBy = "customer")
    private List<Project> projects = new ArrayList<>();

    public Customer() {
        setActive(true);
    }

    public Customer(String firstName, String lastName, String telephoneNumber, String email, Boolean active) {
        super(firstName, lastName, telephoneNumber, email, active);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
