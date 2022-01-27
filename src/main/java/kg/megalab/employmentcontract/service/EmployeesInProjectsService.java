package kg.megalab.employmentcontract.service;

import kg.megalab.employmentcontract.model.dto.EmployeesInProjectsDto;
import kg.megalab.employmentcontract.model.request.CreateEmployeesInProjects;
import org.springframework.stereotype.Service;

@Service
public interface EmployeesInProjectsService {
    EmployeesInProjectsDto create(CreateEmployeesInProjects request);
    EmployeesInProjectsDto find(Long id);
    EmployeesInProjectsDto update(EmployeesInProjectsDto employeesInProjectsDto);
}
