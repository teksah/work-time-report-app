package se.miknel.reportapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity{

    @NotBlank(message = "{field.notBlank}")
    private String firstName;

    @NotBlank(message = "{field.notBlank}")
    private String lastName;

    @Pattern(regexp = "^$|[0-9]{10}$", message = "{person.telephoneNumber.pattern}")
    @NotBlank(message = "{field.notBlank}")
    private String telephoneNumber;

    @NotBlank(message = "{field.notBlank}")
    @Email(message = "{person.email}")
    private String email;

    @NotNull(message = "{field.option.notNull}")
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
