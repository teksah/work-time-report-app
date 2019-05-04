package se.miknel.worktimereportapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Customer extends Person {

    @NotEmpty
    @Pattern(regexp = "^$|[0-9]{10}$")
    private String telephoneNumber;

    @NotEmpty
    @Email
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Project> projects = new ArrayList<>();

    public Customer(String firstName, String lastName, String telephoneNumber, String email) {
        super(firstName, lastName);
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
