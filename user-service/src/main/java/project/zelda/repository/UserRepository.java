package project.zelda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.zelda.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

}
