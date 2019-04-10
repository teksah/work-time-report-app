package se.miknel.worktimereportapp.repositories;

import org.springframework.data.repository.CrudRepository;
import se.miknel.worktimereportapp.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
