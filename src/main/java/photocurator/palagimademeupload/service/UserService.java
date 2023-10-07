package photocurator.palagimademeupload.service;

import photocurator.palagimademeupload.model.UserDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    List<UserDTO> listUsers();

    Optional<UserDTO> getUserById(UUID id);

    UserDTO saveNewUser(UserDTO user);

    Optional<UserDTO> updateUserById(UUID UserId, UserDTO uaer);

    Boolean deleteById(UUID userId);
}
