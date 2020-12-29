package ua.com.lpnu.demo.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.com.lpnu.demo.dto.SubjectDto;
import ua.com.lpnu.demo.dto.validation.group.OnRegister;
import ua.com.lpnu.demo.dto.validation.group.OnUpdate;
import ua.com.lpnu.demo.model.Subject;

@Api(tags = "Subject management REST API")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
@RequestMapping("/subject")
public interface SubjectApi {
    @ApiOperation("Create Subject API")
    @ApiResponse(code = 201, message = "OK", response = SubjectDto.class)
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    SubjectDto createSubject(@AuthenticationPrincipal @Validated(OnRegister.class) SubjectDto subject);

    @ApiOperation("Get Subject API")
    @ApiResponse(code = 200, message = "OK", response = SubjectDto.class)
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    SubjectDto getSubject(@AuthenticationPrincipal Subject subject);

    @ApiOperation("Update Subject API")
    @ApiResponse(code = 200, message = "OK", response = SubjectDto.class)
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    SubjectDto updateSubject(@RequestBody @Validated(OnUpdate.class) SubjectDto subjectDto);

    @ApiOperation("Delete Subject API")
    @ApiResponse(code = 204, message = "No content")
    @DeleteMapping
    ResponseEntity<Void> deleteSubject(@AuthenticationPrincipal Subject subject);

}
