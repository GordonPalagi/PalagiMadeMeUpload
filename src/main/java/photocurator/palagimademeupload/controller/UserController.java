package photocurator.palagimademeupload.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import photocurator.palagimademeupload.model.UserDTO;
import photocurator.palagimademeupload.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/api/v1/users")
    public List<UserDTO> getUser() {
        return userService.listUsers();
    }

    @GetMapping(value = "/api/v1/users/{id}")
    public UserDTO getUserById(@PathVariable("id") UUID id) {
        return userService.getUserById(id).orElseThrow();
    }
}
