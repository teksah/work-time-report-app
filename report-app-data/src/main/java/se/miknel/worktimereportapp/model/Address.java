package se.miknel.worktimereportapp.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Address {
    private String streetAddress;
    private String zipCode;
    private String city;

}
