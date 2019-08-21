package se.miknel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.miknel.model.UnitOfRest;

import java.math.BigDecimal;

public interface UnitOfRestRepository extends JpaRepository<UnitOfRest, Long> {
    UnitOfRest findByValue(BigDecimal value);
}
