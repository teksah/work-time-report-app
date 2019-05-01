package se.miknel.worktimereportapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Address extends BaseEntity{

    private String streetName;
    private String zipCode;
    private String city;

    @OneToOne(mappedBy = "address")
    private Project project;

    public Address(String streetName, String zipCode, String city) {
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.city = city;
    }

    @Override
    public String toString() {
        return streetName+", "+zipCode+" "+city;
    }
}
