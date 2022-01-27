package kg.megalab.employmentcontract.repository;

import kg.megalab.employmentcontract.model.entity.EmployeesInProjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesInProjectsRepository extends JpaRepository<EmployeesInProjects, Long> {
}
