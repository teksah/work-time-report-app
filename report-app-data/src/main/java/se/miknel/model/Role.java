package se.miknel.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Role extends BaseEntity {

    @NotEmpty
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<Worker> workers = new HashSet<>();

    public Role(String name) {
        this.name = name;
    }
}
