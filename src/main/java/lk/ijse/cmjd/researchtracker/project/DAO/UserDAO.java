package lk.ijse.cmjd.researchtracker.project.DAO;

import lk.ijse.cmjd.researchtracker.project.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserDAO extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByUsername(String username);
    boolean existsByUsername(String username);

}
