package ua.com.lpnu.demo.service;

import ua.com.lpnu.demo.dto.UserDto;
import ua.com.lpnu.demo.model.User;

public interface UserService {

  UserDto createUser(UserDto userDto);

  UserDto updateUser(UserDto userDto);

  void deleteUser(User user);

  boolean isUserExistsWithEmail(String email);

}
