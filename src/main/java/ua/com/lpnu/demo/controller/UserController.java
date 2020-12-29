package ua.com.lpnu.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ua.com.lpnu.demo.api.UserApi;
import ua.com.lpnu.demo.dto.UserDto;
import ua.com.lpnu.demo.model.User;
import ua.com.lpnu.demo.service.MappingService;
import ua.com.lpnu.demo.service.UserService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController implements UserApi {

    private final UserService userService;
    private final MappingService mappingService;

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("createUser: with email {}", userDto.getEmail());
        UserDto user = userService.createUser(userDto);
        return user;
    }

    @Override
    public UserDto getUser(User user) {
        log.info("getUser: with id {}", user.getId());
        UserDto userDto = mappingService.mapUserToUserDto(user);
        return userDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        log.info("updateUser controller is called");
        UserDto user = userService.updateUser(userDto);
        return user;
    }

    @Override
    public ResponseEntity<Void> deleteUser(User user) {
        log.info("deleteUser: with id {}", user.getId());
        userService.deleteUser(user);
        return ResponseEntity.noContent().build();
    }

}
