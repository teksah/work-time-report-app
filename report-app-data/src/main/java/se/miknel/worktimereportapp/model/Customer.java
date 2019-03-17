package se.miknel.worktimereportapp.model;

import lombok.Builder;


public class Customer extends Person {

    @Builder
    public Customer(String firstName, String lastName) {
        super(firstName, lastName);
    }
}
