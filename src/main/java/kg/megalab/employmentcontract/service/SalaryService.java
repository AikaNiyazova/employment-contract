package kg.megalab.employmentcontract.service;

import kg.megalab.employmentcontract.model.dto.SalaryDto;
import kg.megalab.employmentcontract.model.request.CreateSalaryRequest;
import kg.megalab.employmentcontract.model.response.MessageResponse;
import org.springframework.stereotype.Service;

@Service
public interface SalaryService {
    SalaryDto create(CreateSalaryRequest request);
    SalaryDto find(Long id);
    SalaryDto update(SalaryDto salaryDto);
    MessageResponse delete(Long id);
}
