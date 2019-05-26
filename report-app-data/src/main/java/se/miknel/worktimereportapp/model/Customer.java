package se.miknel.worktimereportapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Customer extends Person {

    @NotEmpty
    @Pattern(regexp = "^$|[0-9]{10}$")
    private String telephoneNumber;

    @NotEmpty
    @Email
    private String email;

    @NotNull
    private Boolean active;

    @OneToMany(mappedBy = "customer")
    private List<Project> projects = new ArrayList<>();

    public Customer() {
        this.active = true;
    }

    public Customer(String firstName, String lastName, String telephoneNumber, String email, Boolean active) {
        super(firstName, lastName);
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.active = active;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
