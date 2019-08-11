package se.miknel.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class UnitOfRest extends BaseEntity {
    private BigDecimal value;

    public UnitOfRest(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
