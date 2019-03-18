package se.miknel.worktimereportapp.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class Person extends BaseEntity{
    private String firstName;
    private String lastName;
}
