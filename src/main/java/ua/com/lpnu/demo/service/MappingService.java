package ua.com.lpnu.demo.service;


import ua.com.lpnu.demo.dto.GroupDto;
import ua.com.lpnu.demo.dto.SubjectDto;
import ua.com.lpnu.demo.dto.UserDto;
import ua.com.lpnu.demo.model.Group;
import ua.com.lpnu.demo.model.Subject;
import ua.com.lpnu.demo.model.User;

public interface MappingService {

  User mapUserDtoToUser(UserDto userDto);

  UserDto mapUserToUserDto(User user);

  SubjectDto mapSubjectToSubjectDto(Subject subject);

  Subject mapSubjectDtoToSubject(SubjectDto subjectDto);

  GroupDto mapGroupToGroupDto(Group group);

  Group mapGroupDtoToGroup(GroupDto groupDto);
}
