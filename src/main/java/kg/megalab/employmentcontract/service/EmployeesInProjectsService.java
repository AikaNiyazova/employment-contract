package kg.megalab.employmentcontract.service;

import kg.megalab.employmentcontract.model.dto.EmployeesInProjectsDto;
import kg.megalab.employmentcontract.model.request.CreateEmployeesInProjectsRequest;
import org.springframework.stereotype.Service;

@Service
public interface EmployeesInProjectsService {
    EmployeesInProjectsDto create(CreateEmployeesInProjectsRequest request);
    EmployeesInProjectsDto find(Long id);
    EmployeesInProjectsDto update(EmployeesInProjectsDto employeesInProjectsDto);
}
