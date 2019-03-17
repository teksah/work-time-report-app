package se.miknel.worktimereportapp.model;

import lombok.Builder;
import lombok.Data;


@Data
public class Worker extends Person {
    private Speciality speciality;

    @Builder
    public Worker(String firstName, String lastName, Speciality speciality) {
        super(firstName, lastName);
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "fistName=" + super.getFirstName() +", " +
                "lastName=" + super.getLastName()+ ", " +
                "speciality=" + speciality +
                '}';
    }
}
