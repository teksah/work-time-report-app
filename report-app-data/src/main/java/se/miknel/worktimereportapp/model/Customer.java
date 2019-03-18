package se.miknel.worktimereportapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Customer extends Person {

    private String telephoneNumber;
    private String companyName;

    @OneToMany(mappedBy = "customer")
    private List<Project> projects;

    public Customer(String firstName, String lastName, String telephoneNumber, String companyName) {
        super(firstName, lastName);
        this.telephoneNumber = telephoneNumber;
        this.companyName = companyName;
        this.projects = new ArrayList<>();
    }
}
