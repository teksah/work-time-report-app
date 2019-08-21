package se.miknel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.miknel.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
