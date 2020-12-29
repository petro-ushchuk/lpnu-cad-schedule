package ua.com.lpnu.demo.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ua.com.lpnu.demo.dto.GroupDto;
import ua.com.lpnu.demo.exception.GroupNotFoundException;
import ua.com.lpnu.demo.model.Group;
import ua.com.lpnu.demo.repository.GroupRepository;
import ua.com.lpnu.demo.service.GroupService;
import ua.com.lpnu.demo.service.MappingService;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final MappingService mappingService;

    @Override
    public GroupDto getGroup(Long id) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        if(!optionalGroup.isPresent())
            throw new EmptyResultDataAccessException(1);
        Group group = optionalGroup.get();
        log.info("About to get Group {}", group);
        return mappingService.mapGroupToGroupDto(group);
    }

    @Override
    public GroupDto createGroup(GroupDto groupDto) {
        Group group = mappingService.mapGroupDtoToGroup(groupDto);
        log.info("About to create Group {}", group);
        group = groupRepository.save(group);
        log.info("Used with id {} successfully created", group.getId());
        return mappingService.mapGroupToGroupDto(group);
    }

    @Override
    public GroupDto updateGroup(GroupDto groupDto) {
        Group group = mappingService.mapGroupDtoToGroup(groupDto);
        log.info("About to update Group {}", group);
        group = groupRepository.save(group);
        log.info("Used with id {} successfully updated", group.getId());
        return mappingService.mapGroupToGroupDto(group);
    }

    @Override
    public void deleteGroup(Long id) {
        log.info("deleteGroup: about to delete Group with id {}", id);
        SecurityContextHolder.clearContext();
        groupRepository.deleteById(id);
    }

}
