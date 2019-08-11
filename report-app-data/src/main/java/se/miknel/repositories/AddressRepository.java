package se.miknel.repositories;

import org.springframework.data.repository.CrudRepository;
import se.miknel.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
