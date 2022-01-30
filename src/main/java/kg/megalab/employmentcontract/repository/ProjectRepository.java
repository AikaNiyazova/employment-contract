package kg.megalab.employmentcontract.repository;

import kg.megalab.employmentcontract.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    Boolean existsByIdAndIsActiveTrue(Long id);
    Optional<Project> findByIdAndIsActiveTrue(Long id);
}
