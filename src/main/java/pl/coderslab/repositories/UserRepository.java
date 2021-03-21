package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
