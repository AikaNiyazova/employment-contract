package kg.megalab.employmentcontract.repository;

import kg.megalab.employmentcontract.model.entity.EmployeesInProjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesInProjectsRepository extends JpaRepository<EmployeesInProjects, Long> {
    List<EmployeesInProjects> findAllByEmployeeId(Long employeeId); // ???
    List<EmployeesInProjects> findAllByProjectId(Long projectId); // ???
}
