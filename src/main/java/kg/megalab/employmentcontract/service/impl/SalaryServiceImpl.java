package kg.megalab.employmentcontract.service.impl;

import kg.megalab.employmentcontract.exceptions.SalaryNotFoundException;
import kg.megalab.employmentcontract.mapper.EmployeeMapper;
import kg.megalab.employmentcontract.mapper.SalaryMapper;
import kg.megalab.employmentcontract.model.dto.EmployeeDto;
import kg.megalab.employmentcontract.model.dto.SalaryDto;
import kg.megalab.employmentcontract.model.entity.Salary;
import kg.megalab.employmentcontract.model.request.CreateSalaryRequest;
import kg.megalab.employmentcontract.repository.SalaryRepository;
import kg.megalab.employmentcontract.service.EmployeeService;
import kg.megalab.employmentcontract.service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalaryServiceImpl implements SalaryService {

    public final SalaryRepository salaryRepository;
    public final EmployeeService employeeService;

    @Override
    public SalaryDto create(CreateSalaryRequest request) {

        EmployeeDto employeeDto = employeeService.find(request.getEmployeeId());

        Salary salary = Salary
                .builder()
                .employee(EmployeeMapper.INSTANCE.toEntity(employeeDto))
                .amount(request.getAmount())
                .build();

        return SalaryMapper.INSTANCE.toDto
                (salaryRepository.save(salary));
    }

    @Override
    public SalaryDto find(Long id) {
        return SalaryMapper.INSTANCE.toDto
                (salaryRepository.findById(id)
                        .orElseThrow(() -> new SalaryNotFoundException
                                ("Salary with id=" + id + " not found")));
    }

    @Override
    public SalaryDto update(SalaryDto salaryDto) {
        return salaryRepository
                .findById(salaryDto.getId())
                .map(salary -> {
                    salary.setAmount(salaryDto.getAmount());
                    salaryRepository.save(salary);
                    return SalaryMapper.INSTANCE.toDto(salary);
                })
                .orElseThrow(() -> new SalaryNotFoundException
                        ("Salary with id=" + salaryDto.getId() + " not found"));
    }
}
