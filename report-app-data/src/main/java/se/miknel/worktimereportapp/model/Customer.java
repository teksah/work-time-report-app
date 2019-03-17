package se.miknel.worktimereportapp.model;

import lombok.Builder;
import lombok.Data;

@Data
public class Customer extends Person {


    @Builder
    public Customer(String firstName, String lastName, Address address) {
        super(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName="+ super.getFirstName()+", "+
                "lastName="+ super.getLastName()+", "+
                '}';
    }
}
