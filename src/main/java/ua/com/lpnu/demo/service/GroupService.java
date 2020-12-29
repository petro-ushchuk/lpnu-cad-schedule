package ua.com.lpnu.demo.service;

import ua.com.lpnu.demo.dto.GroupDto;
import ua.com.lpnu.demo.model.Group;

public interface GroupService {

    GroupDto getGroup(Long id);

    GroupDto createGroup(GroupDto groupDto);

    GroupDto updateGroup(GroupDto groupDto);

    void deleteGroup(Long id);
}
