package ua.com.lpnu.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ua.com.lpnu.demo.api.SubjectApi;
import ua.com.lpnu.demo.dto.SubjectDto;
import ua.com.lpnu.demo.model.Subject;
import ua.com.lpnu.demo.service.MappingService;
import ua.com.lpnu.demo.service.SubjectService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SubjectController implements SubjectApi {

    private final SubjectService subjectService;
    private final MappingService mappingService;

    @Override
    public SubjectDto createSubject(SubjectDto subjectDto) {
        log.info("createSubject: with title {}", subjectDto.getTitle());
        SubjectDto subject = subjectService.createSubject(subjectDto);
        return subject;
    }

    @Override
    public SubjectDto getSubject(Subject Subject) {
        log.info("getSubject: with id {}", Subject.getId());
        SubjectDto subjectDto = mappingService.mapSubjectToSubjectDto(Subject);
        return subjectDto;
    }

    @Override
    public SubjectDto updateSubject(SubjectDto SubjectDto) {
        log.info("updateSubject controller is called");
        SubjectDto Subject = subjectService.updateSubject(SubjectDto);
        return Subject;
    }

    @Override
    public ResponseEntity<Void> deleteSubject(Subject subject) {
        log.info("deleteSubject: with id {}", subject.getId());
        subjectService.deleteSubject(subject);
        return ResponseEntity.noContent().build();
    }

}
