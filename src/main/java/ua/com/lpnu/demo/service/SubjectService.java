package ua.com.lpnu.demo.service;

import ua.com.lpnu.demo.dto.SubjectDto;
import ua.com.lpnu.demo.model.Subject;

public interface SubjectService {

    SubjectDto createSubject(SubjectDto subjectDto);

    SubjectDto updateSubject(SubjectDto subjectDto);

    void deleteSubject(Subject subject);

}
