package ua.com.lpnu.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ua.com.lpnu.demo.dto.UserDto;
import ua.com.lpnu.demo.model.enums.Role;

public interface AuthService extends UserDetailsService {

  UserDto signIn(UserDto userDto);

  UserDto signUp(UserDto userDto, Role role);

  void signOut();

}
