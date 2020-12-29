package ua.com.lpnu.demo.service;


import ua.com.lpnu.demo.dto.UserDto;

import java.util.List;

public interface AdminService {

  List<UserDto> getAllUsers();

}
