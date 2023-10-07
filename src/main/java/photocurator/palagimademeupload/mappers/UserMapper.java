package photocurator.palagimademeupload.mappers;

import org.mapstruct.Mapper;
import photocurator.palagimademeupload.entity.User;
import photocurator.palagimademeupload.model.UserDTO;

@Mapper
public interface UserMapper {

    UserDTO userToUserDto(User user);

    User userDtoToUser(UserDTO dto);

}
