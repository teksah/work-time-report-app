package se.miknel.worktimereportapp.model;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;


@MappedSuperclass
public class Person extends BaseEntity{

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return this.firstName + " "+ this.lastName;
    }
}
