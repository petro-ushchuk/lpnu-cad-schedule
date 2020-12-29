package ua.com.lpnu.demo.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.com.lpnu.demo.dto.UserDto;
import ua.com.lpnu.demo.repository.UserRepository;
import ua.com.lpnu.demo.service.AdminService;
import ua.com.lpnu.demo.service.MappingService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

  private final UserRepository userRepository;
  private final MappingService mappingService;

  @Override
  public List<UserDto> getAllUsers() {
    log.info("getAllUsers: method is called");
    List<UserDto> allUsers = userRepository.findAll().stream()
        .map(mappingService::mapUserToUserDto)
        .collect(Collectors.toList());
    log.info("getAllUsers: {} users found", allUsers.size());
    return allUsers;
  }

}
