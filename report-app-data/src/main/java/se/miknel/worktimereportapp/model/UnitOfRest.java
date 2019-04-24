package se.miknel.worktimereportapp.model;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class UnitOfRest extends BaseEntity {
    private BigDecimal value;

    public UnitOfRest() {
    }

    public UnitOfRest(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
