package ua.com.lpnu.demo.service.impl;

import ua.com.lpnu.demo.dto.GroupDto;
import ua.com.lpnu.demo.dto.SubjectDto;
import ua.com.lpnu.demo.dto.UserDto;
import ua.com.lpnu.demo.model.Group;
import ua.com.lpnu.demo.model.Subject;
import ua.com.lpnu.demo.model.User;
import ua.com.lpnu.demo.service.MappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MappingServiceImpl implements MappingService {

  public User mapUserDtoToUser(UserDto userDto) {
    log.debug("mapUserDtoToUser: map to User from UserDto: {}", userDto);
    User user = new User();
    BeanUtils.copyProperties(userDto, user);
    return user;
  }

  public UserDto mapUserToUserDto(User user) {
    UserDto userDto = new UserDto();
    BeanUtils.copyProperties(user, userDto);
    userDto.setPassword(null);
    log.debug("mapUserToUserDto: map from User to UserDto: {}", userDto);
    return userDto;
  }

  @Override
  public SubjectDto mapSubjectToSubjectDto(Subject subject) {
    SubjectDto subjectDto = new SubjectDto();
    BeanUtils.copyProperties(subject, subjectDto);
    log.debug("mapUserToUserDto: map from Subject to SubjectDto: {}", subjectDto);
    return subjectDto;
  }

  @Override
  public Subject mapSubjectDtoToSubject(SubjectDto subjectDto) {
    log.debug("mapUserDtoToUser: map to User from UserDto: {}", subjectDto);
    Subject subject = new Subject();
    BeanUtils.copyProperties(subjectDto, subject);
    return subject;
  }

  @Override
  public GroupDto mapGroupToGroupDto(Group group) {
    GroupDto groupDto = new GroupDto();
    BeanUtils.copyProperties(group, groupDto);
    log.debug("mapUserToUserDto: map from Group to GroupDto: {}", groupDto);
    return groupDto;
  }

  @Override
  public Group mapGroupDtoToGroup(GroupDto groupDto) {
    log.debug("mapUserDtoToUser: map to Group from GroupDto: {}", groupDto);
    Group group = new Group();
    BeanUtils.copyProperties(groupDto, group);
    return group;
  }

}
