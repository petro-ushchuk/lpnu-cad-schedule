package ua.com.lpnu.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ua.com.lpnu.demo.api.GroupApi;
import ua.com.lpnu.demo.dto.GroupDto;
import ua.com.lpnu.demo.model.Group;
import ua.com.lpnu.demo.service.MappingService;
import ua.com.lpnu.demo.service.GroupService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class GroupController implements GroupApi {

    private final GroupService groupService;
    private final MappingService mappingService;

    @Override
    public GroupDto createGroup(GroupDto groupDto) {
        log.debug(groupDto.toString());
        log.info("createGroup: with title {}", groupDto.getTitle());
        GroupDto group = groupService.createGroup(groupDto);
        return group;
    }

    @Override
    public GroupDto getGroup(Long id) {
        log.info("getGroup: with id {}", id);
        GroupDto groupDto  = groupService.getGroup(id);
        return groupDto;
    }

    @Override
    public GroupDto updateGroup(GroupDto groupDto) {
        log.info("updateGroup controller is called");
        GroupDto group = groupService.updateGroup(groupDto);
        return group;
    }

    @Override
    public ResponseEntity<Void> deleteGroup(Long id) {
        log.info("deleteGroup: with id {}", id);
        groupService.deleteGroup(id);
        return ResponseEntity.noContent().build();
    }


}
