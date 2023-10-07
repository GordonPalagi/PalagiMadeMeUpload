package photocurator.palagimademeupload.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import photocurator.palagimademeupload.model.UserDTO;

import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final Map<UUID, UserDTO> userMap;
    public UserServiceImpl() {

        this.userMap = new HashMap<>();

        UserDTO user1 = UserDTO.builder()
                .name("Gordon")
                .bio("I am a programmer.")
                .version(1)
                .id(UUID.randomUUID())
                .build();

        UserDTO user2 = UserDTO.builder()
                .name("Piper")
                .bio("I am a photographer.")
                .version(1)
                .id(UUID.randomUUID())
                .build();

        UserDTO user3 = UserDTO.builder()
                .name("Kris")
                .bio("I'm an architect professor.")
                .version(1)
                .id(UUID.randomUUID())
                .build();

        UserDTO user4 = UserDTO.builder()
                .name("Gwen")
                .bio("I work in radio.")
                .version(1)
                .id(UUID.randomUUID())
                .build();

        userMap.put(user1.getId(), user1);
        userMap.put(user2.getId(), user2);
        userMap.put(user3.getId(), user3);
        userMap.put(user4.getId(), user4);
    }


    @Override
    public List<UserDTO> listUsers() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public Optional<UserDTO> getUserById(UUID id) {
        return Optional.ofNullable(userMap.get(id));
    }

    @Override
    public UserDTO saveNewUser(UserDTO user) {

        UserDTO savedUser = UserDTO.builder()
                .name(user.getName())
                .version(1)
                .id(UUID.randomUUID())
                .build();

        userMap.put(savedUser.getId(), savedUser);

        return savedUser;

    }

    @Override
    public Optional<UserDTO> updateUserById(UUID userId, UserDTO user) {
        user.setId(userId);
        user.setVersion(user.getVersion());
        user.setName(user.getName());
        userMap.put(userId, user);
        return Optional.of(user);
    }

    @Override
    public Boolean deleteById(UUID userId) {
        userMap.remove(userId);
        return true;
    }
}
