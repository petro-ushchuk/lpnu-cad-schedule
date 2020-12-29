package ua.com.lpnu.demo.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.com.lpnu.demo.dto.GroupDto;
import ua.com.lpnu.demo.dto.validation.group.OnCreate;
import ua.com.lpnu.demo.dto.validation.group.OnRegister;
import ua.com.lpnu.demo.dto.validation.group.OnUpdate;
import ua.com.lpnu.demo.model.Group;

@Api(tags = "Group management REST API")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
@RequestMapping("/group")
public interface GroupApi {

    @ApiOperation("Create group API")
    @ApiResponse(code = 201, message = "OK", response = GroupDto.class)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    GroupDto createGroup(@AuthenticationPrincipal @Validated(OnCreate.class) @RequestBody GroupDto groupDto);

    @ApiOperation("Get group API")
    @ApiResponse(code = 200, message = "OK", response = GroupDto.class)
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    GroupDto getGroup(@AuthenticationPrincipal @PathVariable Long id);

    @ApiOperation("Update group API")
    @ApiResponse(code = 200, message = "OK", response = GroupDto.class)
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    GroupDto updateGroup(@RequestBody @Validated(OnUpdate.class) GroupDto groupDto);

    @ApiOperation("Delete group API")
    @ApiResponse(code = 204, message = "No content")
    @DeleteMapping("{id}")
    ResponseEntity<?> deleteGroup(@AuthenticationPrincipal @PathVariable Long id);

}
