package se.miknel.worktimereportapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data
@Entity
public class Address extends BaseEntity{

    private String streetName;
    private String zipCode;
    private String city;

    @OneToOne(mappedBy = "address")
    private Project project;
}
