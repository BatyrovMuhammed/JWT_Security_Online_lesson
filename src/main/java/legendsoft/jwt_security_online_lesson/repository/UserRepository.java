package legendsoft.jwt_security_online_lesson.repository;

import legendsoft.jwt_security_online_lesson.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
