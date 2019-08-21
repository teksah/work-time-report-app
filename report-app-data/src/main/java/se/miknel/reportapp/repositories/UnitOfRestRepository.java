package se.miknel.reportapp.repositories;

import org.springframework.data.repository.CrudRepository;
import se.miknel.reportapp.model.UnitOfRest;

import java.math.BigDecimal;

public interface UnitOfRestRepository extends CrudRepository<UnitOfRest, Long> {
    UnitOfRest findByValue(BigDecimal value);
}
