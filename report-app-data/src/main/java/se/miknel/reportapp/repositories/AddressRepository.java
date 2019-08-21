package se.miknel.reportapp.repositories;

import org.springframework.data.repository.CrudRepository;
import se.miknel.reportapp.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
