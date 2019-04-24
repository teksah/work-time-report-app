package se.miknel.worktimereportapp.services;

import se.miknel.worktimereportapp.model.UnitOfRest;

import java.math.BigDecimal;

public interface UnitOfRestService extends CrudService<UnitOfRest, Long> {
    UnitOfRest findByValue(BigDecimal value);
}
