package se.miknel.reportapp.services;

import se.miknel.reportapp.model.UnitOfRest;

import java.math.BigDecimal;

public interface UnitOfRestService extends CrudService<UnitOfRest, Long> {
    UnitOfRest findByValue(BigDecimal value);
}
