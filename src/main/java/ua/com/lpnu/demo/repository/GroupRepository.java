package ua.com.lpnu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.lpnu.demo.model.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
