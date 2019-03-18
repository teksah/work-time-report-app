package se.miknel.worktimereportapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Customer extends Person {

    private String telephoneNumber;
    private String companyName;

    @OneToMany(mappedBy = "customer")
    private List<Project> projects = new ArrayList<>();
}
