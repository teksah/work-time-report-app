package se.miknel.services;

import se.miknel.model.UnitOfRest;

import java.math.BigDecimal;

public interface UnitOfRestService extends CrudService<UnitOfRest, Long> {
    UnitOfRest findByValue(BigDecimal value);
}
