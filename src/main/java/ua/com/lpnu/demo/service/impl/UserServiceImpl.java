package ua.com.lpnu.demo.service.impl;

import ua.com.lpnu.demo.dto.UserDto;
import ua.com.lpnu.demo.model.User;
import ua.com.lpnu.demo.repository.UserRepository;
import ua.com.lpnu.demo.service.MappingService;
import ua.com.lpnu.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final MappingService mappingService;

  @Override
  public UserDto createUser(UserDto userDto) {
    User user = mappingService.mapUserDtoToUser(userDto);
    log.info("About to create user {}", user);
    user = userRepository.save(user);
    log.info("Used with id {} successfully created", user.getId());
    return mappingService.mapUserToUserDto(user);
  }

  @Override
  public UserDto updateUser(UserDto userDto) {
    User user = mappingService.mapUserDtoToUser(userDto);
    log.info("About to update user {}", user);
    user = userRepository.save(user);
    log.info("Used with id {} successfully updated", user.getId());
    return mappingService.mapUserToUserDto(user);
  }

  @Override
  public void deleteUser(User user) {
    log.info("deleteUser: about to delete user with email {}", user.getEmail());
    SecurityContextHolder.clearContext();
    userRepository.delete(user);
  }

  @Override
  public boolean isUserExistsWithEmail(String email) {
    Optional<User> user = userRepository.findByEmail(email);
    return user.isPresent();
  }

}

