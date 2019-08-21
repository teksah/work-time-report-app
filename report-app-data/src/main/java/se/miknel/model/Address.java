package se.miknel.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Address extends BaseEntity{

    @NotBlank(message = "{field.notBlank}")
    private String streetName;
    @Pattern(regexp = "^(\\d{5})?$", message = "{address.zipCode.pattern")
    @NotBlank(message = "{field.notBlank}")
    private String zipCode;
    @NotBlank(message = "{field.notBlank}")
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
