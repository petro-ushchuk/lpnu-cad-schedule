package ua.com.lpnu.demo.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ua.com.lpnu.demo.dto.SubjectDto;
import ua.com.lpnu.demo.model.Subject;
import ua.com.lpnu.demo.repository.SubjectRepository;
import ua.com.lpnu.demo.service.MappingService;
import ua.com.lpnu.demo.service.SubjectService;

@Service
@Slf4j
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository SubjectRepository;
    private final MappingService mappingService;

    @Override
    public SubjectDto createSubject(SubjectDto subjectDto) {
        Subject subject = mappingService.mapSubjectDtoToSubject(subjectDto);
        log.info("About to create Subject {}", subject);
        subject = SubjectRepository.save(subject);
        log.info("Used with id {} successfully created", subject.getId());
        return mappingService.mapSubjectToSubjectDto(subject);
    }

    @Override
    public SubjectDto updateSubject(SubjectDto SubjectDto) {
        Subject Subject = mappingService.mapSubjectDtoToSubject(SubjectDto);
        log.info("About to update Subject {}", Subject);
        Subject = SubjectRepository.save(Subject);
        log.info("Used with id {} successfully updated", Subject.getId());
        return mappingService.mapSubjectToSubjectDto(Subject);
    }

    @Override
    public void deleteSubject(Subject Subject) {
        log.info("deleteSubject: about to delete Subject with email {}", Subject.getTitle());
        SecurityContextHolder.clearContext();
        SubjectRepository.delete(Subject);
    }

}