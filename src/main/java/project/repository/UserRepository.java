package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
