package se.miknel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.miknel.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
