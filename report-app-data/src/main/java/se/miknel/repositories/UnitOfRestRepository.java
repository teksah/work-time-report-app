package se.miknel.repositories;

import org.springframework.data.repository.CrudRepository;
import se.miknel.model.UnitOfRest;

import java.math.BigDecimal;

public interface UnitOfRestRepository extends CrudRepository<UnitOfRest, Long> {
    UnitOfRest findByValue(BigDecimal value);
}
