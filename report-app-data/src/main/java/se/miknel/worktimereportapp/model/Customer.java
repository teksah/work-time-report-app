package se.miknel.worktimereportapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Customer extends Person {

    @NotEmpty
    private String telephoneNumber;
    private String companyName;

    private boolean company;
    @NotEmpty
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Project> projects = new ArrayList<>();

    public Customer(String firstName, String lastName, String telephoneNumber, String email) {
        super(firstName, lastName);
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    public Customer(String firstName, String lastName, String telephoneNumber, String companyName, boolean company, String email) {
        super(firstName, lastName);
        this.telephoneNumber = telephoneNumber;
        this.companyName = companyName;
        this.company = company;
        this.email = email;
    }

}
