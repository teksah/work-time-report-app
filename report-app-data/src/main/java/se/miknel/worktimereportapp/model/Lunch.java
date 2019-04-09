package se.miknel.worktimereportapp.model;

import java.math.BigDecimal;

public enum Lunch {
    NO_LUNCH(BigDecimal.valueOf(0.00)),
    HALF_TIME(BigDecimal.valueOf(0.50)),
    FULL_TIME(BigDecimal.valueOf(1.00));

    BigDecimal time;

    Lunch(BigDecimal time) {
        this.time = time;
    }

    public BigDecimal getTime() {
        return time;
    }
}
