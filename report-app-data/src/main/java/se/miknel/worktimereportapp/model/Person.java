package se.miknel.worktimereportapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity{

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    @Pattern(regexp = "^$|[0-9]{10}$")
    private String telephoneNumber;

    @NotEmpty
    @Email
    private String email;

    @NotNull
    private Boolean active;

    public Person(String firstName, String lastName, String telephoneNumber, String email, Boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.active = active;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
