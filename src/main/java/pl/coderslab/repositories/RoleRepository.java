package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
