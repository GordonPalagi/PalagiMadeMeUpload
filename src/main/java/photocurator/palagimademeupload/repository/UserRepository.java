package photocurator.palagimademeupload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import photocurator.palagimademeupload.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
