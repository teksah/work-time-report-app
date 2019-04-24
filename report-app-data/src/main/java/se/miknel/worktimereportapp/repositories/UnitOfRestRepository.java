package se.miknel.worktimereportapp.repositories;

import org.springframework.data.repository.CrudRepository;
import se.miknel.worktimereportapp.model.UnitOfRest;

import java.math.BigDecimal;

public interface UnitOfRestRepository extends CrudRepository<UnitOfRest, Long> {
    UnitOfRest findByValue(BigDecimal value);
}
