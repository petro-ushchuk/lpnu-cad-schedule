package ua.com.lpnu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.lpnu.demo.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
