package kg.megalab.employmentcontract.service;

import kg.megalab.employmentcontract.model.dto.EmployeeDto;
import kg.megalab.employmentcontract.model.request.CreateEmployeeRequest;
import kg.megalab.employmentcontract.model.response.MessageResponse;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    EmployeeDto create(CreateEmployeeRequest request);
    EmployeeDto find(Long id);
    EmployeeDto update(EmployeeDto employeeDto);
    MessageResponse delete(Long id);
//    void save(Employee employee);
}
