package project.zelda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.zelda.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
